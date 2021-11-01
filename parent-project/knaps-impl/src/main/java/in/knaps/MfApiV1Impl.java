package in.knaps;

import com.google.inject.Inject;
import in.knaps.api.Address;
import in.knaps.api.BankDetails;
import in.knaps.api.HolderDetails;
import in.knaps.api.NomineeDetails;
import in.knaps.api.mf.v1.FolioSystematicDetails;
import in.knaps.api.mf.v1.FolioTransactionDetails;
import in.knaps.api.mf.v1.MfApiV1;
import in.knaps.api.mf.v1.scheme.*;
import in.knaps.domain.model.base.ImproperDomainValueException;
import in.knaps.domain.model.base.Validator;
import in.knaps.domain.model.client.details.ClientId;
import in.knaps.domain.model.mf.folio.FolioNumber;
import in.knaps.domain.model.mf.folio.SchemeCode;
import in.knaps.domain.model.mf.folio.SchemeInformation;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MfApiV1Impl implements MfApiV1 {

    @Inject
    private KnapsApplication knapsApplication;

    @Override
    public List<FolioSummary> getClientFolios(String clientId) {
        Validator.checkWebArgument(clientId);
        try {
            return knapsApplication.getClientFolios(new ClientId(clientId)).stream()
                    .map(p -> {
                        FolioSummary folioSummary = new FolioSummary();
                        folioSummary.setFolioNumber(p.getFolioNumber().getValue());
                        folioSummary.setAmcCode(p.getAmcCode().getValue());
                        folioSummary.setRta(p.getRta().getValue());
                        folioSummary.setSchemeInfo(p.getSchemeInfoMap().entrySet().stream().collect(Collectors.toMap(
                                schemeCode -> schemeCode.getKey().getValue(),
                                schemeBasicInfo -> {
                                    SchemeInfo schemeInfo = new SchemeInfo();
                                    schemeInfo.setArn(schemeBasicInfo.getValue().getArn().getValue());
                                    if (schemeBasicInfo.getValue().getArnDescription() != null)
                                        schemeInfo.setArnDescription(schemeBasicInfo.getValue().getArnDescription().getValue());
                                    schemeInfo.setSchemeCode(schemeBasicInfo.getValue().getSchemeCode().getValue());
                                    schemeInfo.setSchemeName(schemeBasicInfo.getValue().getSchemeName().getValue());
                                    schemeInfo.setTotalUnits(schemeBasicInfo.getValue().getTotalUnits().getValue());
                                    schemeInfo.setCurrentValue(schemeBasicInfo.getValue().getCurrentValue().getValue());
                                    return schemeInfo;
                                })));
                        return folioSummary;
                    }).collect(Collectors.toList());
        } catch (ImproperDomainValueException e) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
    }

    @Override
    public SchemeReturn getClientSchemeReturn(String clientId, FolioSchemeRequest schemeReturnRequest) {
        Validator.checkWebArgument(clientId);
        Validator.checkWebArgument(schemeReturnRequest.getSchemeCode());
        Validator.checkWebArgument(schemeReturnRequest.getFolioNumber());
        return new SchemeReturn(knapsApplication.getClientSchemeReturn(
                new ClientId(clientId),
                new FolioNumber(schemeReturnRequest.getFolioNumber()),
                new SchemeCode(schemeReturnRequest.getSchemeCode())).getValue());
    }

    @Override
    public Map<String, SchemeSummary> getClientSchemeSummary(String clientId, FolioSchemeRequest schemeReturnRequest) {
        Validator.checkWebArgument(clientId);
        Validator.checkWebArgument(schemeReturnRequest.getSchemeCode());
        Validator.checkWebArgument(schemeReturnRequest.getFolioNumber());
        return knapsApplication.getSchemeSummaryValue(
                new ClientId(clientId),
                new FolioNumber(schemeReturnRequest.getFolioNumber()),
                new SchemeCode(schemeReturnRequest.getSchemeCode())).entrySet().stream().collect(Collectors.toMap(
                schemeCode -> schemeCode.getKey().getValue(),
                schemeTransactionTypeValue -> {
                    SchemeSummary schemeSummary = new SchemeSummary();
                    schemeSummary.setCurrentValue(schemeTransactionTypeValue.getValue().getMoneyValue().getValue());
                    schemeSummary.setTotalUnits(schemeTransactionTypeValue.getValue().getUnits().getValue());
                    return schemeSummary;
                }
        ));
    }

    @Override
    public SchemeDetails getSchemeDetails(String clientId, FolioSchemeRequest schemeReturnRequest) {
        Validator.checkWebArgument(clientId);
        Validator.checkWebArgument(schemeReturnRequest.getSchemeCode());
        Validator.checkWebArgument(schemeReturnRequest.getFolioNumber());

        return populateSchemeDetails(knapsApplication.getSchemeDetails(
                new ClientId(clientId),
                new FolioNumber(schemeReturnRequest.getFolioNumber()),
                new SchemeCode(schemeReturnRequest.getSchemeCode())));
    }

    @Override
    public List<FolioSystematicDetails> getClientSystematicList(String clientId) {
        return null;
    }

    @Override
    public FolioTransactionDetails getFolioTransactionDetails(String clientId, String folioNumber, String schemeCode) {
        return null;
    }

    private SchemeDetails populateSchemeDetails(SchemeInformation schemeInformation) {
        SchemeDetails schemeDetails = new SchemeDetails();
        if (schemeInformation.getArn() != null) {
            schemeDetails.setArn(schemeInformation.getArn().getValue());
        }
        if (schemeInformation.getArnDescription() != null) {
            schemeDetails.setArnDescription(schemeInformation.getArnDescription().getValue());
        }
        if (schemeInformation.getFolioNumber() != null) {
            schemeDetails.setFolioNumber(schemeInformation.getFolioNumber().getValue());
        }
        if (schemeInformation.getSchemeCode() != null) {
            schemeDetails.setSchemeCode(schemeInformation.getSchemeCode().getValue());
        }
        if (schemeInformation.getSchemeName() != null) {
            schemeDetails.setSchemeName(schemeInformation.getSchemeName().getValue());
        }
        if (schemeInformation.getMobile() != null) {
            schemeDetails.setMobile(schemeInformation.getMobile().getValue());
        }
        if (schemeInformation.getEmailAddress() != null) {
            schemeDetails.setEmailAddress(schemeInformation.getEmailAddress().getValue());
        }
        if (schemeInformation.getHoldingNature() != null) {
            schemeDetails.setHoldingNature(schemeInformation.getHoldingNature().getValue());
        }
        if (schemeInformation.getFirstHolder() != null) {
            schemeDetails.setFirstHolder(populateHolder(schemeInformation.getFirstHolder()));

        }
        if (schemeInformation.getSecondHolder() != null) {
            schemeDetails.setSecondHolder(populateHolder(schemeInformation.getSecondHolder()));

        }
        if (schemeInformation.getThirdHolder() != null) {
            schemeDetails.setThirdHolder(populateHolder(schemeInformation.getThirdHolder()));
        }
        if (schemeInformation.getGuardian() != null) {
            schemeDetails.setGuardianDetails(populateHolder(schemeInformation.getGuardian()));
        }
        if (schemeInformation.getBankDetails() != null) {
            BankDetails bankDetails = new BankDetails();
            if (schemeInformation.getBankDetails().getBankName() != null)
                bankDetails.setBankName(schemeInformation.getBankDetails().getBankName().getValue());
            if (schemeInformation.getBankDetails().getBankBranch() != null)
                bankDetails.setBankBranch(schemeInformation.getBankDetails().getBankBranch().getValue());
            if (schemeInformation.getBankDetails().getBankAccountType() != null)
                bankDetails.setAccountType(schemeInformation.getBankDetails().getBankAccountType().getValue());
            if (schemeInformation.getBankDetails().getBankIfsc() != null)
                bankDetails.setBankIfsc(schemeInformation.getBankDetails().getBankIfsc().getValue());
            if (schemeInformation.getBankDetails().getBankAccountNo() != null)
                bankDetails.setBankAccountNumber(schemeInformation.getBankDetails().getBankAccountNo().getValue());
            schemeDetails.setBankDetails(bankDetails);
        }
        if (schemeInformation.getFirstNominee() != null) {
            schemeDetails.setFirstNominee(populateNominee(schemeInformation.getFirstNominee()));
        }
        if (schemeInformation.getSecondNominee() != null) {
            schemeDetails.setSecondNominee(populateNominee(schemeInformation.getSecondNominee()));
        }
        if (schemeInformation.getThirdNominee() != null) {
            schemeDetails.setThirdNominee(populateNominee(schemeInformation.getThirdNominee()));
        }
        if (schemeInformation.getClientAddress() != null) {
            Address address = new Address();
            if (schemeInformation.getClientAddress().getAddress1() != null)
                address.setAddress1(schemeInformation.getClientAddress().getAddress1().getValue());
            if (schemeInformation.getClientAddress().getAddress2() != null)
                address.setAddress2(schemeInformation.getClientAddress().getAddress2().getValue());
            if (schemeInformation.getClientAddress().getAddress3() != null)
                address.setAddress3(schemeInformation.getClientAddress().getAddress3().getValue());
            if (schemeInformation.getClientAddress().getCity() != null)
                address.setCity(schemeInformation.getClientAddress().getCity().getValue());
            if (schemeInformation.getClientAddress().getPinCode() != null)
                address.setPinCode(schemeInformation.getClientAddress().getPinCode().getValue());
            schemeDetails.setClientAddress(address);
        }
        return schemeDetails;
    }

    private HolderDetails populateHolder(in.knaps.domain.model.HolderDetails holderInfo) {
        HolderDetails holderDetails = new HolderDetails();
        if (holderInfo.getClientName() != null) {
            holderDetails.setHolderName(holderInfo.getClientName().getValue());
        }
        if (holderInfo.getClientPan() != null) {
            holderDetails.setHolderPan(holderInfo.getClientPan().getValue());
        }
        if (holderInfo.getClientId() != null) {
            holderDetails.setClientId(holderInfo.getClientId().getValue().toString());
        }
        if (holderInfo.getCkycNumber() != null) {
            holderDetails.setcKycNumber(holderInfo.getCkycNumber().getValue());
        }
        return holderDetails;
    }

    private NomineeDetails populateNominee(in.knaps.domain.model.nominee.NomineeDetails nomineeInfo) {
        NomineeDetails nomineeDetails = new NomineeDetails();
        if (nomineeInfo.getNomineeName() != null) {
            nomineeDetails.setNomineeName(nomineeInfo.getNomineeName().getValue());
        }
        if (nomineeInfo.getNomineeRelation() != null) {
            nomineeDetails.setNomineeRelation(nomineeInfo.getNomineeRelation().getValue());
        }
        if (nomineeInfo.getNomineePercentage() != null) {
            nomineeDetails.setNomineePercentage(nomineeInfo.getNomineePercentage().getValue());
        }
        return nomineeDetails;
    }
}
