package in.knaps.domain.model.base;

public class FloatValue {
    protected Float value;

    public FloatValue() {
    }

    public FloatValue(Float value) {
        this.value = value;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }
}
