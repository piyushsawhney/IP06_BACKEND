package in.knaps.domain.model.mf.folio;

import in.knaps.domain.model.mf.*;

import java.util.Map;

public class SchemeBasicInfo {
    private Arn arn;
    private ArnDescription arnDescription;
    private SchemeCode schemeCode;
    private SchemeName schemeName;
    private Units totalUnits;
    private CurrencyValue currentValue;
    private Map<TransactionType, SchemeTransactionTypeValue> schemeTransactionTypeValueMap;
    private Return schemeReturns;

    public SchemeCode getSchemeCode() {
        return schemeCode;
    }

    public void setSchemeCode(SchemeCode schemeCode) {
        this.schemeCode = schemeCode;
    }

    public Arn getArn() {
        return arn;
    }

    public void setArn(Arn arn) {
        this.arn = arn;
    }

    public ArnDescription getArnDescription() {
        return arnDescription;
    }

    public void setArnDescription(ArnDescription arnDescription) {
        this.arnDescription = arnDescription;
    }

    public SchemeName getSchemeName() {
        return schemeName;
    }

    public void setSchemeName(SchemeName schemeName) {
        this.schemeName = schemeName;
    }

    public Units getTotalUnits() {
        return totalUnits;
    }

    public void setTotalUnits(Units totalUnits) {
        this.totalUnits = totalUnits;
    }

    public CurrencyValue getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(CurrencyValue currentValue) {
        this.currentValue = currentValue;
    }

    public Map<TransactionType, SchemeTransactionTypeValue> getSchemeTransactionTypeValueMap() {
        return schemeTransactionTypeValueMap;
    }

    public void setSchemeTransactionTypeValueMap(Map<TransactionType, SchemeTransactionTypeValue> schemeTransactionTypeValueMap) {
        this.schemeTransactionTypeValueMap = schemeTransactionTypeValueMap;
    }

    public Return getSchemeReturns() {
        return schemeReturns;
    }

    public void setSchemeReturns(Return schemeReturns) {
        this.schemeReturns = schemeReturns;
    }
}

