package in.knaps.domain.model.client.details;

import in.knaps.domain.model.base.ImproperDomainValueException;
import in.knaps.domain.model.base.StringIdValue;
import org.apache.commons.lang3.StringUtils;

public class Pan extends StringIdValue {
    @Override
    public void setValue(String value) {
        if (validatePan(value)) {
            super.value = value.toUpperCase();
        }
    }

    public Pan(String value) {
        if (validatePan(value)) {
            super.value = value.toUpperCase();
        }
    }

    public Pan() {
        super();
    }

    @Override
    public String getValue() {
        return super.getValue();
    }

    private boolean validatePan(String value) {
        String regex = "^[a-zA-Z]{5}[0-9]{4}[a-zA-Z]{1}$";
        if (StringUtils.isNotEmpty(value) && value.matches(regex))
            return true;
        else
            throw new ImproperDomainValueException("Improper Value for entity class");
    }
}
