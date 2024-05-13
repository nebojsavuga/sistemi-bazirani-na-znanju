package com.ftn.sbnz.service.services;

import com.ftn.sbnz.model.users.User;
import com.ftn.sbnz.service.controllers.RegisterDTO;

public interface IUserService {
    
    User getByEmailAndPassword(String email, String password);

    User register(RegisterDTO registerDTO);
}
