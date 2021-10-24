package in.knaps.domain.model.base;


import org.apache.commons.lang3.StringUtils;

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
}
