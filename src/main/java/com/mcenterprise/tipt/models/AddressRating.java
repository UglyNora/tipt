package com.mcenterprise.tipt.models;

public enum AddressRating {

    ZEROSTARS(""),
    ONESTAR("*"),
    TWOSTARS("**"),
    THREESTARS("***"),
    FOURSTARS("****"),
    FIVESTARS("*****");



    private final String displayRating;

    AddressRating(String displayRating) {
        this.displayRating = displayRating;

    }

    public String getDisplayRating() {
        return displayRating;
    }



    AddressRating() {

        displayRating = "";
    }
}


