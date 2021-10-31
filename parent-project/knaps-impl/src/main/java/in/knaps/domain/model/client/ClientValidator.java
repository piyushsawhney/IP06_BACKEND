package in.knaps.domain.model.client;

import in.knaps.domain.model.client.details.ClientId;

import javax.annotation.Nonnull;

public interface ClientValidator {
    void validateClient(@Nonnull ClientId clientId);
}
