package in.knaps;

import com.google.inject.Inject;
import in.knaps.domain.model.client.ClientDbFactory;
import in.knaps.domain.model.client.details.ClientDetails;
import in.knaps.domain.model.client.details.ClientId;

import java.util.List;

public interface KnapsApplication {
    List<ClientDetails> getClientList();

    ClientDetails getClientDetailedInfo(ClientId clientId);

    List<ClientDetails> getFamilyMemberDetails(ClientId clientId);
}
