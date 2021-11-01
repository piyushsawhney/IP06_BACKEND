package in.knaps;

import com.google.inject.Inject;
import in.knaps.api.Address;
import in.knaps.api.client.v1.ClientApiV1;
import in.knaps.api.client.v1.ClientBasicInfo;
import in.knaps.api.client.v1.ClientDetailedInfo;
import in.knaps.domain.model.base.Validator;
import in.knaps.domain.model.client.details.ClientDetails;
import in.knaps.domain.model.client.details.ClientId;

import java.util.List;
import java.util.stream.Collectors;

public class ClientApiV1Impl implements ClientApiV1 {
    @Inject
    private KnapsApplication knapsApplication;

    @Override
    public List<ClientBasicInfo> getClientList() {
        return knapsApplication.getClientList().stream()
                .map(p -> {
                    ClientBasicInfo clientBasicInfo = new ClientBasicInfo();
                    clientBasicInfo.setClientPan(p.getPan().getValue());
                    clientBasicInfo.setClientId(p.getClientId().getValue().toString());
                    clientBasicInfo.setClientName(p.getFullName().getValue());
                    return clientBasicInfo;
                }).collect(Collectors.toList());
    }

    @Override
    public ClientDetailedInfo getClientDetails(String clientId) {
        Validator.checkWebArgument(clientId);
        return populateClientDetailedInfo(knapsApplication.getClientDetailedInfo(new ClientId(clientId)));
    }

    @Override
    public List<ClientDetailedInfo> getClientFamilyMemberDetails(String clientId) {
        Validator.checkWebArgument(clientId);
        return knapsApplication.getFamilyMemberDetails(new ClientId(clientId)).stream()
                .map(this::populateClientDetailedInfo).collect(Collectors.toList());
    }

    private ClientDetailedInfo populateClientDetailedInfo(ClientDetails clientDetails) {
        ClientDetailedInfo clientDetailedInfo = new ClientDetailedInfo();
        if (clientDetails.getClientId() != null) {
            clientDetailedInfo.setClientId(clientDetails.getClientId().getValue());
        }
        if (clientDetails.getPan() != null) {
            clientDetailedInfo.setPan(clientDetails.getPan().getValue());
        }
        if (clientDetails.getFullName() != null) {
            clientDetailedInfo.setFullName(clientDetails.getFullName().getValue());
        }
        if (clientDetails.getAddress() != null) {
            clientDetailedInfo.setAddress(populateClientAddress(clientDetails.getAddress()));
        }
        if (clientDetails.getOverseasAddress() != null) {
            clientDetailedInfo.setOverseasAddress(populateClientAddress(clientDetails.getOverseasAddress()));
        }
        if (clientDetails.getGender() != null) {
            clientDetailedInfo.setGender(clientDetails.getGender().toString());
        }

        if (clientDetails.getDateOfBirth() != null) {
            clientDetailedInfo.setDateOfBirth(clientDetails.getDateOfBirth().getDate().toString());
        }
        if (clientDetails.getCountryCode1() != null) {
            clientDetailedInfo.setCountryCode1(clientDetails.getCountryCode1().getValue());
        }
        if (clientDetails.getMobile1() != null) {
            clientDetailedInfo.setMobile1(clientDetails.getMobile1().getValue());
        }
        if (clientDetails.getCountryCode2() != null) {
            clientDetailedInfo.setMobile1(clientDetails.getCountryCode2().getValue());
        }
        if (clientDetails.getMobile2() != null) {
            clientDetailedInfo.setMobile2(clientDetails.getMobile2().getValue());
        }
        if (clientDetails.getEmailAddress1() != null) {
            clientDetailedInfo.setEmailAddress1(clientDetails.getEmailAddress1().getValue());
        }
        if (clientDetails.getEmailAddress2() != null) {
            clientDetailedInfo.setEmailAddress2(clientDetails.getEmailAddress2().getValue());
        }
        if (clientDetails.getOccupation() != null) {
            clientDetailedInfo.setOccupation(clientDetails.getOccupation().getValue());
        }
        if (clientDetails.getFathersName() != null) {
            clientDetailedInfo.setFathersName(clientDetails.getFathersName().getValue());
        }
        if (clientDetails.getMothersName() != null) {
            clientDetailedInfo.setMothersName(clientDetails.getMothersName().getValue());
        }
        if (clientDetails.getSpouseName() != null) {
            clientDetailedInfo.setSpouseName(clientDetails.getSpouseName().getValue());
        }
        if (clientDetails.getPlaceOfBirth() != null) {
            clientDetailedInfo.setPlaceOfBirth(clientDetails.getPlaceOfBirth().getValue());
        }
        if (clientDetails.getResidenceNumber() != null) {
            clientDetailedInfo.setResidenceNumber(clientDetails.getResidenceNumber().getValue());
        }
        if (clientDetails.getOfficeNumber() != null) {
            clientDetailedInfo.setOfficeNumber(clientDetails.getOfficeNumber().getValue());
        }

        return clientDetailedInfo;
    }

    private Address populateClientAddress(in.knaps.domain.model.client.address.Address address) {
        Address clientAddress = new Address();
        if (address.getAddress1() != null) {
            clientAddress.setAddress1(address.getAddress1().getValue());
        }
        if (address.getAddress2() != null) {
            clientAddress.setAddress2(address.getAddress2().getValue());
        }
        if (address.getAddress2() != null) {
            clientAddress.setAddress2(address.getAddress2().getValue());
        }
        if (address.getAddress3() != null) {
            clientAddress.setAddress3(address.getAddress3().getValue());
        }
        if (address.getCity() != null) {
            clientAddress.setCity(address.getCity().getValue());
        }
        if (address.getState() != null) {
            clientAddress.setState(address.getState().getValue());
        }
        if (address.getCountry() != null) {
            clientAddress.setCountry(address.getCountry().getValue());
        }
        if (address.getPinCode() != null) {
            clientAddress.setPinCode(address.getPinCode().getValue());
        }
        return clientAddress;
    }
}
