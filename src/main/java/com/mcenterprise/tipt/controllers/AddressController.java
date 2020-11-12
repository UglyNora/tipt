package com.mcenterprise.tipt.controllers;

import com.mcenterprise.tipt.data.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;

    @GetMapping("address")
    @ResponseBody
    public String address(){
        return "Address finder, message member, list of members sidebar";
    };
}
