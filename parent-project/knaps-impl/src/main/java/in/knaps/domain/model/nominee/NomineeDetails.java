package in.knaps.domain.model.nominee;

import in.knaps.domain.model.client.details.ClientId;
import in.knaps.domain.model.client.details.Name;

public class NomineeDetails {
    private ClientId clientId;
    private Name nomineeName;
    private Relation nomineeRelation;
    private Percentage nomineePercentage;

    public ClientId getClientId() {
        return clientId;
    }

    public void setClientId(ClientId clientId) {
        this.clientId = clientId;
    }

    public Name getNomineeName() {
        return nomineeName;
    }

    public void setNomineeName(Name nomineeName) {
        this.nomineeName = nomineeName;
    }

    public Relation getNomineeRelation() {
        return nomineeRelation;
    }

    public void setNomineeRelation(Relation nomineeRelation) {
        this.nomineeRelation = nomineeRelation;
    }

    public Percentage getNomineePercentage() {
        return nomineePercentage;
    }

    public void setNomineePercentage(Percentage nomineePercentage) {
        this.nomineePercentage = nomineePercentage;
    }
}
