package in.knaps.infra.mf;

import com.google.inject.Inject;
import in.knaps.domain.model.base.Validator;
import in.knaps.domain.model.client.details.ClientId;
import in.knaps.domain.model.db.DatabaseException;
import in.knaps.domain.model.db.PostgresConnection;
import in.knaps.domain.model.mf.*;
import in.knaps.domain.model.mf.folio.*;
import org.decampo.xirr.Transaction;

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
}
