package in.knaps.domain.model.mf.processing;

import in.knaps.domain.model.mf.CurrencyValue;
import in.knaps.domain.model.mf.Return;
import in.knaps.domain.model.mf.TransactionType;
import in.knaps.domain.model.mf.folio.*;
import org.decampo.xirr.Transaction;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Map;

public interface MfValueCalculator {
    Map<TransactionType, SchemeTransactionTypeValue> calculateTransactionTypeAmount(@Nonnull FolioDetails folioDetails);

    CurrencyValue calculateCurrentValue(@Nonnull FolioNumber folioNumber, @Nonnull SchemeCode schemeCode, @Nonnull Units totalUnits);

    Return calculateReturn(@Nonnull FolioNumber folioNumber, @Nonnull SchemeCode schemeCode, @Nonnull Units totalUnits, @Nonnull CurrencyValue currentValue);

    Return calculateSchemeReturn(@Nonnull List<Transaction> transactionList);
}
