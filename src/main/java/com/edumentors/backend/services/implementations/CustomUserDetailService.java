package com.edumentors.backend.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.edumentors.backend.configuration.CustomUserDetail;
import com.edumentors.backend.entities.User;
import com.edumentors.backend.repositories.UserRepository;


@Service
public class CustomUserDetailService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    private User user;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        user = userRepository.getUserByUserName(username);

        if(user==null){
            throw new UsernameNotFoundException("user not found!");
        }
        return new CustomUserDetail(user);
       
    }
   
    
    
}
