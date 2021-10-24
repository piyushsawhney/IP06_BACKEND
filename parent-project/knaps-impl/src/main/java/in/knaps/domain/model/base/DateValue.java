package in.knaps.domain.model.base;

import org.joda.time.LocalDate;

public class DateValue {
    protected LocalDate date;

    public DateValue() {

    }

    public DateValue(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
