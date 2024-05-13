package com.ftn.sbnz.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.sbnz.model.users.Role;
import com.ftn.sbnz.model.users.User;
import com.ftn.sbnz.service.controllers.RegisterDTO;
import com.ftn.sbnz.service.repositories.UserRepository;

@Service
public class UserService implements IUserService{

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getByEmailAndPassword(String email, String password) {
        User user = userRepository.findByEmailAndPassword(email, password);
        return user;
    }

    @Override
    public User register(RegisterDTO registerDTO) {
        User user = new User(registerDTO.email, registerDTO.password, registerDTO.firstName, registerDTO.lastName, Role.User, registerDTO.gender);
        user = userRepository.save(user);
        return user;
    }
    
}
