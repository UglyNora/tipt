package com.mcenterprise.tipt.models;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressInfo extends AbstractEntity {



    @Size(max = 500, message = "Exceeded maximum characters allowed!")
    private String details;

    private Boolean isDangerous;

    @ManyToMany(mappedBy="addressInfo")
    private List<Address> addresses = new ArrayList<Address>();





    public AddressInfo() {
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Boolean getisDangerous() {
        return isDangerous;
    }

    public void setisDangerous(Boolean dangerous) {
        isDangerous = dangerous;
    }


}
