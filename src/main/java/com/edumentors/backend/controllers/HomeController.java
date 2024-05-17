package com.edumentors.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edumentors.backend.dto.UserDTO;
import com.edumentors.backend.entities.User;
import com.edumentors.backend.repositories.UserRepository;
import com.edumentors.backend.services.implementations.UserServiceImplementation;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserServiceImplementation userServiceImplementation;

    // @Autowired
    // private BCryptPasswordEncoder bCryptPasswordEncoder;

    //for handling home page
    @RequestMapping("home")
    public String home(Model model){
        model.addAttribute("title","3SV-Edumentors & Consultants");
        return "index";
    }

    //for rendering registeration/signup page
    @GetMapping("/signup")
    public String signUp(@ModelAttribute("userDTO") UserDTO userDTO){
       return "signup";
    }

    //for registering the user
    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("userDTO") UserDTO userDTO,BindingResult bindingResult, HttpSession session){

        if (bindingResult.hasErrors()) {
            return "signup";
        }
        try{
            
            
            User user = this.userServiceImplementation.dtoToUser(userDTO);
            this.userRepository.save(user);
            session.setAttribute("registered","Registered sucessfully! You Can LogIn");
            System.out.println(session.getAttribute("registered"));
         return "signup";
        }
        catch(Exception e){
            session.setAttribute("error","Something went wrong! "+e.getMessage());
            return "signup";
        }
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
