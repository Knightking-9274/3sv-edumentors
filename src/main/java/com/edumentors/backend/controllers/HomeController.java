package com.edumentors.backend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edumentors.backend.dto.UserDTO;


@Controller
public class HomeController {
    @RequestMapping("home")
    public String home(Model model){
        model.addAttribute("title","3SV-Edumentors & Consultants");
        return "index";
    }

    @GetMapping("/signup")
    public String signUp(@ModelAttribute("userDTO") UserDTO userDTO){
       return "signup";
    }

    @GetMapping("/login")
    public String logIn(@ModelAttribute("userDTO") UserDTO userDTO){
        return "login";
    }

    @GetMapping("/forgotPassword")
    public String forgotPassword(@ModelAttribute("userDTO") UserDTO userDTO){
        return "forgotPassword";
    }

    @GetMapping("/updatePassword")
    public String updatePassword(){
        return "updatePassword";

    }
}
