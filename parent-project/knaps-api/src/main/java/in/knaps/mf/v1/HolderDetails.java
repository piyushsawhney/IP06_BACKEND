package in.knaps.mf.v1;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class HolderDetails {
    String clientId;
    String holderName;
    String holderPan;
    String holderCKycNumber;

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

    public String getHolderCKycNumber() {
        return holderCKycNumber;
    }

    public void setHolderCKycNumber(String holderCKycNumber) {
        this.holderCKycNumber = holderCKycNumber;
    }
}
