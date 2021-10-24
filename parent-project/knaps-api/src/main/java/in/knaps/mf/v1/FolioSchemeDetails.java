package in.knaps.mf.v1;

import com.fasterxml.jackson.annotation.JsonInclude;
import in.knaps.Address;

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
}
