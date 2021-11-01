package in.knaps.domain.model.mf.folio;



import in.knaps.domain.HoldingNature;
import in.knaps.domain.model.HolderDetails;
import in.knaps.domain.model.bank.BankDetails;
import in.knaps.domain.model.client.address.Address;
import in.knaps.domain.model.client.details.EmailAddress;
import in.knaps.domain.model.client.details.Mobile;
import in.knaps.domain.model.mf.Arn;
import in.knaps.domain.model.mf.ArnDescription;
import in.knaps.domain.model.nominee.NomineeDetails;

public class SchemeInformation extends SchemeBasicInfo {
    private Arn Arn;
    private ArnDescription ArnDescription;
    private FolioNumber folioNumber;
    private SchemeCode schemeCode;
    private SchemeName schemeName;
    private Mobile mobile;
    private EmailAddress emailAddress;
    private HoldingNature holdingNature;
    private HolderDetails firstHolder;
    private HolderDetails secondHolder;
    private HolderDetails thirdHolder;
    private HolderDetails guardian;
    private BankDetails bankDetails;
    private NomineeDetails firstNominee;
    private NomineeDetails secondNominee;
    private NomineeDetails thirdNominee;
    private Address clientAddress;

    @Override
    public in.knaps.domain.model.mf.Arn getArn() {
        return Arn;
    }

    @Override
    public void setArn(in.knaps.domain.model.mf.Arn arn) {
        Arn = arn;
    }

    @Override
    public in.knaps.domain.model.mf.ArnDescription getArnDescription() {
        return ArnDescription;
    }

    @Override
    public void setArnDescription(in.knaps.domain.model.mf.ArnDescription arnDescription) {
        ArnDescription = arnDescription;
    }

    public FolioNumber getFolioNumber() {
        return folioNumber;
    }

    public void setFolioNumber(FolioNumber folioNumber) {
        this.folioNumber = folioNumber;
    }

    @Override
    public SchemeCode getSchemeCode() {
        return schemeCode;
    }

    @Override
    public void setSchemeCode(SchemeCode schemeCode) {
        this.schemeCode = schemeCode;
    }

    @Override
    public SchemeName getSchemeName() {
        return schemeName;
    }

    @Override
    public void setSchemeName(SchemeName schemeName) {
        this.schemeName = schemeName;
    }

    public Mobile getMobile() {
        return mobile;
    }

    public void setMobile(Mobile mobile) {
        this.mobile = mobile;
    }

    public EmailAddress getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(EmailAddress emailAddress) {
        this.emailAddress = emailAddress;
    }

    public HoldingNature getHoldingNature() {
        return holdingNature;
    }

    public void setHoldingNature(HoldingNature holdingNature) {
        this.holdingNature = holdingNature;
    }

    public HolderDetails getFirstHolder() {
        return firstHolder;
    }

    public void setFirstHolder(HolderDetails firstHolder) {
        this.firstHolder = firstHolder;
    }

    public HolderDetails getSecondHolder() {
        return secondHolder;
    }

    public void setSecondHolder(HolderDetails secondHolder) {
        this.secondHolder = secondHolder;
    }

    public HolderDetails getThirdHolder() {
        return thirdHolder;
    }

    public void setThirdHolder(HolderDetails thirdHolder) {
        this.thirdHolder = thirdHolder;
    }

    public HolderDetails getGuardian() {
        return guardian;
    }

    public void setGuardian(HolderDetails guardian) {
        this.guardian = guardian;
    }

    public BankDetails getBankDetails() {
        return bankDetails;
    }

    public void setBankDetails(BankDetails bankDetails) {
        this.bankDetails = bankDetails;
    }

    public NomineeDetails getFirstNominee() {
        return firstNominee;
    }

    public void setFirstNominee(NomineeDetails firstNominee) {
        this.firstNominee = firstNominee;
    }

    public NomineeDetails getSecondNominee() {
        return secondNominee;
    }

    public void setSecondNominee(NomineeDetails secondNominee) {
        this.secondNominee = secondNominee;
    }

    public NomineeDetails getThirdNominee() {
        return thirdNominee;
    }

    public void setThirdNominee(NomineeDetails thirdNominee) {
        this.thirdNominee = thirdNominee;
    }

    public Address getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(Address clientAddress) {
        this.clientAddress = clientAddress;
    }
}

