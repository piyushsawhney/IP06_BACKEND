package in.knaps.domain.model.client.address;

public class Address {
    Address1 address1;
    Address2 address2;
    Address3 address3;
    City city;
    State state;
    Country country;
    PinCode pinCode;

    public Address1 getAddress1() {
        return address1;
    }

    public void setAddress1(Address1 address1) {
        this.address1 = address1;
    }

    public Address2 getAddress2() {
        return address2;
    }

    public void setAddress2(Address2 address2) {
        this.address2 = address2;
    }

    public Address3 getAddress3() {
        return address3;
    }

    public void setAddress3(Address3 address3) {
        this.address3 = address3;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public PinCode getPinCode() {
        return pinCode;
    }

    public void setPinCode(PinCode pinCode) {
        this.pinCode = pinCode;
    }
}
