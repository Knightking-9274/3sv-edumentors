package com.edumentors.backend.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.edumentors.backend.dto.UserDTO;
import com.edumentors.backend.entities.User;
import com.edumentors.backend.repositories.UserRepository;
import com.edumentors.backend.services.UserService;
import com.edumentors.backend.services.implementations.UserServiceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    private UserServiceImplementation userServiceImplementation;

    // @RequestMapping("")
    // public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO){
        
    //     UserDTO createUserDTO = this.userService.createUser(userDTO);
    //     return new ResponseEntity<>(createUserDTO,HttpStatus.CREATED);
    // }
    // @PostMapping("/register")
    // public String registerUer(@ModelAttribute("userDTO") UserDTO userDTO){
    //     User user = this.userServiceImplementation.dtoToUser(userDTO);
    //     this.userRepository.save(user);
    //     return "signup";
    // }
    
    
}
