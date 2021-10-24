package in.knaps.domain.model.base;

import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

public class UuidValue {
    UUID value;

    public UuidValue() {

    }

    public UuidValue(UUID value) {
        this.value = value;
    }

    public UUID getValue() {
        return value;
    }

    public void setValue(String value) {
        if (StringUtils.isNotEmpty(value))
            try {
                this.value = UUID.fromString(value);
            } catch (IllegalArgumentException e) {
                throw new ImproperDomainValueException("ERROR: Improper Value for entity class", e);
            }
        else
            throw new ImproperDomainValueException("ERROR: Improper Value for entity class");

    }

    public void setValue(UUID value) {
        this.value = value;

    }
}
