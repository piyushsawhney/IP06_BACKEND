package in.knaps;

import in.knaps.mf.v1.*;

import java.util.List;

public class MfApiV1Impl implements MfApiV1 {


    @Override
    public List<FolioSchemeSummary> getClientFolioList(String clientId) {
        return null;
    }

    @Override
    public FolioSchemeDetails getFolioDetails(String clientId, String folioNumber) {
        return null;
    }

    @Override
    public List<ClientSystematicList> getClientSystematicList(String clientId) {
        return null;
    }

    @Override
    public FolioTransactionDetails getFolioTransactionDetails(String clientId, String folioNumber, String schemeCode) {
        return null;
    }
}
