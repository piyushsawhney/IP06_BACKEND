package in.knaps.mf.v1;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class NomineeDetails {
    String nomineeName;
    String nomineeRelation;
    Float nomineePercentage;

    public String getNomineeName() {
        return nomineeName;
    }

    public void setNomineeName(String nomineeName) {
        this.nomineeName = nomineeName;
    }

    public String getNomineeRelation() {
        return nomineeRelation;
    }

    public void setNomineeRelation(String nomineeRelation) {
        this.nomineeRelation = nomineeRelation;
    }

    public Float getNomineePercentage() {
        return nomineePercentage;
    }

    public void setNomineePercentage(Float nomineePercentage) {
        this.nomineePercentage = nomineePercentage;
    }
}
