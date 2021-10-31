package in.knaps.domain;

import in.knaps.domain.model.base.StringIdValue;

public class HoldingNature extends StringIdValue {
    public static HoldingNature SI = new HoldingNature("SI");
    public static HoldingNature AS = new HoldingNature("AS");
    public static HoldingNature JT = new HoldingNature("JT");

    private HoldingNature(String value) {
        super(value);
    }

    @Override
    public String getValue() {
        return super.getValue();
    }

}
