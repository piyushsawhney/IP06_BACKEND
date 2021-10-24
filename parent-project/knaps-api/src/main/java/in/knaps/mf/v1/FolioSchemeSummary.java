package in.knaps.mf.v1;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FolioSchemeSummary {
    String folioNumber;
    String schemeName;
    String schemeCode;
    Double costValue;
    Double redemptions;
    Double switchIns;
    Double switchOuts;
    Double currentValue;
    Double totalUnits;
    Float returns;

    public String getFolioNumber() {
        return folioNumber;
    }

    public void setFolioNumber(String folioNumber) {
        this.folioNumber = folioNumber;
    }

    public String getSchemeName() {
        return schemeName;
    }

    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName;
    }

    public String getSchemeCode() {
        return schemeCode;
    }

    public void setSchemeCode(String schemeCode) {
        this.schemeCode = schemeCode;
    }

    public Double getCostValue() {
        return costValue;
    }

    public void setCostValue(Double costValue) {
        this.costValue = costValue;
    }

    public Double getRedemptions() {
        return redemptions;
    }

    public void setRedemptions(Double redemptions) {
        this.redemptions = redemptions;
    }

    public Double getSwitchIns() {
        return switchIns;
    }

    public void setSwitchIns(Double switchIns) {
        this.switchIns = switchIns;
    }

    public Double getSwitchOuts() {
        return switchOuts;
    }

    public void setSwitchOuts(Double switchOuts) {
        this.switchOuts = switchOuts;
    }

    public Double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(Double currentValue) {
        this.currentValue = currentValue;
    }

    public Double getTotalUnits() {
        return totalUnits;
    }

    public void setTotalUnits(Double totalUnits) {
        this.totalUnits = totalUnits;
    }

    public Float getReturns() {
        return returns;
    }

    public void setReturns(Float returns) {
        this.returns = returns;
    }
}
