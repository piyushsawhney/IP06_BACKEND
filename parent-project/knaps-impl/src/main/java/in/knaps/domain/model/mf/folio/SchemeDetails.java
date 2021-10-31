package in.knaps.domain.model.mf.folio;

import in.knaps.BankDetails;
import in.knaps.NomineeDetails;
import in.knaps.domain.HoldingNature;
import in.knaps.domain.model.HolderDetails;

public class SchemeDetails extends SchemeBasicInfo {
    private FolioNumber folioNumber;
    private HoldingNature holdingNature;
    private HolderDetails firstHolder;
    private HolderDetails secondHolder;
    private HolderDetails thirdHolder;
    private HolderDetails guardian;
    private NomineeDetails firstNominee;
    private NomineeDetails secondNominee;
    private NomineeDetails thirdNominee;
    private BankDetails bankDetails;

    public FolioNumber getFolioNumber() {
        return folioNumber;
    }

    public void setFolioNumber(FolioNumber folioNumber) {
        this.folioNumber = folioNumber;
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

    public BankDetails getBankDetails() {
        return bankDetails;
    }

    public void setBankDetails(BankDetails bankDetails) {
        this.bankDetails = bankDetails;
    }
}

