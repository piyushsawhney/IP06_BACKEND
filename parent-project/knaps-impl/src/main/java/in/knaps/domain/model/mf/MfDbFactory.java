package in.knaps.domain.model.mf;

import in.knaps.domain.model.client.details.ClientId;
import in.knaps.domain.model.mf.folio.*;
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

    SchemeInformation getSchemeInformation(@Nonnull FolioNumber folioNumber, @Nonnull SchemeCode schemeCode);


}
