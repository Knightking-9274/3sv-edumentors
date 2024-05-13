package com.edumentors.backend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
    @RequestMapping("home")
    public String home(Model model){
        model.addAttribute("title","3SV-Edumentors & Consultants");
        return "index";
    }

    @RequestMapping("/signup")
    public String signUp(){
        return "signup";
    }

}
