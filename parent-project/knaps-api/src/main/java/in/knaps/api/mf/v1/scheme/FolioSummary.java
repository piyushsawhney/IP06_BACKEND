package in.knaps.api.mf.v1.scheme;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Map;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FolioSummary {
    private String folioNumber;
    private String rta;
    private String amcCode;
    private String amcName;
    private Map<String,SchemeInfo> schemeInfo;

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

    public String getAmcName() {
        return amcName;
    }

    public void setAmcName(String amcName) {
        this.amcName = amcName;
    }

    public Map<String, SchemeInfo> getSchemeInfo() {
        return schemeInfo;
    }

    public void setSchemeInfo(Map<String, SchemeInfo> schemeInfo) {
        this.schemeInfo = schemeInfo;
    }
}
