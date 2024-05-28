package com.edumentors.backend.mappers;

import org.springframework.stereotype.Component;

import com.edumentors.backend.dto.UserDTO;
import com.edumentors.backend.entities.User;

@Component
public class UserMapper {
        //converting UserDTO to User
    public User dtoToUser(UserDTO userDTO){
        User user = new User();
        user.setUserId(userDTO.getId());
        user.setFName(userDTO.getFName());
        user.setLName(userDTO.getLName());
        user.setCity(userDTO.getCity());
        user.setMobileNumber(userDTO.getContact());
        user.setPassword(userDTO.getPassword());
        user.setEmailId(userDTO.getEmail());
        user.setAbout(userDTO.getAbout());
        return user;

    }
    // converting User to UserDTO
    public UserDTO userToDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getUserId());
        userDTO.setFName(user.getFName());
        userDTO.setLName(user.getLName());
        userDTO.setContact(user.getMobileNumber());
        userDTO.setCity(user.getCity());
        userDTO.setPassword(user.getPassword());
        userDTO.setEmail(user.getEmailId());
        userDTO.setAbout(user.getAbout());
        return userDTO;

    }
}
