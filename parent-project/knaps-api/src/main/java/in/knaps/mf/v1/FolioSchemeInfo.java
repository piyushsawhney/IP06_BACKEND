package in.knaps.mf.v1;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FolioSchemeInfo {
    private String arn;
    private String arnDescription;
    private String schemeCode;
    private String schemeName;
    private Double totalUnits;
    private Double currentValue;
    private Map<String, SchemeTransactionTypeInfo> schemeTransactionTypeValues;
    private Double schemeReturns;

    public String getArn() {
        return arn;
    }

    public void setArn(String arn) {
        this.arn = arn;
    }

    public String getArnDescription() {
        return arnDescription;
    }

    public void setArnDescription(String arnDescription) {
        this.arnDescription = arnDescription;
    }

    public String getSchemeCode() {
        return schemeCode;
    }

    public void setSchemeCode(String schemeCode) {
        this.schemeCode = schemeCode;
    }

    public String getSchemeName() {
        return schemeName;
    }

    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName;
    }

    public Double getTotalUnits() {
        return totalUnits;
    }

    public void setTotalUnits(Double totalUnits) {
        this.totalUnits = totalUnits;
    }

    public Double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(Double currentValue) {
        this.currentValue = currentValue;
    }

    public Map<String, SchemeTransactionTypeInfo> getSchemeTransactionTypeValues() {
        return schemeTransactionTypeValues;
    }

    public void setSchemeTransactionTypeValues(Map<String, SchemeTransactionTypeInfo> schemeTransactionTypeValues) {
        this.schemeTransactionTypeValues = schemeTransactionTypeValues;
    }

    public Double getSchemeReturns() {
        return schemeReturns;
    }

    public void setSchemeReturns(Double schemeReturns) {
        this.schemeReturns = schemeReturns;
    }
}
