package in.knaps.mf.v1;

import com.fasterxml.jackson.annotation.JsonInclude;
import in.knaps.Address;
import in.knaps.BankDetails;
import in.knaps.HolderDetails;
import in.knaps.NomineeDetails;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FolioSchemeDetails {
    String Arn;
    String ArnDescription;
    String folioNumber;
    String schemeCode;
    String schemeName;
    String mobile;
    String emailAddress;
    Double totalUnits;
    HolderDetails firstHolder;
    HolderDetails secondHolder;
    HolderDetails thirdHolder;
    HolderDetails guardianDetails;
    String holdingNature;
    BankDetails bankDetails;
    NomineeDetails firstNominee;
    NomineeDetails secondNominee;
    NomineeDetails thirdNominee;
    Address clientAddress;

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

    public Double getTotalUnits() {
        return totalUnits;
    }

    public void setTotalUnits(Double totalUnits) {
        this.totalUnits = totalUnits;
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
