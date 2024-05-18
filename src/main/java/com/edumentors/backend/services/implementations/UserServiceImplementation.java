package com.edumentors.backend.services.implementations;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edumentors.backend.dto.UserDTO;
import com.edumentors.backend.entities.User;
import com.edumentors.backend.exceptions.DataNotFoundException;
import com.edumentors.backend.repositories.UserRepository;
import com.edumentors.backend.services.UserService;

@Service
public class UserServiceImplementation implements UserService{
    @Autowired
    private UserRepository userRepository;

    

    //Saving user to database
    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = this.dtoToUser(userDTO);
        User savedUser = this.userRepository.save(user);
        return this.userToDTO(savedUser);
    }

    @Override
    public UserDTO update(UserDTO userDTO, Long userId) {
       User user = this.userRepository.findById(userId).orElseThrow(()-> new DataNotFoundException("USER", "id", userId));
       user.setFName(userDTO.getFName());
       user.setLName(userDTO.getLName());
       user.setMobileNumber(userDTO.getContact());
       user.setAbout(userDTO.getAbout());
       User updatedUser = this.userRepository.save(user);
       return this.userToDTO(updatedUser);
    }

    @Override
    public UserDTO getUserById(Long userID) {
       User user = this.userRepository.findById(userID).orElseThrow(()-> new DataNotFoundException("USER", "Id", userID));
       return this.userToDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
         List<User> users = this.userRepository.findAll();
         return users.stream().map(user->this.userToDTO(user)).collect(Collectors.toList());
         
    }

    @Override
    public void deleteUser(Long userId) {
        User user = this.userRepository.findById(userId).orElseThrow(()-> new DataNotFoundException("USER", "Id", userId));
        this.userRepository.delete(user);
    }

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
