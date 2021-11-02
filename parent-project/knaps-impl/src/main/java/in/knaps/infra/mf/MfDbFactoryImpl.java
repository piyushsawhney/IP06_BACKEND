package in.knaps.infra.mf;

import com.google.inject.Inject;
import in.knaps.domain.HoldingNature;
import in.knaps.domain.model.HolderDetails;
import in.knaps.domain.model.KnapsDate;
import in.knaps.domain.model.bank.*;
import in.knaps.domain.model.base.Validator;
import in.knaps.domain.model.client.address.*;
import in.knaps.domain.model.client.details.*;
import in.knaps.domain.model.db.DatabaseException;
import in.knaps.domain.model.db.EntityNotFoundException;
import in.knaps.domain.model.db.PostgresConnection;
import in.knaps.domain.model.mf.*;
import in.knaps.domain.model.mf.folio.*;
import in.knaps.domain.model.nominee.NomineeDetails;
import in.knaps.domain.model.nominee.Percentage;
import in.knaps.domain.model.nominee.Relation;
import org.apache.commons.lang3.StringUtils;
import org.decampo.xirr.Transaction;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;

import javax.annotation.Nonnull;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MfDbFactoryImpl implements MfDbFactory {

    @Inject
    private PostgresConnection postgresConnection;


    @Override
    public List<FolioDetails> getClientFolioListFromDb(@Nonnull ClientId clientId) {
        Validator.isNotNull(clientId);
//        ResultSet rs = executeSelectQuery(MfSqlStatement.CLIENT_FOLIO_INFO.replace("{clientId}", clientId.getValue().toString()));
        ResultSet rs = executeSelectQuery(MfSqlStatement.CLIENT_FOLIO_INFO.replace("{clientId}", "AASPR8041G"));
        List<FolioDetails> folioDetailsArrayList = new ArrayList<>();
        try {
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    FolioNumber folioNumber = new FolioNumber(rs.getString("folio_number"));
                    if (!folioDetailsArrayList.contains(new FolioDetails(folioNumber))) {
                        FolioDetails folioDetails = new FolioDetails();
                        folioDetails.setFolioNumber(folioNumber);
                        String rtaString = rs.getString("rta_name");
                        if (rtaString.equalsIgnoreCase("cams")) {
                            folioDetails.setRta(Rta.CAMS);
                        } else if (rtaString.equalsIgnoreCase("karvy")) {
                            folioDetails.setRta(Rta.KARVY);
                        }
                        folioDetails.setAmcCode(new AmcCode(rs.getString("amc_code")));
                        SchemeBasicInfo schemeInfo = new SchemeBasicInfo();
                        schemeInfo.setArn(new Arn(rs.getString("arn")));
                        schemeInfo.setSchemeName(new SchemeName(rs.getString("scheme_name")));
                        schemeInfo.setTotalUnits(new Units(rs.getDouble("total_units")));
                        schemeInfo.setSchemeCode(new SchemeCode(rs.getString("scheme_code")));
                        Map<SchemeCode, SchemeBasicInfo> schemeInfoMap = new HashMap<>();
                        schemeInfoMap.put(schemeInfo.getSchemeCode(), schemeInfo);
                        folioDetails.setSchemeInfoMap(schemeInfoMap);
                        folioDetailsArrayList.add(folioDetails);
                    } else {
                        SchemeBasicInfo schemeInfo = new SchemeBasicInfo();
                        schemeInfo.setArn(new Arn(rs.getString("arn")));
                        schemeInfo.setSchemeName(new SchemeName(rs.getString("scheme_name")));
                        schemeInfo.setTotalUnits(new Units(rs.getDouble("total_units")));
                        schemeInfo.setSchemeCode(new SchemeCode(rs.getString("scheme_code")));
                        folioDetailsArrayList.get(folioDetailsArrayList.indexOf(new FolioDetails(folioNumber)))
                                .getSchemeInfoMap().put(schemeInfo.getSchemeCode(), schemeInfo);
                    }
                }
            }
        } catch (SQLException e) {
            throw new DatabaseException("ERROR: Query statement creation failed", e);
        }
        return folioDetailsArrayList;
    }

    @Override
    public Map<TransactionType, SchemeTransactionTypeValue> getTransactionTypeDetails(@Nonnull FolioNumber folioNumber, @Nonnull SchemeCode schemeCode) {
        Validator.isNotNull(folioNumber);
        Validator.isNotNull(schemeCode);
        ResultSet rs = executeSelectQuery(MfSqlStatement.TRANSACTION_GROUPS
                .replace("{folioNumber}", folioNumber.getValue())
                .replace("{schemeCode}", schemeCode.getValue()));
        Map<TransactionType, SchemeTransactionTypeValue> schemeTransactionTypeValueMap = new HashMap<>();
        try {
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    String transactionCode = rs.getString("transaction_code");
                    switch (transactionCode.toUpperCase()) {
                        case "P":
                            populateTransactionTypeMap(schemeTransactionTypeValueMap, TransactionType.P, rs);
                            break;
                        case "PR":
                            populateTransactionTypeMap(schemeTransactionTypeValueMap, TransactionType.PR, rs);
                            break;
                        case "R":
                            populateTransactionTypeMap(schemeTransactionTypeValueMap, TransactionType.R, rs);
                            break;
                        case "RR":
                            populateTransactionTypeMap(schemeTransactionTypeValueMap, TransactionType.RR, rs);
                            break;
                        case "DR":
                            populateTransactionTypeMap(schemeTransactionTypeValueMap, TransactionType.DR, rs);
                            break;
                        case "DRR":
                            populateTransactionTypeMap(schemeTransactionTypeValueMap, TransactionType.DRR, rs);
                            break;
                        case "DP":
                            populateTransactionTypeMap(schemeTransactionTypeValueMap, TransactionType.DP, rs);
                            break;
                        case "DPR":
                            populateTransactionTypeMap(schemeTransactionTypeValueMap, TransactionType.DPR, rs);
                            break;
                        case "SI":
                            populateTransactionTypeMap(schemeTransactionTypeValueMap, TransactionType.SI, rs);
                            break;
                        case "SIR":
                            populateTransactionTypeMap(schemeTransactionTypeValueMap, TransactionType.SIR, rs);
                            break;
                        case "SO":
                            populateTransactionTypeMap(schemeTransactionTypeValueMap, TransactionType.SI, rs);
                            break;
                        case "SOR":
                            populateTransactionTypeMap(schemeTransactionTypeValueMap, TransactionType.SOR, rs);
                            break;
                    }
                }

            }
        } catch (
                SQLException e) {
            throw new DatabaseException("ERROR: Query statement creation failed", e);
        }
        return schemeTransactionTypeValueMap;
    }

    @Override
    public Nav getCurrentNav(@Nonnull SchemeCode schemeCode) {
        Validator.isNotNull(schemeCode);
        ResultSet rs = executeSelectQuery(MfSqlStatement.CURRENT_NAV
                .replace("{schemeCode}", schemeCode.getValue()));
        try {
            if (rs.isBeforeFirst()) {
                rs.next();
                return new Nav(rs.getDouble("nav"));
            }
        } catch (SQLException e) {
            throw new DatabaseException("ERROR: Query statement creation failed", e);
        }
        return new Nav(0.0);
    }

    @Override
    public CurrencyValue getSchemeCurrentValue(@Nonnull FolioNumber folioNumber, @Nonnull SchemeCode schemeCode) {
        Validator.isNotNull(schemeCode);
        ResultSet rs = executeSelectQuery(MfSqlStatement.CURRENT_VALUE
                .replace("{folioNumber}", folioNumber.getValue())
                .replace("{schemeCode}", schemeCode.getValue())
                .replace("{schemeCode}", schemeCode.getValue()));
        try {
            if (rs.isBeforeFirst()) {
                rs.next();
                return new CurrencyValue(rs.getDouble("currentValue"));
            }
        } catch (SQLException e) {
            throw new DatabaseException("ERROR: Query statement creation failed", e);
        }
        return new CurrencyValue(0.0);
    }


    @Override
    public List<Transaction> getSchemeTransactionList(@Nonnull FolioNumber folioNumber, @Nonnull SchemeCode schemeCode) {
        Validator.isNotNull(folioNumber);
        Validator.isNotNull(schemeCode);
        ResultSet rs = executeSelectQuery(MfSqlStatement.TRANSACTION_INFO_FOR_RETURN
                .replace("{schemeCode}", schemeCode.getValue())
                .replace("{folioNumber}", folioNumber.getValue()));

        List<Transaction> list = null;
        try {
            if (rs.isBeforeFirst()) {
                list = new ArrayList<>();
                while (rs.next()) {
                    Transaction transaction = new Transaction(rs.getDouble("gross_amount"), rs.getDate("nav_date").toLocalDate());
                    list.add(transaction);
                }
            }
            return list;
        } catch (SQLException e) {
            throw new DatabaseException("ERROR: Query statement creation failed", e);
        }
    }

    @Override
    public SchemeInformation getSchemeInformation(@Nonnull FolioNumber folioNumber, @Nonnull SchemeCode schemeCode) {
        Validator.isNotNull(folioNumber);
        Validator.isNotNull(schemeCode);
        ResultSet rs = executeSelectQuery(MfSqlStatement.SCHEME_INFORMATION
                .replace("{schemeCode}", schemeCode.getValue())
                .replace("{folioNumber}", folioNumber.getValue()));

        try {
            if (rs.isBeforeFirst()) {
                rs.next();
                return populateSchemeInformation(rs);
            } else {
                throw new EntityNotFoundException(String.format("ERROR: Folio number %s and schemeCode %s does not exist", folioNumber, schemeCode));
            }
        } catch (
                SQLException e) {
            throw new DatabaseException("ERROR: Query statement creation failed", e);
        }

    }

    @Override
    public List<FolioSchemeTransaction> getSchemeTransactions(@Nonnull FolioNumber folioNumber, @Nonnull SchemeCode schemeCode) {
        Validator.isNotNull(folioNumber);
        Validator.isNotNull(schemeCode);
        ResultSet rs = executeSelectQuery(MfSqlStatement.SCHEME_TRANSACTION
                .replace("{schemeCode}", schemeCode.getValue())
                .replace("{folioNumber}", folioNumber.getValue()));
        List<FolioSchemeTransaction> list = new ArrayList<>();

        try {
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    FolioSchemeTransaction folioSchemeTransaction = new FolioSchemeTransaction();
                    folioSchemeTransaction.setNavDate(
                            new KnapsDate(LocalDate.parse(rs.getString("nav_date"),
                                    DateTimeFormat.forPattern("yyyy-MM-dd"))));
                    folioSchemeTransaction.setTransactionDescription(
                            new TransactionDescription(String.format("%s %s",
                                    rs.getString("transaction_type"),
                                    rs.getString("transaction_suffix"))));
                    folioSchemeTransaction.setUnits(new Units(rs.getDouble("units")));
                    folioSchemeTransaction.setNav(new Nav(rs.getDouble("nav")));
                    folioSchemeTransaction.setNav(new Nav(rs.getDouble("nav")));
                    folioSchemeTransaction.setGrossAmount(new CurrencyValue(rs.getDouble("gross_amount")));
                    folioSchemeTransaction.setCumulativeUnits(new Units(rs.getDouble("cumulative_units")));
                    folioSchemeTransaction.setStampDuty(new CurrencyValue(rs.getDouble("stamp_duty")));
                    folioSchemeTransaction.setExitLoad(new CurrencyValue(rs.getDouble("exit_load")));
                    folioSchemeTransaction.setStt(new CurrencyValue(rs.getDouble("stt")));
                    folioSchemeTransaction.setTax(new CurrencyValue(rs.getDouble("tax")));
                    folioSchemeTransaction.setNetAmount(new CurrencyValue(rs.getDouble("net_amount")));
                    list.add(folioSchemeTransaction);
                }
            } else {
                throw new EntityNotFoundException(String.format("ERROR: Folio number %s and schemeCode %s does not exist", folioNumber, schemeCode));
            }
        } catch (
                SQLException e) {
            throw new DatabaseException("ERROR: Query statement creation failed", e);
        }
        return list;

    }

    private ResultSet executeSelectQuery(String sqlStatement) {
        try {
            return postgresConnection.getConnection().createStatement().executeQuery(sqlStatement);
        } catch (SQLException e) {
            throw new DatabaseException("ERROR: Query statement creation failed", e);
        }
    }


    private void populateTransactionTypeMap(Map<TransactionType, SchemeTransactionTypeValue> map, TransactionType transactionType, ResultSet resultSet) throws SQLException {
        map.put(transactionType, new SchemeTransactionTypeValue(
                new Units(resultSet.getDouble("units")),
                new CurrencyValue(resultSet.getDouble("value"))));
    }

    private SchemeInformation populateSchemeInformation(ResultSet resultSet) throws SQLException {
        SchemeInformation schemeInformation = new SchemeInformation();
        if (StringUtils.isNotEmpty(resultSet.getString("arn"))) {
            schemeInformation.setArn(new Arn(resultSet.getString("arn")));
        }
        if (StringUtils.isNotEmpty(resultSet.getString("arn_desc"))) {
            schemeInformation.setArnDescription(new ArnDescription(resultSet.getString("arn_desc")));
        }
        if (StringUtils.isNotEmpty(resultSet.getString("folio_number"))) {
            schemeInformation.setFolioNumber(new FolioNumber(resultSet.getString("folio_number")));
        }
        if (StringUtils.isNotEmpty(resultSet.getString("scheme_code"))) {
            schemeInformation.setSchemeCode(new SchemeCode(resultSet.getString("scheme_code")));
        }
        if (StringUtils.isNotEmpty(resultSet.getString("scheme_name"))) {
            schemeInformation.setSchemeName(new SchemeName(resultSet.getString("scheme_name")));
        }
        if (StringUtils.isNotEmpty(resultSet.getString("investor_mobile"))) {
            schemeInformation.setMobile(new Mobile(resultSet.getString("investor_mobile")));
        }
        if (StringUtils.isNotEmpty(resultSet.getString("investor_email"))) {
            schemeInformation.setEmailAddress(new EmailAddress(resultSet.getString("investor_email")));
        }
        if (StringUtils.isNotEmpty(resultSet.getString("holding_nature"))) {
            String holdingNature = resultSet.getString("holding_nature");
            if (holdingNature.toLowerCase().contains("si")) {
                schemeInformation.setHoldingNature(HoldingNature.SI);
            } else if (holdingNature.toLowerCase().contains("as")
                    || holdingNature.toLowerCase().contains("es")
                    || holdingNature.toLowerCase().contains("survivor")) {
                schemeInformation.setHoldingNature(HoldingNature.AS);
            } else if (holdingNature.toLowerCase().contains("joint")
                    || holdingNature.toLowerCase().contains("jo")) {
                schemeInformation.setHoldingNature(HoldingNature.JT);
            }
        }
        if (StringUtils.isNotEmpty(resultSet.getString("investor_name"))) {
            schemeInformation.setFirstHolder(populateHolder(
                    resultSet, "investor_name", "pan", "investor_ckyc", "client_id"));
        }
        if (StringUtils.isNotEmpty(resultSet.getString("joint1_name"))) {
            schemeInformation.setSecondHolder(populateHolder(
                    resultSet, "joint1_name", "joint1_pan", "joint1_ckyc", "joint1_id"));
        }
        if (StringUtils.isNotEmpty(resultSet.getString("joint2_name"))) {
            schemeInformation.setThirdHolder(populateHolder(
                    resultSet, "joint2_name", "joint2_pan", "joint2_ckyc", "joint2_id"));
        }
        if (StringUtils.isNotEmpty(resultSet.getString("guardian_name"))) {
            schemeInformation.setGuardian(populateHolder(
                    resultSet, "guardian_name", "guardian_pan", "guardian_ckyc", "guardian_id"));
        }
        if (StringUtils.isNotEmpty(resultSet.getString("bank_name"))) {
            BankDetails bankDetails = new BankDetails();
            bankDetails.setBankName(new BankName(resultSet.getString("bank_name")));
            if (StringUtils.isNotEmpty(resultSet.getString("bank_branch")))
                bankDetails.setBankBranch(new BankBranch(resultSet.getString("bank_branch")));
            if (StringUtils.isNotEmpty(resultSet.getString("bank_account_no")))
                bankDetails.setBankAccountNo(new BankAccountNo(resultSet.getString("bank_account_no")));
            if (StringUtils.isNotEmpty(resultSet.getString("bank_ifsc")))
                bankDetails.setBankIfsc(new BankIfsc(resultSet.getString("bank_ifsc")));
            if (StringUtils.isNotEmpty(resultSet.getString("bank_account_type")))
                bankDetails.setBankAccountType(new BankAccountType(resultSet.getString("bank_account_type")));
            schemeInformation.setBankDetails(bankDetails);
        }
        if (StringUtils.isNotEmpty(resultSet.getString("nominee1_name"))) {
            schemeInformation.setFirstNominee(populateNomineeDetails(
                    resultSet, "nominee1_name", "nominee1_percentage", "nominee1_relation"));
        }
        if (StringUtils.isNotEmpty(resultSet.getString("nominee2_name"))) {
            schemeInformation.setSecondNominee(populateNomineeDetails(
                    resultSet, "nominee2_name", "nominee2_percentage", "nominee2_relation"));
        }
        if (StringUtils.isNotEmpty(resultSet.getString("nominee3_name"))) {
            schemeInformation.setSecondNominee(populateNomineeDetails(
                    resultSet, "nominee3_name", "nominee3_percentage", "nominee3_relation"));
        }
        if (StringUtils.isNotEmpty(resultSet.getString("investor_address1"))) {
            Address address = new Address();
            address.setAddress1(new Address1(resultSet.getString("investor_address1")));
            if (StringUtils.isNotEmpty(resultSet.getString("investor_address2"))) {
                address.setAddress2(new Address2(resultSet.getString("investor_address2")));
            }
            if (StringUtils.isNotEmpty(resultSet.getString("investor_address3"))) {
                address.setAddress3(new Address3(resultSet.getString("investor_address3")));
            }
            if (StringUtils.isNotEmpty(resultSet.getString("investor_city"))) {
                address.setCity(new City(resultSet.getString("investor_city")));
            }
            if (StringUtils.isNotEmpty(resultSet.getString("investor_pincode"))) {
                address.setPinCode(new PinCode(resultSet.getString("investor_pincode")));
            }
            schemeInformation.setClientAddress(address);
        }
        return schemeInformation;
    }


    private HolderDetails populateHolder(ResultSet resultSet, String nameLabel, String panLabel, String cKycLabel, String clientIdLabel) throws SQLException {
        HolderDetails holderDetails = new HolderDetails();
        holderDetails.setClientName(new Name(resultSet.getString(nameLabel)));
        if (StringUtils.isNotEmpty(resultSet.getString(panLabel))) {
            holderDetails.setClientPan(new Pan(resultSet.getString(panLabel)));
        }
        if (StringUtils.isNotEmpty(resultSet.getString(cKycLabel))) {
            holderDetails.setCkycNumber(new CkycNumber(resultSet.getString(cKycLabel)));
        }
//            if (StringUtils.isNotEmpty(resultSet.getString(clientIdLabel))) {
//                holderDetails.setClientId(new ClientId(resultSet.getString(clientIdLabel)));
//            }
        return holderDetails;
    }

    private NomineeDetails populateNomineeDetails(ResultSet resultSet, String nameLabel, String percentageLabel, String relationLabel) throws SQLException {
        NomineeDetails nomineeDetails = new NomineeDetails();
        nomineeDetails.setNomineeName(new Name(resultSet.getString(nameLabel)));
        nomineeDetails.setNomineeRelation(new Relation(resultSet.getString(relationLabel)));
        nomineeDetails.setNomineePercentage(new Percentage(resultSet.getFloat(percentageLabel)));
        return nomineeDetails;
    }
}
