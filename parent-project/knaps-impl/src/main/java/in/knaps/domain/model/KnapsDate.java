package in.knaps.domain.model;

import in.knaps.domain.model.base.DateValue;
import org.joda.time.LocalDate;


public class KnapsDate extends DateValue {
    public KnapsDate() {
        super();
    }

    public KnapsDate(LocalDate date) {
        super(date);
    }

    @Override
    public LocalDate getDate() {
        return super.getDate();
    }

    @Override
    public void setDate(LocalDate date) {
        super.setDate(date);
    }
}
