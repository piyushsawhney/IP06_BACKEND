package in.knaps.domain.model.mf;

import in.knaps.domain.model.client.details.ClientId;
import in.knaps.domain.model.mf.folio.FolioDetails;
import in.knaps.domain.model.mf.folio.FolioNumber;
import in.knaps.domain.model.mf.folio.SchemeCode;
import in.knaps.domain.model.mf.folio.SchemeTransactionTypeValue;
import org.decampo.xirr.Transaction;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Map;

public interface MfDbFactory {
    List<FolioDetails> getClientFolioListFromDb(@Nonnull ClientId clientId);

    Map<TransactionType, SchemeTransactionTypeValue> getTransactionTypeDetails(@Nonnull FolioNumber folioNumber, @Nonnull SchemeCode schemeCode);

    Nav getCurrentNav(@Nonnull SchemeCode schemeCode);

    CurrencyValue getSchemeCurrentValue(@Nonnull FolioNumber folioNumber, @Nonnull SchemeCode schemeCode);

    List<Transaction> getSchemeTransactionList(@Nonnull FolioNumber folioNumber, @Nonnull SchemeCode schemeCode);


}
