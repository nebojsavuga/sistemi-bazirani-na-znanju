package com.ftn.sbnz.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.sbnz.model.users.User;
import com.ftn.sbnz.service.repositories.UserRepository;

@Service
public class UserDetailsService {
    
    private UserRepository userRepository;
    
    @Autowired
    public UserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }
}
