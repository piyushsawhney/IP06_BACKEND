package in.knaps.domain.model.client.details;

import in.knaps.domain.model.base.UuidValue;

import java.util.UUID;

public class ClientId extends UuidValue {
    @Override
    public UUID getValue() {
        return super.getValue();
    }

    public ClientId() {
        super();
    }

    public ClientId(UUID value) {
        super(value);
    }

    @Override
    public void setValue(String value) {
        super.setValue(value);
    }

    @Override
    public void setValue(UUID value) {
        super.setValue(value);
    }
}
