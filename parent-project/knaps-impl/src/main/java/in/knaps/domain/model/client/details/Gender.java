package in.knaps.domain.model.client.details;

import in.knaps.domain.model.base.StringIdValue;

public class Gender extends StringIdValue {
    public static Gender MALE = new Gender("MALE");
    public static Gender FEMALE = new Gender("FEMALE");
    public static Gender OTHERS = new Gender("OTHERS");

    private Gender(String value) {
        super(value);
    }

    @Override
    public String getValue() {
        return super.getValue();
    }

}
