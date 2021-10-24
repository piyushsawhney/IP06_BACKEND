package in.knaps;

import com.google.inject.Inject;
import in.knaps.domain.model.client.ClientDbFactory;
import in.knaps.domain.model.client.details.ClientDetails;
import in.knaps.domain.model.client.details.ClientId;

import java.util.List;

public class KnapsApplicationImpl implements KnapsApplication {
    @Inject
    private ClientDbFactory clientDbFactory;

    @Override
    public List<ClientDetails> getClientList() {
        return clientDbFactory.getClientListFromDb();
    }

    @Override
    public ClientDetails getClientDetailedInfo(ClientId clientId) {
        return clientDbFactory.getClientDetailedInfoFromDb(clientId);
    }

    @Override
    public List<ClientDetails> getFamilyMemberDetails(ClientId clientId) {
        return clientDbFactory.getFamilyMemberDetailsFromDb(clientId);
    }
}
