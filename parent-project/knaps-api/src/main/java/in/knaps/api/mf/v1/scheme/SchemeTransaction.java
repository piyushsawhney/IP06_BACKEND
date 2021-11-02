package in.knaps.api.mf.v1.scheme;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SchemeTransaction {
    private String navDate;
    private String transactionDescription;
    private Double units;
    private Double nav;
    private Double grossAmount;
    private Double cumulativeUnits;
    private Double stampDuty;
    private Double exitLoad;
    private Double stt;
    private Double tax;
    private Double netAmount;

    public String getNavDate() {
        return navDate;
    }

    public void setNavDate(String navDate) {
        this.navDate = navDate;
    }

    public String getTransactionDescription() {
        return transactionDescription;
    }

    public void setTransactionDescription(String transactionDescription) {
        this.transactionDescription = transactionDescription;
    }

    public Double getUnits() {
        return units;
    }

    public void setUnits(Double units) {
        this.units = units;
    }

    public Double getNav() {
        return nav;
    }

    public void setNav(Double nav) {
        this.nav = nav;
    }

    public Double getGrossAmount() {
        return grossAmount;
    }

    public void setGrossAmount(Double grossAmount) {
        this.grossAmount = grossAmount;
    }

    public Double getCumulativeUnits() {
        return cumulativeUnits;
    }

    public void setCumulativeUnits(Double cumulativeUnits) {
        this.cumulativeUnits = cumulativeUnits;
    }

    public Double getStampDuty() {
        return stampDuty;
    }

    public void setStampDuty(Double stampDuty) {
        this.stampDuty = stampDuty;
    }

    public Double getExitLoad() {
        return exitLoad;
    }

    public void setExitLoad(Double exitLoad) {
        this.exitLoad = exitLoad;
    }

    public Double getStt() {
        return stt;
    }

    public void setStt(Double stt) {
        this.stt = stt;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(Double netAmount) {
        this.netAmount = netAmount;
    }
}
