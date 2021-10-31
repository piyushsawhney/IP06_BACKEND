package in.knaps.domain.model.mf.folio;

import in.knaps.domain.model.base.StringIdValue;

public class Rta extends StringIdValue {
    public static Rta CAMS = new Rta("CAMS");
    public static Rta KARVY = new Rta("KARVY");

    private Rta(String value) {
        super(value);
    }

    @Override
    public String getValue() {
        return super.getValue();
    }
}
