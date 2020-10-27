package com.mcenterprise.tipt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ShiptMateController {
    @GetMapping("ShiptMate")
    @ResponseBody
    public String hello(){
        return "Page displayed when messaging another member.";
    };
}
