package in.knaps.domain.model.client.details;

import in.knaps.domain.model.base.ImproperDomainValueException;
import in.knaps.domain.model.base.StringIdValue;
import org.apache.commons.lang3.StringUtils;

public class PhoneNumber extends StringIdValue {
    @Override
    public void setValue(String value) {
        super.value = value;
    }

    public PhoneNumber(String value) {
        super.value = value;
    }

    public PhoneNumber() {
        super();
    }

    @Override
    public String getValue() {
        return super.getValue();
    }
}
