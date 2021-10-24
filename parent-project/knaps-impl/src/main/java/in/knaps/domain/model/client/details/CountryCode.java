package in.knaps.domain.model.client.details;

import in.knaps.domain.model.base.ImproperDomainValueException;
import in.knaps.domain.model.base.StringIdValue;
import org.apache.commons.lang3.StringUtils;

public class CountryCode extends StringIdValue {
    @Override
    public void setValue(String value) {
        if (validateCountryCode(value)) {
            super.value = value;
        }
    }

    public CountryCode(String value) {
        if (validateCountryCode(value)) {
            super.value = value;
        }
    }

    public CountryCode() {
        super();
    }

    @Override
    public String getValue() {
        return super.getValue();
    }

    private boolean validateCountryCode(String value) {
        String regex = "^(\\+?\\d{1,3}|\\d{1,4})$";
        if (StringUtils.isNotEmpty(value) && value.matches(regex))
            return true;
        else
            throw new ImproperDomainValueException("Improper Value for entity class");
    }
}
