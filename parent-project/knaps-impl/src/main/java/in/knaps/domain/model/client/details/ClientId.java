package in.knaps.domain.model.client.details;

import in.knaps.domain.model.base.UuidValue;

import java.util.UUID;

public class ClientId extends UuidValue {
    public ClientId() {
        super();
    }

    public ClientId(String value) {
        super(value);
    }

    @Override
    public UUID getValue() {
        return super.getValue();
    }

    @Override
    public void setValue(String value) {
        super.setValue(value);
    }
}
