package com.mcenterprise.tipt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AddressController {
    @GetMapping("address")
    @ResponseBody
    public String address(){
        return "Address finder, message member, list of members sidebar";
    };
}
