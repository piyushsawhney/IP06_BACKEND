package in.knaps.domain.model.client.details;

import in.knaps.domain.model.base.ImproperDomainValueException;
import in.knaps.domain.model.base.StringIdValue;
import org.apache.commons.validator.routines.EmailValidator;

public class EmailAddress extends StringIdValue {
    @Override
    public void setValue(String value) {
        if (validateEmailAddress(value)) {
            super.value = value;
        }
    }

    public EmailAddress(String value) {
        if (validateEmailAddress(value)) {
            super.value = value;
        }
    }

    public EmailAddress() {
        super();
    }

    @Override
    public String getValue() {
        return super.getValue();
    }

    private boolean validateEmailAddress(String value) {
        if (EmailValidator.getInstance().isValid(value))
            return true;
        else
            throw new ImproperDomainValueException("Improper Value for entity class");
    }
}
