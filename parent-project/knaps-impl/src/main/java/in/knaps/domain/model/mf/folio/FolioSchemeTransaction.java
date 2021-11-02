package in.knaps.domain.model.mf.folio;

import in.knaps.domain.model.KnapsDate;
import in.knaps.domain.model.mf.CurrencyValue;
import in.knaps.domain.model.mf.Nav;

public class FolioSchemeTransaction {
    private KnapsDate navDate;
    private TransactionDescription transactionDescription;
    private Units units;
    private Nav nav;
    private CurrencyValue grossAmount;
    private Units cumulativeUnits;
    private CurrencyValue stampDuty;
    private CurrencyValue exitLoad;
    private CurrencyValue stt;
    private CurrencyValue tax;
    private CurrencyValue netAmount;

    public KnapsDate getNavDate() {
        return navDate;
    }

    public void setNavDate(KnapsDate navDate) {
        this.navDate = navDate;
    }

    public TransactionDescription getTransactionDescription() {
        return transactionDescription;
    }

    public void setTransactionDescription(TransactionDescription transactionDescription) {
        this.transactionDescription = transactionDescription;
    }

    public Units getUnits() {
        return units;
    }

    public void setUnits(Units units) {
        this.units = units;
    }

    public Nav getNav() {
        return nav;
    }

    public void setNav(Nav nav) {
        this.nav = nav;
    }

    public CurrencyValue getGrossAmount() {
        return grossAmount;
    }

    public void setGrossAmount(CurrencyValue grossAmount) {
        this.grossAmount = grossAmount;
    }

    public Units getCumulativeUnits() {
        return cumulativeUnits;
    }

    public void setCumulativeUnits(Units cumulativeUnits) {
        this.cumulativeUnits = cumulativeUnits;
    }

    public CurrencyValue getStampDuty() {
        return stampDuty;
    }

    public void setStampDuty(CurrencyValue stampDuty) {
        this.stampDuty = stampDuty;
    }

    public CurrencyValue getExitLoad() {
        return exitLoad;
    }

    public void setExitLoad(CurrencyValue exitLoad) {
        this.exitLoad = exitLoad;
    }

    public CurrencyValue getStt() {
        return stt;
    }

    public void setStt(CurrencyValue stt) {
        this.stt = stt;
    }

    public CurrencyValue getTax() {
        return tax;
    }

    public void setTax(CurrencyValue tax) {
        this.tax = tax;
    }

    public CurrencyValue getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(CurrencyValue netAmount) {
        this.netAmount = netAmount;
    }
}
