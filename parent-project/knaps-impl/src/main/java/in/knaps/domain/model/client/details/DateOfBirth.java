package in.knaps.domain.model.client.details;

import in.knaps.domain.model.base.DateValue;
import org.joda.time.LocalDate;


public class DateOfBirth extends DateValue {
    public DateOfBirth() {
        super();
    }

    public DateOfBirth(LocalDate date) {
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
