package in.knaps;

import com.google.inject.Inject;
import in.knaps.domain.model.base.ImproperDomainValueException;
import in.knaps.domain.model.base.Validator;
import in.knaps.domain.model.client.details.ClientId;
import in.knaps.domain.model.mf.folio.FolioNumber;
import in.knaps.domain.model.mf.folio.SchemeBasicInfo;
import in.knaps.domain.model.mf.folio.SchemeCode;
import in.knaps.mf.v1.*;
import in.knaps.mf.v1.scheme.FolioSummary;
import in.knaps.mf.v1.scheme.SchemeInfo;
import in.knaps.mf.v1.scheme.SchemeReturn;
import in.knaps.mf.v1.scheme.FolioSchemeRequest;

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
    public List<FolioSchemeSummary> getClientFolioList(String clientId) {
        Validator.checkWebArgument(clientId);
        try {
            return knapsApplication.getClientFolioList(new ClientId(clientId)).stream()
                    .map(p -> {
                        FolioSchemeSummary folioSchemeSummary = new FolioSchemeSummary();
                        folioSchemeSummary.setFolioNumber(p.getFolioNumber().getValue());
                        folioSchemeSummary.setAmcCode(p.getAmcCode().getValue());
                        folioSchemeSummary.setRta(p.getRta().getValue());
                        folioSchemeSummary.setSchemeInfo(populateSchemeDetails(p.getSchemeInfoMap()));

                        return folioSchemeSummary;
                    }).collect(Collectors.toList());
        } catch (ImproperDomainValueException e) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }

    }

    private Map<String, FolioSchemeInfo> populateSchemeDetails(Map<SchemeCode, SchemeBasicInfo> map) {
        return map.entrySet().stream().collect(Collectors.toMap(
                schemeCode -> schemeCode.getKey().getValue(),
                schemeInfo -> {
                    FolioSchemeInfo folioSchemeInfo = new FolioSchemeInfo();
                    folioSchemeInfo.setArn(schemeInfo.getValue().getArn().getValue());
                    folioSchemeInfo.setSchemeName(schemeInfo.getValue().getSchemeName().getValue());
                    folioSchemeInfo.setTotalUnits(schemeInfo.getValue().getTotalUnits().getValue());
                    folioSchemeInfo.setCurrentValue(schemeInfo.getValue().getCurrentValue().getValue());
                    folioSchemeInfo.setSchemeReturns(schemeInfo.getValue().getSchemeReturns().getValue());
                    folioSchemeInfo.setSchemeTransactionTypeValues(
                            schemeInfo.getValue().getSchemeTransactionTypeValueMap().entrySet().stream().collect(Collectors.toMap(
                                    transactionType -> transactionType.getKey().getValue(),
                                    transactionTypeValues -> {
                                        SchemeTransactionTypeInfo schemeTransactionTypeInfo = new SchemeTransactionTypeInfo();
                                        schemeTransactionTypeInfo.setMoneyValue(transactionTypeValues.getValue().getMoneyValue().getValue());
                                        schemeTransactionTypeInfo.setUnits(transactionTypeValues.getValue().getUnits().getValue());
                                        return schemeTransactionTypeInfo;
                                    })));
                    return folioSchemeInfo;
                }));
    }


    @Override
    public FolioSchemeDetails getFolioDetails(String clientId, String folioNumber) {
        return null;
    }

    @Override
    public List<FolioSystematicDetails> getClientSystematicList(String clientId) {
        return null;
    }

    @Override
    public FolioTransactionDetails getFolioTransactionDetails(String clientId, String folioNumber, String schemeCode) {
        return null;
    }
}
