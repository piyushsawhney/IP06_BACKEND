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
}
