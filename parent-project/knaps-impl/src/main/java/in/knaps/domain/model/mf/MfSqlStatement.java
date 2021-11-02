package in.knaps.domain.model.mf;

public interface MfSqlStatement {
    String CLIENT_FOLIO_INFO = "SELECT arn, arn_desc, folio_number, scheme_code, scheme_name, total_units,rta_name,amc_code " +
            "FROM mf_client_data.mf_client_folios WHERE pan = '{clientId}';";

    String TRANSACTION_GROUPS = "select transaction_code, sum(units) as units, sum(gross_amount) as value " +
            "FROM mf_client_data.mf_client_transactions " +
            "WHERE folio_number = '{folioNumber}' and scheme_code = '{schemeCode}' and units != 0 " +
            "GROUP BY transaction_code";

    String CURRENT_NAV = "select nav " +
            "FROM rta_data.mf_scheme_nav_details " +
            "WHERE rta_product_code = '{schemeCode}';";

    String CURRENT_VALUE = "select (n.nav * t.total_units) as currentValue " +
            "from rta_data.mf_scheme_nav_details n, mf_client_data.mf_client_folios t " +
            "WHERE folio_number = '{folioNumber}' and scheme_code = '{schemeCode}' and " +
            "rta_product_code = '{schemeCode}';";

    String TRANSACTION_INFO_FOR_RETURN = "select gross_amount,nav_date " +
            "FROM mf_client_data.mf_client_transactions " +
            "WHERE folio_number = '{folioNumber}' and scheme_code = '{schemeCode}' and units != 0;";

    String SCHEME_TRANSACTION = "select nav_date,units,nav,gross_amount,stamp_duty,net_amount,exit_load,stt,tax," +
            "transaction_type,transaction_suffix,sum(units) over (PARTITION BY scheme_code ORDER BY nav_date,transaction_id) " +
            "as cumulative_units " +
            "FROM mf_client_data.mf_client_transactions " +
            "WHERE folio_number = '{folioNumber}' and scheme_code = '{schemeCode}' and units != 0;";


    String SCHEME_INFORMATION = "select arn,arn_desc,folio_number,scheme_code,scheme_name," +
            "investor_mobile,investor_email,holding_nature," +
//            "client_id," +
            "investor_name,pan,investor_ckyc," +
//            "joint1_id," +
            "joint1_name,joint1_pan,joint1_ckyc," +
//            "joint2_id," +
            "joint2_name,joint2_pan,joint2_ckyc," +
//            "guardian_id," +
            "guardian_name,guardian_pan,guardian_ckyc," +
            "bank_name,bank_branch,bank_account_no,bank_ifsc,bank_account_type," +
            "nominee1_name,nominee1_relation,nominee1_percentage," +
            "nominee2_name,nominee2_relation,nominee2_percentage," +
            "nominee3_name,nominee3_relation,nominee3_percentage," +
            "investor_address1,investor_address2,investor_address3,investor_city,investor_pincode " +
            "FROM mf_client_data.mf_client_folios " +
            "WHERE folio_number = '{folioNumber}' and scheme_code = '{schemeCode}';";
}
