package in.knaps.domain.model;

import in.knaps.domain.model.client.details.CkycNumber;
import in.knaps.domain.model.client.details.ClientId;
import in.knaps.domain.model.client.details.Name;
import in.knaps.domain.model.client.details.Pan;

public class HolderDetails {
    private ClientId clientId;
    private Name clientName;
    private Pan clientPan;
    private CkycNumber ckycNumber;

    public CkycNumber getCkycNumber() {
        return ckycNumber;
    }

    public void setCkycNumber(CkycNumber ckycNumber) {
        this.ckycNumber = ckycNumber;
    }

    public ClientId getClientId() {
        return clientId;
    }

    public void setClientId(ClientId clientId) {
        this.clientId = clientId;
    }

    public Name getClientName() {
        return clientName;
    }

    public void setClientName(Name clientName) {
        this.clientName = clientName;
    }

    public Pan getClientPan() {
        return clientPan;
    }

    public void setClientPan(Pan clientPan) {
        this.clientPan = clientPan;
    }
}
