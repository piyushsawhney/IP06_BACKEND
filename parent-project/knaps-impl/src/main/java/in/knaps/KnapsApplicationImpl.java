package in.knaps;

import com.google.inject.Inject;
import in.knaps.domain.model.client.ClientDbFactory;
import in.knaps.domain.model.client.details.ClientDetails;
import in.knaps.domain.model.client.details.ClientId;
import in.knaps.domain.model.mf.CurrencyValue;
import in.knaps.domain.model.mf.MfDbFactory;
import in.knaps.domain.model.mf.Return;
import in.knaps.domain.model.mf.TransactionType;
import in.knaps.domain.model.mf.folio.*;
import in.knaps.domain.model.mf.processing.MfValueCalculator;
import org.decampo.xirr.Transaction;

import javax.annotation.Nonnull;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class KnapsApplicationImpl implements KnapsApplication {
    @Inject
    private ClientDbFactory clientDbFactory;

    @Inject
    private MfDbFactory mfDbFactory;

    @Inject
    private MfValueCalculator mfValueCalculator;

    @Override
    public List<ClientDetails> getClientList() {
        return clientDbFactory.getClientListFromDb();
    }

    @Override
    public ClientDetails getClientDetailedInfo(@Nonnull ClientId clientId) {
        return clientDbFactory.getClientDetailedInfoFromDb(clientId);
    }

    @Override
    public List<ClientDetails> getFamilyMemberDetails(@Nonnull ClientId clientId) {
        return clientDbFactory.getFamilyMemberDetailsFromDb(clientId);
    }

    @Override
    public List<FolioDetails> getClientFolios(@Nonnull ClientId clientId) {
//        clientDbFactory.validateClient(clientId);
        List<FolioDetails> folioDetailList = mfDbFactory.getClientFolioListFromDb(clientId);

        folioDetailList.forEach(folio -> folio.getSchemeInfoMap()
                .forEach((schemeCode, schemeInfo) ->
                        schemeInfo.setCurrentValue(
                                mfValueCalculator.calculateCurrentValue
                                        (folio.getFolioNumber(), schemeCode, schemeInfo.getTotalUnits()))));
        return folioDetailList;
    }

    @Override
    public Return getClientSchemeReturn(@Nonnull ClientId clientId, @Nonnull FolioNumber folioNumber, @Nonnull SchemeCode schemeCode) {
//        clientDbFactory.validateClient(clientId);
        List<Transaction> transactionList = mfDbFactory.getSchemeTransactionList(folioNumber, schemeCode);
        CurrencyValue currentValue = mfDbFactory.getSchemeCurrentValue(folioNumber, schemeCode);
        if (currentValue.getValue() != 0.0) {
            transactionList.add(new Transaction(-currentValue.getValue(), LocalDate.now()));
        }
        return mfValueCalculator.calculateSchemeReturn(transactionList);
    }

    @Override
    public Map<TransactionType, SchemeTransactionTypeValue> getSchemeSummaryValue(@Nonnull ClientId clientId, @Nonnull FolioNumber folioNumber, @Nonnull SchemeCode schemeCode) {
        //        clientDbFactory.validateClient(clientId);

        return mfDbFactory.getTransactionTypeDetails(folioNumber, schemeCode);
    }

    @Override
    public SchemeInformation getSchemeDetails(@Nonnull ClientId clientId, @Nonnull FolioNumber folioNumber, @Nonnull SchemeCode schemeCode) {
        //        clientDbFactory.validateClient(clientId);
        return mfDbFactory.getSchemeInformation(folioNumber, schemeCode);
    }

    @Override
    public List<FolioSchemeTransaction>  getSchemeTransactions(@Nonnull ClientId clientId, @Nonnull FolioNumber folioNumber, @Nonnull SchemeCode schemeCode) {
//        clientDbFactory.validateClient(clientId);
        return mfDbFactory.getSchemeTransactions(folioNumber, schemeCode);
    }
}
