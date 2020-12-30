package com.mcenterprise.tipt.controllers;

import com.mcenterprise.tipt.models.Address;
import com.mcenterprise.tipt.models.AddressInfo;
import com.mcenterprise.tipt.models.AddressRating;
import com.mcenterprise.tipt.models.data.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("address")
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;

    @GetMapping
    public String displayAllAddresses(Model model) {
        model.addAttribute("title", "All Addresses");
        model.addAttribute("Addresses", addressRepository.findAll());
        return "address/index";
    }

    @GetMapping("addAddress")
    public String displayAddAddressForm(Model model) {
        model.addAttribute("title", "Add Address");
        model.addAttribute(new Address());
        model.addAttribute("types", AddressRating.values());
        model.addAttribute(new AddressInfo());
        return "address/addAddress";
    }

    @PostMapping("addAddress")
    public String processAddAddressForm(@ModelAttribute @Valid Address newAddress,
                                         Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Add Address");
            return "address/addAddress";
        }

        addressRepository.save(newAddress);
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteAddressForm(Model model) {
        model.addAttribute("title", "Delete Events");
        model.addAttribute("events", addressRepository.findAll());
        return "address/delete";
    }

    @PostMapping("delete")
    public String processDeleteEventsForm(@RequestParam(required = false) int[] addressIds) {

        if (addressIds != null) {
            for (int id : addressIds) {
                addressRepository.deleteById(id);
            }
        }

        return "redirect:";


    }

    @GetMapping("/findAddress")
    public String displayFindAddressForm(Model model) {
        model.addAttribute("address", new Address());
        return "address/findAddress";
    }

    @PostMapping
    public String processFindAddressForm(Model model, @ModelAttribute @Valid Address address, Errors errors) {



        if(errors.hasErrors())  {
            model.addAttribute("error", "Please check your input!");
            return "address/findAddress";
        }



        return "address/index";
    }
//TODO render view for searched address
}
