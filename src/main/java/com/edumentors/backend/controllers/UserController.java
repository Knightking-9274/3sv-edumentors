package com.edumentors.backend.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/index")
public class UserController {

    @RequestMapping("/signup")
    public String signUp(){
        return "signup";
    }
}
