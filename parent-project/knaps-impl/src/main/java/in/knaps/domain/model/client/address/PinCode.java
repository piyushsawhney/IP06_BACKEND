package in.knaps.domain.model.client.address;

import in.knaps.domain.model.base.StringIdValue;

public class PinCode extends StringIdValue {
    public void setForeignPinCode(String value) {
        super.setValue(value);
    }

    public void setIndianPinCode(String value) {
        if (value.length() == 6) {
            super.setValue(value);
        }
    }

    @Override
    public String getValue() {
        return super.getValue();
    }
}
