package in.knaps.domain.model.base;


import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class StringIdValue {
    protected String value;

    public StringIdValue() {
    }

    public StringIdValue(String value) {
        if (StringUtils.isNotEmpty(value))
            this.value = value.trim();
        else
            throw new ImproperDomainValueException("Improper Value for entity class");
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        if (StringUtils.isNotEmpty(value))
            this.value = value.trim();
        else
            throw new ImproperDomainValueException("Improper Value for entity class");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StringIdValue)) return false;
        StringIdValue that = (StringIdValue) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
