package com.edumentors.backend.services;

import java.util.List;
import java.util.Optional;

import com.edumentors.backend.dto.UserDTO;

public interface UserService {

    public UserDTO createUser(UserDTO userDTO);
    public UserDTO update(UserDTO userDTO, Long userId);
    public Optional<UserDTO> getUserById(Long userID);
    public List<UserDTO> getAllUsers();
    void deleteUser(Long userId);
} 