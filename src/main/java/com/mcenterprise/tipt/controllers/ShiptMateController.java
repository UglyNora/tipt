package com.mcenterprise.tipt.controllers;


import com.mcenterprise.tipt.models.ShiptMate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("shiptMate")
public class ShiptMateController {

    @GetMapping("/addShiptMate")
    public String displayAddUserForm(Model model) {
        model.addAttribute("title", "Create ShiptMate");
        model.addAttribute("shiptMate", new ShiptMate());
        return "shiptMate/addShiptMate";
    }

    @PostMapping
    public String processAddUserForm(Model model, @ModelAttribute ShiptMate shiptMate, String verify) {
        model.addAttribute("shiptMate", shiptMate);
        model.addAttribute("verify", verify);
        model.addAttribute("username", shiptMate.getUsername());
        model.addAttribute("email", shiptMate.getEmail());
        if (shiptMate.getPassword().equals(verify)) {
            return "shiptMate/index";
        }
        else {
            model.addAttribute("error", "Passwords do not match");
            return "shiptMate/addShiptMate";
        }

    }


}
