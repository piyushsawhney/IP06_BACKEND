package in.knaps.domain.model.mf;

import in.knaps.domain.model.base.StringIdValue;

public class TransactionType extends StringIdValue {
    public static TransactionType P = new TransactionType("P");
    public static TransactionType PR = new TransactionType("PR");
    public static TransactionType R = new TransactionType("R");
    public static TransactionType RR = new TransactionType("RR");
    public static TransactionType DP = new TransactionType("DP");
    public static TransactionType DPR = new TransactionType("DPR");
    public static TransactionType DRR = new TransactionType("DRR");
    public static TransactionType DR = new TransactionType("DR");
    public static TransactionType SI = new TransactionType("SI");
    public static TransactionType SIR = new TransactionType("SIR");
    public static TransactionType SO = new TransactionType("SO");
    public static TransactionType SOR = new TransactionType("SOR");


    private TransactionType(String value) {
        super(value);
    }

    @Override
    public String getValue() {
        return super.getValue();
    }
}
