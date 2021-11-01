package in.knaps.api;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class HolderDetails {
    String clientId;
    String holderName;
    String holderPan;
    String cKycNumber;
    String cif;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getHolderPan() {
        return holderPan;
    }

    public void setHolderPan(String holderPan) {
        this.holderPan = holderPan;
    }

    public String getcKycNumber() {
        return cKycNumber;
    }

    public void setcKycNumber(String cKycNumber) {
        this.cKycNumber = cKycNumber;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }
}
