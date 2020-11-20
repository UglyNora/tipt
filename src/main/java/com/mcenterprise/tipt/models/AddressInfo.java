package com.mcenterprise.tipt.models;

import javax.persistence.Entity;
import javax.validation.constraints.Size;

@Entity
public class AddressInfo extends AbstractEntity {

    @Size(max = 500, message = "Exceeded maximum characters allowed!")
    private String details;

    private Boolean isDangerous;



    public AddressInfo() {
    }

}
