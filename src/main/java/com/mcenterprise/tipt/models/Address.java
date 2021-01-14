package com.mcenterprise.tipt.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Address extends AbstractEntity {



    @ManyToMany
    private List<AddressInfo> addressInfo = new ArrayList<AddressInfo>();

    AddressRating displayRating;

    @NotBlank (message = "Street address is required")
    private String street;

    @NotBlank(message = "City is required")
    private String city;

    @NotBlank(message = "State is required")
    private String state;

    @NotBlank(message = "Zip Code is required")
    private String zipCode;

    private AddressRating type;

    public Address() {
    }

    public Address(int id, @NotBlank(message = "Street address is required") String street, @NotBlank(message = "City is required") String city, @NotBlank(message = "State is required") String state, @NotBlank(message = "Zip Code is required") String zipCode, AddressRating type, List<AddressInfo> someInfo) {

        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.type = type;
        this.addressInfo = someInfo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public AddressRating getType() {
        return type;
    }

    public void setType(AddressRating type) {
        this.type = type;
    }

    public List<AddressInfo> getAddressInfo() {
        return addressInfo;
    }

    public void setAddressInfo(List<AddressInfo> addressInfo) {
        this.addressInfo = addressInfo;
    }
}
