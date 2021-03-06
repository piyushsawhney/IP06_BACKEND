package in.knaps.api.mf.v1.scheme;

import com.fasterxml.jackson.annotation.JsonInclude;
import in.knaps.api.Address;
import in.knaps.api.BankDetails;
import in.knaps.api.HolderDetails;
import in.knaps.api.NomineeDetails;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SchemeDetails {
    private String Arn;
    private String ArnDescription;
    private String folioNumber;
    private String schemeCode;
    private String schemeName;
    private String mobile;
    private String emailAddress;
    private HolderDetails firstHolder;
    private HolderDetails secondHolder;
    private HolderDetails thirdHolder;
    private HolderDetails guardianDetails;
    private String holdingNature;
    private BankDetails bankDetails;
    private NomineeDetails firstNominee;
    private NomineeDetails secondNominee;
    private NomineeDetails thirdNominee;
    private Address clientAddress;

    public String getArn() {
        return Arn;
    }

    public void setArn(String arn) {
        Arn = arn;
    }

    public String getArnDescription() {
        return ArnDescription;
    }

    public void setArnDescription(String arnDescription) {
        ArnDescription = arnDescription;
    }

    public String getFolioNumber() {
        return folioNumber;
    }

    public void setFolioNumber(String folioNumber) {
        this.folioNumber = folioNumber;
    }

    public String getSchemeCode() {
        return schemeCode;
    }

    public void setSchemeCode(String schemeCode) {
        this.schemeCode = schemeCode;
    }

    public String getSchemeName() {
        return schemeName;
    }

    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
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

    public HolderDetails getGuardianDetails() {
        return guardianDetails;
    }

    public void setGuardianDetails(HolderDetails guardianDetails) {
        this.guardianDetails = guardianDetails;
    }

    public String getHoldingNature() {
        return holdingNature;
    }

    public void setHoldingNature(String holdingNature) {
        this.holdingNature = holdingNature;
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
