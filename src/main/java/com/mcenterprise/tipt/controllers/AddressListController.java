package com.mcenterprise.tipt.controllers;

import com.mcenterprise.tipt.models.Address;
import com.mcenterprise.tipt.models.SearchAddress;
import com.mcenterprise.tipt.models.data.AddressInfoRepository;
import com.mcenterprise.tipt.models.data.AddressRatingRepository;
import com.mcenterprise.tipt.models.data.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
@RequestMapping(value = "list")
public class AddressListController {

    @Autowired
    private AddressRepository addressRepository;

   @Autowired
   private AddressRatingRepository addressRatingRepository;

    @Autowired
    private AddressInfoRepository addressInfoRepository;


    static HashMap<String, String> columnChoices = new HashMap<>();

    public AddressListController () {

        columnChoices.put("address", "Address");
        columnChoices.put("addressInfo", "Address Info");
        columnChoices.put("addressRating", "Address Rating");

    }

    @RequestMapping("")
    public String list(Model model) {
        model.addAttribute("addresses", addressRepository.findAll());
        model.addAttribute("addressInfo", addressInfoRepository.findAll());
        model.addAttribute("addressRating", addressRatingRepository.findAll());

        return "listAddress";
    }

    @RequestMapping(value = "addresses")
    public String listAddressByColumnAndValue(Model model, @RequestParam String column, @RequestParam String value) {
        Iterable<Address> addresses;
        if (column.toLowerCase().equals("all")){
            addresses= addressRepository.findAll();
            model.addAttribute("title", "All Jobs");
        } else {
            addresses = SearchAddress.findByColumnAndValue(column, value, addressRepository.findAll());
            model.addAttribute("title", "Addresses" + columnChoices.get(column) + ": " + value);
        }
        model.addAttribute("addresses", addresses);

        return "listAddress";
    }
}
