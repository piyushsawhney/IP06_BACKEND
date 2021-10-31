package in.knaps.domain.model.mf.folio;

import in.knaps.domain.model.mf.CurrencyValue;

public class SchemeTransactionTypeValue {
    private Units units;
    private CurrencyValue moneyValue;

    public Units getUnits() {
        return units;
    }

    public SchemeTransactionTypeValue() {
    }

    public SchemeTransactionTypeValue(Units units, CurrencyValue currencyValue) {
        this.units = units;
        this.moneyValue = currencyValue;
    }

    public void setUnits(Units units) {
        this.units = units;
    }

    public CurrencyValue getMoneyValue() {
        return moneyValue;
    }

    public void setMoneyValue(CurrencyValue moneyValue) {
        this.moneyValue = moneyValue;
    }
}
