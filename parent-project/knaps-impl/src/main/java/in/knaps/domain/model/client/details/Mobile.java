package in.knaps.domain.model.client.details;

import in.knaps.domain.model.base.ImproperDomainValueException;
import in.knaps.domain.model.base.StringIdValue;
import org.apache.commons.lang3.StringUtils;

public class Mobile extends StringIdValue {
    @Override
    public void setValue(String value) {
        if (validateMobileNumber(value)) {
            super.value = value;
        }
    }

    public Mobile(String value) {
        if (validateMobileNumber(value)) {
            super.value = value;
        }
    }

    public Mobile() {
        super();
    }

    @Override
    public String getValue() {
        return super.getValue();
    }

    private boolean validateMobileNumber(String value) {
        String regex = "^\\d*$";
        if (StringUtils.isNotEmpty(value) && value.matches(regex) && value.length() <= 10)
            return true;
        else
            throw new ImproperDomainValueException("Improper Value for entity class");
    }
}
