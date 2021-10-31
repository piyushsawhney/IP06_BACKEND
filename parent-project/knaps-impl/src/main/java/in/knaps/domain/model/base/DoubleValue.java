package in.knaps.domain.model.base;

public class DoubleValue {
    protected Double value;

    public DoubleValue() {
    }

    public DoubleValue(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
