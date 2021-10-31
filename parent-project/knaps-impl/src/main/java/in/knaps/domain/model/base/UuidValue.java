package in.knaps.domain.model.base;

import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

public class UuidValue {
    UUID value;

    public UuidValue() {

    }

    public UuidValue(String value) {

        setUuidValue(value);
    }

    public UUID getValue() {
        return value;
    }

    public void setValue(String value) {
        setUuidValue(value);

    }

    private void setUuidValue(String uuidString) {
        if (StringUtils.isNotEmpty(uuidString))
            try {
                this.value = UUID.fromString(uuidString);
            } catch (IllegalArgumentException e) {
                throw new ImproperDomainValueException("ERROR: Improper Value for entity class", e);
            }
        else
            throw new ImproperDomainValueException("ERROR: Improper Value for entity class");
    }
}
