package in.knaps.api.mf.v1;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FolioSchemeSummary {
    private String folioNumber;
    private String rta;
    private String amcCode;
    private Map<String, FolioSchemeInfo> schemeInfo;

    public String getFolioNumber() {
        return folioNumber;
    }

    public void setFolioNumber(String folioNumber) {
        this.folioNumber = folioNumber;
    }

    public String getRta() {
        return rta;
    }

    public void setRta(String rta) {
        this.rta = rta;
    }

    public String getAmcCode() {
        return amcCode;
    }

    public void setAmcCode(String amcCode) {
        this.amcCode = amcCode;
    }

    public Map<String, FolioSchemeInfo> getSchemeInfo() {
        return schemeInfo;
    }

    public void setSchemeInfo(Map<String, FolioSchemeInfo> schemeInfo) {
        this.schemeInfo = schemeInfo;
    }
}
