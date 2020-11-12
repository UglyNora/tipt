package com.mcenterprise.tipt.controllers;


import com.mcenterprise.tipt.data.ShiptMateRepository;
import com.mcenterprise.tipt.models.ShiptMate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("shiptMate")
public class ShiptMateController {

    @Autowired
    private ShiptMateRepository shiptMateRepository;

    @GetMapping("/addShiptMate")
    public String displayAddShiptMateForm(Model model) {
        model.addAttribute("shiptMate", new ShiptMate());
        return "shiptMate/addShiptMate";
    }

    @PostMapping
    public String processAddUserForm(Model model, @ModelAttribute @Valid ShiptMate shiptMate, Errors errors) {



        if(errors.hasErrors())  {
            model.addAttribute("error", "Please check your input!");
            return "shiptMate/addShiptMate";
        }
//
//

        return "shiptMate/index";
    }

    }
