package in.knaps.domain.model.client;

public interface ClientSqlStatement {
    String CLIENT_BASIC_INFO = "select client_id,pan,first_name,middle_name,surname from client_data.client_details ORDER BY 3;";

    String CLIENT_VALIDATE = "select exists(select 1 from client_data.client_details where client_id = '{clientId}');";

    String CLIENT_DETAILED_INFO = "SELECT client_id,gender, address1, address2, address3, city, state, country, pincode, " +
            "date_of_birth, country_code, mobile_number, country_code_2,mobile_number_2, email_id, email_id_2, residence_phone, " +
            "office_phone, occupation, place_of_birth, overseas_address1, overseas_address2, overseas_address3, " +
            "overseas_city, overseas_state, overseas_country, overseas_pincode,father_name,mother_name,spouse_name " +
            "FROM client_data.client_details WHERE client_id = '{clientId}';";

    String CLIENT_FAMILY_INFO = "SELECT client_id,pan,first_name,middle_name,surname,gender, " +
            "address1, address2, address3, city, state, country, pincode, " +
            "date_of_birth, country_code, mobile_number,country_code_2, mobile_number_2, email_id, email_id_2, residence_phone, " +
            "office_phone, occupation, place_of_birth, overseas_address1, overseas_address2, overseas_address3, " +
            "overseas_city, overseas_state, overseas_country, overseas_pincode ,father_name,mother_name,spouse_name " +
            "FROM client_data.client_details WHERE family_id IN (SELECT family_id from " +
            "client_data.client_details where client_id = '{clientId}') ORDER BY date_of_birth;";
}
