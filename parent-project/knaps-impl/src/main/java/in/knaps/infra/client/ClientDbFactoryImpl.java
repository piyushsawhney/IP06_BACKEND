package in.knaps.infra.client;

import com.google.inject.Inject;
import in.knaps.domain.model.KnapsDate;
import in.knaps.domain.model.base.Validator;
import in.knaps.domain.model.client.ClientDbFactory;
import in.knaps.domain.model.client.ClientSqlStatement;
import in.knaps.domain.model.client.address.*;
import in.knaps.domain.model.client.details.*;
import in.knaps.domain.model.db.DatabaseException;
import in.knaps.domain.model.db.EntityNotFoundException;
import in.knaps.domain.model.db.PostgresConnection;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;

import javax.annotation.Nonnull;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ClientDbFactoryImpl implements ClientDbFactory {

    @Inject
    private PostgresConnection postgresConnection;

    @Override
    public List<ClientDetails> getClientListFromDb() {
        ResultSet rs = executeSelectQuery(ClientSqlStatement.CLIENT_BASIC_INFO);
        List<ClientDetails> clientDetailsList = new ArrayList<>();
        if (rs == null) {
            return clientDetailsList;
        } else {
            try {
                while (rs.next()) {
                    ClientDetails clientDetails = new ClientDetails();
                    clientDetails.setPan(new Pan(rs.getString("pan")));
                    clientDetails.setFullName(new Name(completeFullName(rs.getString("first_name"), rs.getString("middle_name"), rs.getString("surname"))));
                    clientDetails.setClientId(new ClientId(rs.getString("client_id")));
                    clientDetailsList.add(clientDetails);
                }
                return clientDetailsList;
            } catch (SQLException e) {
                throw new DatabaseException("ERROR: Query statement creation failed", e);
            }
        }
    }

    @Override
    public ClientDetails getClientDetailedInfoFromDb(@Nonnull ClientId clientId) {
        Validator.isNotNull(clientId);

        ResultSet rs = executeSelectQuery(ClientSqlStatement.CLIENT_DETAILED_INFO.replace("{clientId}", clientId.getValue().toString()));
        try {
            if (rs == null) {
                return new ClientDetails();
            } else {
                rs.next();
                return populateClientDetails(rs);
            }
        } catch (SQLException e) {
            throw new DatabaseException("ERROR: Query statement creation failed", e);
        }

    }

    @Override
    public List<ClientDetails> getFamilyMemberDetailsFromDb(@Nonnull ClientId clientId) {
        Validator.isNotNull(clientId);
        ResultSet rs = executeSelectQuery(ClientSqlStatement.CLIENT_FAMILY_INFO
                .replace("{clientId}", clientId.getValue().toString())
                .replace("{clientId}", clientId.getValue().toString()));
        List<ClientDetails> clientDetailsList = new ArrayList<>();
        try {
            if (rs == null) {
                return clientDetailsList;
            } else {
                while (rs.next()) {
                    clientDetailsList.add(populateClientDetails(rs));
                }
            }
            return clientDetailsList;
        } catch (SQLException e) {
            throw new DatabaseException("ERROR: Query statement creation failed", e);
        }
    }

    @Override
    public void validateClient(@Nonnull ClientId clientId) {
        Validator.isNotNull(clientId);
        ResultSet rs = executeSelectQuery(ClientSqlStatement.CLIENT_VALIDATE
                .replace("{clientId}", clientId.getValue().toString()));
        try {
            if (!rs.next()) {
                throw new EntityNotFoundException("ERROR: Client Id is invalid");
            }
        } catch (SQLException e) {
            throw new DatabaseException("ERROR: Query statement creation failed", e);
        }

    }


    private ResultSet executeSelectQuery(String sqlStatement) {
        try {
            return postgresConnection.getConnection().createStatement().executeQuery(sqlStatement);
        } catch (SQLException e) {
            throw new DatabaseException("ERROR: Query statement creation failed", e);
        }
    }

    private ClientDetails populateClientDetails(ResultSet resultSet) throws SQLException {
        ClientDetails clientDetails = new ClientDetails();
        if (resultSet.getString("client_id") != null) {
            clientDetails.setClientId(new ClientId(resultSet.getString("client_id")));
        }
        if (resultSet.getString("pan") != null) {
            clientDetails.setPan(new Pan(resultSet.getString("pan")));
        }
        if (resultSet.getString("first_name") != null) {
            clientDetails.setFullName(new Name(completeFullName(
                    resultSet.getString("first_name"),
                    resultSet.getString("middle_name"),
                    resultSet.getString("surname"))));
        }
        if (resultSet.getString("gender") != null) {
            String gender = resultSet.getString("gender");
            switch (gender.toLowerCase()) {
                case "male":
                    clientDetails.setGender(Gender.MALE);
                    break;
                case "female":
                    clientDetails.setGender(Gender.FEMALE);
                    break;
                case "others":
                    clientDetails.setGender(Gender.OTHERS);
                    break;
            }
        }
        if (resultSet.getString("address1") != null) {
            clientDetails.setAddress(populateAddress(resultSet.getString("address1"),
                    resultSet.getString("address2"),
                    resultSet.getString("address3"),
                    resultSet.getString("city"),
                    resultSet.getString("state"),
                    resultSet.getString("country"),
                    resultSet.getString("pincode"), false));
        }
        if (resultSet.getString("overseas_address1") != null) {
            clientDetails.setOverseasAddress(populateAddress(resultSet.getString("overseas_address1"),
                    resultSet.getString("overseas_address2"),
                    resultSet.getString("overseas_address1"),
                    resultSet.getString("overseas_city"),
                    resultSet.getString("overseas_state"),
                    resultSet.getString("overseas_country"),
                    resultSet.getString("overseas_pincode"), true));
        }

        if (resultSet.getString("date_of_birth") != null) {
            KnapsDate dateOfBirth = new KnapsDate();
            dateOfBirth.setDate(LocalDate.parse(resultSet.getString("date_of_birth"), DateTimeFormat.forPattern("yyyy-MM-dd")));
            clientDetails.setDateOfBirth(dateOfBirth);
        }
        if (resultSet.getString("country_code") != null) {
            clientDetails.setCountryCode1(new CountryCode(resultSet.getString("country_code")));
        }
        if (resultSet.getString("mobile_number") != null) {
            clientDetails.setMobile1(new Mobile(resultSet.getString("mobile_number")));
        }

        if (resultSet.getString("country_code_2") != null) {
            clientDetails.setCountryCode2(new CountryCode(resultSet.getString("country_code_2")));
        }
        if (resultSet.getString("mobile_number_2") != null) {
            clientDetails.setMobile2(new Mobile(resultSet.getString("mobile_number_2")));
        }
        if (resultSet.getString("email_id") != null) {
            clientDetails.setEmailAddress1(new EmailAddress(resultSet.getString("email_id")));
        }
        if (resultSet.getString("email_id_2") != null) {
            clientDetails.setEmailAddress2(new EmailAddress(resultSet.getString("email_id_2")));
        }
        if (resultSet.getString("residence_phone") != null) {
            clientDetails.setResidenceNumber(new PhoneNumber(resultSet.getString("residence_phone")));
        }
        if (resultSet.getString("office_phone") != null) {
            clientDetails.setOfficeNumber(new PhoneNumber(resultSet.getString("office_phone")));
        }
        if (resultSet.getString("occupation") != null) {
            clientDetails.setOccupation(new Occupation(resultSet.getString("occupation")));
        }
        if (resultSet.getString("place_of_birth") != null) {
            clientDetails.setPlaceOfBirth(new City(resultSet.getString("place_of_birth")));
        }
        if (resultSet.getString("father_name") != null) {
            clientDetails.setFathersName(new Name(resultSet.getString("father_name")));
        }
        if (resultSet.getString("mother_name") != null) {
            clientDetails.setMothersName(new Name(resultSet.getString("mother_name")));
        }
        if (resultSet.getString("spouse_name") != null) {
            clientDetails.setSpouseName(new Name(resultSet.getString("spouse_name")));
        }
        return clientDetails;
    }

    private Address populateAddress(String address1, String address2, String address3, String city, String state, String country, String pincode, boolean isForeign) {
        Address address = new Address();
        address.setAddress1(new Address1(address1));
        if (StringUtils.isNotEmpty(address2)) {
            address.setAddress2(new Address2(address2));
        }
        if (StringUtils.isNotEmpty(address3)) {
            address.setAddress3(new Address3(address3));
        }
        if (StringUtils.isNotEmpty(city)) {
            address.setCity(new City(city));
        }
        if (StringUtils.isNotEmpty(state)) {
            address.setState(new State(state));
        }
        if (StringUtils.isNotEmpty(country)) {
            address.setCountry(new Country(country));
        }
        if (StringUtils.isNotEmpty(pincode)) {
            PinCode pinCode = new PinCode();
            if (isForeign) {
                pinCode.setForeignPinCode(pincode);
            } else {
                pinCode.setIndianPinCode(pincode);
            }
            address.setPinCode(pinCode);
        }
        return address;
    }

    private String completeFullName(String firstName, String middleName, String surname) {
        if (StringUtils.isNotEmpty(middleName) && StringUtils.isNotEmpty(surname)) {
            return String.join(" ", firstName, middleName, surname);
        } else if (!StringUtils.isNotEmpty(middleName) && StringUtils.isNotEmpty(surname)) {
            return String.join(" ", firstName, surname);
        } else {
            return String.join(" ", firstName, middleName);
        }
    }
}
