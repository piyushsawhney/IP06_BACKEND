package in.knaps.domain.model.mf.processing;

import com.google.inject.Inject;
import in.knaps.domain.model.base.Validator;
import in.knaps.domain.model.mf.*;
import in.knaps.domain.model.mf.folio.*;
import org.decampo.xirr.OverflowException;
import org.decampo.xirr.Transaction;
import org.decampo.xirr.Xirr;

import javax.annotation.Nonnull;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class MfValueCalculatorImpl implements MfValueCalculator {
    @Inject
    private MfDbFactory mfDbFactory;


    @Override
    public Map<TransactionType, SchemeTransactionTypeValue> calculateTransactionTypeAmount(@Nonnull FolioDetails folioDetails) {

        return null;
    }

    @Override
    public CurrencyValue calculateCurrentValue(@Nonnull FolioNumber folioNumber, @Nonnull SchemeCode schemeCode, @Nonnull Units totalUnits) {
        if (totalUnits.getValue() != 0) {
            Validator.isNotNull(folioNumber);
            Validator.isNotNull(schemeCode);
            Validator.isNotNull(totalUnits);
            Nav currentNav = mfDbFactory.getCurrentNav(schemeCode);
            CurrencyValue currentValue = new CurrencyValue();
            currentValue.setValue(currentNav.getValue() * totalUnits.getValue());
            return currentValue;
        } else {
            return new CurrencyValue(0.0);
        }

    }

    @Override
    public Return calculateReturn(@Nonnull FolioNumber folioNumber, @Nonnull SchemeCode schemeCode, @Nonnull Units totalUnits, @Nonnull CurrencyValue currentValue) {
        Validator.isNotNull(folioNumber);
        Validator.isNotNull(schemeCode);
        Validator.isNotNull(schemeCode);
        List<Transaction> transactionList = mfDbFactory.getSchemeTransactionList(folioNumber, schemeCode);
        if (totalUnits.getValue() > 0.01) {
            transactionList.add(new Transaction(-currentValue.getValue(), LocalDate.now()));
        }
        double rate = 0.0;
        try {
            rate = Xirr.builder().withTransactions(transactionList).build().xirr();
        } catch (OverflowException e) {
            System.out.printf("Folio number: %s, SchemeCode: %s\n", folioNumber.getValue(), schemeCode.getValue());
        }
        return new Return(rate);
    }

    @Override
    public Return calculateSchemeReturn(@Nonnull List<Transaction> transactionList) {
        double rate = 0.0;
        try {
            rate = Xirr.builder().withTransactions(transactionList).build().xirr();
        } catch (OverflowException e) {
            System.out.println("Exception");
        }
        return new Return(rate);
    }

}
