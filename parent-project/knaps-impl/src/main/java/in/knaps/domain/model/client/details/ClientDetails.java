package in.knaps.domain.model.client.details;

import in.knaps.domain.model.KnapsDate;
import in.knaps.domain.model.client.address.Address;
import in.knaps.domain.model.client.address.City;

public class ClientDetails {
    ClientId clientId;
    Pan pan;
    Name fullName;
    Address address;
    Gender gender;
    Address overseasAddress;
    KnapsDate dateOfBirth;
    CountryCode countryCode1;
    Mobile mobile1;
    CountryCode countryCode2;
    Mobile mobile2;
    EmailAddress emailAddress1;
    EmailAddress emailAddress2;
    Occupation occupation;
    Name fathersName;
    Name mothersName;
    Name spouseName;
    City placeOfBirth;
    PhoneNumber residenceNumber;
    PhoneNumber officeNumber;


    public ClientId getClientId() {
        return clientId;
    }

    public void setClientId(ClientId clientId) {
        this.clientId = clientId;
    }

    public Pan getPan() {
        return pan;
    }

    public void setPan(Pan pan) {
        this.pan = pan;
    }

    public Name getFullName() {
        return fullName;
    }

    public void setFullName(Name fullName) {
        this.fullName = fullName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Address getOverseasAddress() {
        return overseasAddress;
    }

    public void setOverseasAddress(Address overseasAddress) {
        this.overseasAddress = overseasAddress;
    }

    public KnapsDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(KnapsDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public CountryCode getCountryCode1() {
        return countryCode1;
    }

    public void setCountryCode1(CountryCode countryCode1) {
        this.countryCode1 = countryCode1;
    }

    public Mobile getMobile1() {
        return mobile1;
    }

    public void setMobile1(Mobile mobile1) {
        this.mobile1 = mobile1;
    }

    public CountryCode getCountryCode2() {
        return countryCode2;
    }

    public void setCountryCode2(CountryCode countryCode2) {
        this.countryCode2 = countryCode2;
    }

    public Mobile getMobile2() {
        return mobile2;
    }

    public void setMobile2(Mobile mobile2) {
        this.mobile2 = mobile2;
    }

    public EmailAddress getEmailAddress1() {
        return emailAddress1;
    }

    public void setEmailAddress1(EmailAddress emailAddress1) {
        this.emailAddress1 = emailAddress1;
    }

    public EmailAddress getEmailAddress2() {
        return emailAddress2;
    }

    public void setEmailAddress2(EmailAddress emailAddress2) {
        this.emailAddress2 = emailAddress2;
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

    public Name getFathersName() {
        return fathersName;
    }

    public void setFathersName(Name fathersName) {
        this.fathersName = fathersName;
    }

    public Name getMothersName() {
        return mothersName;
    }

    public void setMothersName(Name mothersName) {
        this.mothersName = mothersName;
    }

    public Name getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(Name spouseName) {
        this.spouseName = spouseName;
    }

    public City getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(City placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public PhoneNumber getResidenceNumber() {
        return residenceNumber;
    }

    public void setResidenceNumber(PhoneNumber residenceNumber) {
        this.residenceNumber = residenceNumber;
    }

    public PhoneNumber getOfficeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(PhoneNumber officeNumber) {
        this.officeNumber = officeNumber;
    }
}
