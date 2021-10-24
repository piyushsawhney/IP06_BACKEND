package in.knaps.client.v1;


import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientBasicInfo {
    private String clientId;
    private String clientName;
    private String clientPan;

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientPan() {
        return clientPan;
    }

    public void setClientPan(String clientPan) {
        this.clientPan = clientPan;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
}
