package com.edumentors.backend.services.implementations;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edumentors.backend.dto.UserDTO;
import com.edumentors.backend.entities.User;
import com.edumentors.backend.exceptions.DataNotFoundException;
import com.edumentors.backend.mappers.UserMapper;
import com.edumentors.backend.repositories.UserRepository;
import com.edumentors.backend.services.UserService;

@Service
public class UserServiceImplementation implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;
    

    //Saving user to database
    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = userMapper.dtoToUser(userDTO);
        System.out.println("fName: " + user.getFName());
        System.out.println("lName: " + user.getLName());
        User savedUser = userRepository.save(user);
        
        return userMapper.userToDTO(savedUser);
    }

    @Override
    public UserDTO update(UserDTO userDTO, Long userId) {
       User user = userRepository.findById(userId).orElseThrow(()-> new DataNotFoundException("USER", "id", userId));
       user.setFName(userDTO.getFName());
       user.setLName(userDTO.getLName());
       user.setMobileNumber(userDTO.getContact());
       user.setAbout(userDTO.getAbout());
       User updatedUser =userRepository.save(user);
       return userMapper.userToDTO(updatedUser);
    }

    @Override
    public Optional<UserDTO> getUserById(Long userID) {
       User user = userRepository.findById(userID).orElseThrow(()-> new DataNotFoundException("USER", "Id", userID));
       UserDTO userDTO =  userMapper.userToDTO(user);
       return Optional.of(userDTO);
    }

    @Override
    public List<UserDTO> getAllUsers() {
         List<User> users = userRepository.findAll();
         return users.stream().map(user->userMapper.userToDTO(user)).collect(Collectors.toList());
         
    }

    @Override
    public void deleteUser(Long userId) {
        User user = this.userRepository.findById(userId).orElseThrow(()-> new DataNotFoundException("USER", "Id", userId));
        userRepository.delete(user);
    }





}
