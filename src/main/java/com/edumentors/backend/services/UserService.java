package com.edumentors.backend.services;

import java.util.List;

import com.edumentors.backend.dto.UserDTO;

public interface UserService {

    public UserDTO createUser(UserDTO userDTO);
    public UserDTO update(UserDTO userDTO, Long userId);
    public UserDTO getUserById(Long userID);
    List<UserDTO> getAllUsers();
    void deleteUser(Long userId);
} 