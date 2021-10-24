package in.knaps.domain.model.client;

import in.knaps.domain.model.client.details.ClientDetails;
import in.knaps.domain.model.client.details.ClientId;

import java.util.List;

public interface ClientDbFactory {
    List<ClientDetails> getClientListFromDb();

    ClientDetails getClientDetailedInfoFromDb(ClientId clientId);

    List<ClientDetails> getFamilyMemberDetailsFromDb(ClientId clientId);
}
