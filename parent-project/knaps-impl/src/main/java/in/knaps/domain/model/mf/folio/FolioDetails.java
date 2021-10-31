package in.knaps.domain.model.mf.folio;

import in.knaps.domain.model.mf.AmcCode;

import java.util.Map;
import java.util.Objects;

public class FolioDetails {
    private FolioNumber folioNumber;
    private Rta rta;
    private AmcCode amcCode;
    private Map<SchemeCode, SchemeBasicInfo> schemeInfoMap;

    public FolioDetails() {
    }

    public FolioDetails(FolioNumber folioNumber) {
        this.folioNumber = folioNumber;
    }

    public FolioNumber getFolioNumber() {
        return folioNumber;
    }

    public void setFolioNumber(FolioNumber folioNumber) {
        this.folioNumber = folioNumber;
    }

    public Rta getRta() {
        return rta;
    }

    public void setRta(Rta rta) {
        this.rta = rta;
    }

    public AmcCode getAmcCode() {
        return amcCode;
    }

    public void setAmcCode(AmcCode amcCode) {
        this.amcCode = amcCode;
    }

    public Map<SchemeCode, SchemeBasicInfo> getSchemeInfoMap() {
        return schemeInfoMap;
    }

    public void setSchemeInfoMap(Map<SchemeCode, SchemeBasicInfo> schemeInfoMap) {
        this.schemeInfoMap = schemeInfoMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FolioDetails)) return false;
        FolioDetails that = (FolioDetails) o;
        return Objects.equals(folioNumber, that.folioNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(folioNumber);
    }
}
