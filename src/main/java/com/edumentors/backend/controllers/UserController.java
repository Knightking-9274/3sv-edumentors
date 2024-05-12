package com.edumentors.backend.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.edumentors.backend.dto.UserDTO;
import com.edumentors.backend.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        
        UserDTO createUserDTO = this.userService.createUser(userDTO);
        return new ResponseEntity<>(createUserDTO,HttpStatus.CREATED);
    }
    
    
}
