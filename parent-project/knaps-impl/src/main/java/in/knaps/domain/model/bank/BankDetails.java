package in.knaps.domain.model.bank;

public class BankDetails {
    private BankAccountNo bankAccountNo;
    private BankName bankName;
    private BankBranch bankBranch;
    private BankIfsc bankIfsc;
    private BankMicr bankMicr;
    private BankAccountType bankAccountType;

    public BankAccountNo getBankAccountNo() {
        return bankAccountNo;
    }

    public void setBankAccountNo(BankAccountNo bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
    }

    public BankName getBankName() {
        return bankName;
    }

    public void setBankName(BankName bankName) {
        this.bankName = bankName;
    }

    public BankBranch getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(BankBranch bankBranch) {
        this.bankBranch = bankBranch;
    }

    public BankIfsc getBankIfsc() {
        return bankIfsc;
    }

    public void setBankIfsc(BankIfsc bankIfsc) {
        this.bankIfsc = bankIfsc;
    }

    public BankMicr getBankMicr() {
        return bankMicr;
    }

    public void setBankMicr(BankMicr bankMicr) {
        this.bankMicr = bankMicr;
    }

    public BankAccountType getBankAccountType() {
        return bankAccountType;
    }

    public void setBankAccountType(BankAccountType bankAccountType) {
        this.bankAccountType = bankAccountType;
    }
}
