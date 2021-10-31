package in.knaps.domain.model.base;

public class IntValue {
    protected int value;

    public IntValue() {
    }

    public IntValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
