package in.knaps;

import in.knaps.domain.model.client.details.ClientDetails;
import in.knaps.domain.model.client.details.ClientId;
import in.knaps.domain.model.mf.Return;
import in.knaps.domain.model.mf.TransactionType;
import in.knaps.domain.model.mf.folio.*;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Map;

public interface KnapsApplication {
    List<ClientDetails> getClientList();

    ClientDetails getClientDetailedInfo(@Nonnull ClientId clientId);

    List<ClientDetails> getFamilyMemberDetails(@Nonnull ClientId clientId);

    List<FolioDetails> getClientFolios(@Nonnull ClientId clientId);

    Return getClientSchemeReturn(@Nonnull ClientId clientId, @Nonnull FolioNumber folioNumber, @Nonnull SchemeCode schemeCode);

    Map<TransactionType, SchemeTransactionTypeValue> getSchemeSummaryValue(@Nonnull ClientId clientId, @Nonnull FolioNumber folioNumber, @Nonnull SchemeCode schemeCode);

    SchemeInformation getSchemeDetails(@Nonnull ClientId clientId, @Nonnull FolioNumber folioNumber, @Nonnull SchemeCode schemeCode);

}
