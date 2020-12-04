package com.mcenterprise.tipt.controllers;

import com.mcenterprise.tipt.models.data.ShiptMateRepository;
import com.mcenterprise.tipt.models.ShiptMate;
import com.mcenterprise.tipt.models.dto.LoginFormDTO;
import com.mcenterprise.tipt.models.dto.RegisterFormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
public class ShiptMateAuthController {

    @Autowired
    ShiptMateRepository shiptMateRepository;

    private static final String userSessionKey = "shiptMate";

    public ShiptMate getUserFromSession(HttpSession session) {
        Integer shiptMateId = (Integer) session.getAttribute(userSessionKey);
        if (shiptMateId == null) {
            return null;
        }

        Optional<ShiptMate> shiptMate = shiptMateRepository.findById(shiptMateId);

        if (shiptMate.isEmpty()) {
            return null;
        }

        return shiptMate.get();
    }

    private static void setUserInSession(HttpSession session, ShiptMate shiptMate) {
        session.setAttribute(userSessionKey, shiptMate.getId());
    }

    @GetMapping("/register")
    public String displayRegistrationForm(Model model) {
        model.addAttribute(new RegisterFormDTO());
        model.addAttribute("title", "Register");
        return "register";
    }

    @PostMapping("/register")
    public String processRegistrationForm(@ModelAttribute @Valid RegisterFormDTO registerFormDTO,
                                          Errors errors, HttpServletRequest request,
                                          Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Register");
            return "register";
        }

        ShiptMate existingShiptMate = shiptMateRepository.findByUsername(registerFormDTO.getUsername());

        if (existingShiptMate != null) {
            errors.rejectValue("username", "username.alreadyexists", "A user with that username already exists");
            model.addAttribute("title", "Register");
            return "register";
        }

        String password = registerFormDTO.getPassword();
        String verifyPassword = registerFormDTO.getVerifyPassword();
        if (!password.equals(verifyPassword)) {
            errors.rejectValue("password", "passwords.mismatch", "Passwords do not match");
            model.addAttribute("title", "Register");
            return "register";
        }

        ShiptMate newShiptMate = new ShiptMate(registerFormDTO.getUsername(), registerFormDTO.getPassword());
        shiptMateRepository.save(newShiptMate);
        setUserInSession(request.getSession(), newShiptMate);

        return "redirect:";
    }

    @GetMapping("/login")
    public String displayLoginForm(Model model) {
        model.addAttribute(new LoginFormDTO());
        model.addAttribute("title", "Log In");
        return "login";
    }

    @PostMapping("/login")
    public String processLoginForm(@ModelAttribute @Valid LoginFormDTO loginFormDTO,
                                   Errors errors, HttpServletRequest request,
                                   Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Log In");
            return "login";
        }

        ShiptMate shiptMate = shiptMateRepository.findByUsername(loginFormDTO.getUsername());

        if (shiptMate == null) {
            errors.rejectValue("username", "user.invalid", "The given username does not exist");
            model.addAttribute("title", "Log In");
            return "login";
        }

        String password = loginFormDTO.getPassword();

        if (!shiptMate.isMatchingPassword(password)) {
            errors.rejectValue("password", "password.invalid", "Invalid password");
            model.addAttribute("title", "Log In");
            return "login";
        }

        setUserInSession(request.getSession(), shiptMate);

        return "redirect:";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/login";
    }

}

