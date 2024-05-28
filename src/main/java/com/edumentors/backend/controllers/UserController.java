package com.edumentors.backend.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edumentors.backend.dto.UserDTO;
import com.edumentors.backend.services.implementations.UserServiceImplementation;

@RestController
@RequestMapping("/api/users")
public class UserController {
   
@Autowired    
private UserServiceImplementation userServiceImplementation; 

@PostMapping
public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
    System.out.println("Received JSON: " + userDTO);
    System.out.println("fName " +userDTO.getFName());
    System.out.println("lName " +userDTO.getLName());
    UserDTO createdUser = userServiceImplementation.createUser(userDTO);

    return new ResponseEntity<>(createdUser,HttpStatus.CREATED);
    
}



    

    
}
