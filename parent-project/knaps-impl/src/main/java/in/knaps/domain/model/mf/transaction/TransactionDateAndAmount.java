package in.knaps.domain.model.mf.transaction;

import org.decampo.xirr.Transaction;

import java.time.LocalDate;
import java.util.Date;

public class TransactionDateAndAmount extends Transaction {

    public TransactionDateAndAmount(double amount, LocalDate when) {
        super(amount, when);
    }

    public TransactionDateAndAmount(double amount, Date when) {
        super(amount, when);
    }

    public TransactionDateAndAmount(double amount, String when) {
        super(amount, when);
    }

}
