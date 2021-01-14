package com.mcenterprise.tipt.controllers;

import com.mcenterprise.tipt.models.Address;
import com.mcenterprise.tipt.models.SearchAddress;
import com.mcenterprise.tipt.models.data.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.mcenterprise.tipt.controllers.AddressListController.columnChoices;

@Controller
@RequestMapping("search")
public class AddressFindController {
    @Autowired
    private AddressRepository addressRepository;


    @RequestMapping("")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        return "findAddress";
    }

    @PostMapping("results")
    public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm){
        Iterable<Address> addresses;
        if (searchTerm.toLowerCase().equals("all") || searchTerm.equals("")){
            addresses = addressRepository.findAll();
        } else {
            addresses = SearchAddress.findByColumnAndValue(searchType, searchTerm, addressRepository.findAll());
        }
        model.addAttribute("columns", columnChoices);
        model.addAttribute("title", "Addresses " + columnChoices.get(searchType) + ": " + searchTerm);
        model.addAttribute("addresses", addresses);

        return "findAddress";
    }
}
