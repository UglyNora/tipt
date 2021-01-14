package com.mcenterprise.tipt.models;

import java.util.ArrayList;

public class SearchAddress {

    /**
     * Returns the results of searching the Address data by field and search term.
     * <p>
     * For example, searching for street "Tampa Bay Blvd" will include results
     * with "5555 Tampa Bay Blvd.".
     *
     * @param column       Address field that should be searched.
     * @param value        Value of the field to search for.
     * @param allAddresses The list of Addresses to search.
     * @return List of all Addresses matching the criteria.
     */

    public static ArrayList<Address> findByColumnAndValue(String column, String value, Iterable<Address> allAddresses) {

        ArrayList<Address> results = new ArrayList<>();

        if (value.toLowerCase().equals("all")) {
            return (ArrayList<Address>) allAddresses;
        }

        if (column.equals("all")) {
            results = findByValue(value, allAddresses);
            return results;
        }
        for (Address address : allAddresses) {

            String aValue = getFieldValue(address, column);

            if (aValue != null && aValue.toLowerCase().contains(value.toLowerCase())) {
                results.add(address);
            }
        }

        return results;
    }

    public static String getFieldValue(Address address, String fieldName) {
        String theValue = "";
        if (fieldName.equals("street")) {
            theValue = address.getStreet();
        } else if (fieldName.equals("city")) {
            theValue = address.getCity();
        } else if (fieldName.equals("state")) {
            theValue = address.getState();
        } else {
            theValue = address.getZipCode();
        }

        return theValue;
    }

    /**
     * Search all Job fields for the given term.
     *
     * @param value        The search term to look for.
     * @param allAddresses The list of addresses to search.
     * @return List of all addresses with at least one field containing the value.
     */
    public static ArrayList<Address> findByValue(String value, Iterable<Address> allAddresses) {
        String lower_val = value.toLowerCase();

        ArrayList<Address> results = new ArrayList<>();

        for (Address address : allAddresses) {

            if (address.getStreet().toLowerCase().contains(lower_val)) {
                results.add(address);
            } else if (address.getZipCode().toLowerCase().contains(lower_val)) {
                results.add(address);

            }



        }

        return results;

    }
}





