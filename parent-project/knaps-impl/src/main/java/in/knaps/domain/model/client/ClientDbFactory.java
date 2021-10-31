package in.knaps.domain.model.client;

import in.knaps.domain.model.client.details.ClientDetails;
import in.knaps.domain.model.client.details.ClientId;

import javax.annotation.Nonnull;
import java.util.List;

public interface ClientDbFactory {
    List<ClientDetails> getClientListFromDb();

    ClientDetails getClientDetailedInfoFromDb(@Nonnull ClientId clientId);

    List<ClientDetails> getFamilyMemberDetailsFromDb(@Nonnull ClientId clientId);

    void validateClient(@Nonnull ClientId clientId);

}
