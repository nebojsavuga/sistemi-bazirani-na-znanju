package com.ftn.sbnz.service.services;

import com.ftn.sbnz.model.users.User;

public interface IUserService {
    
    User getByEmailAndPassword(String email, String password);
}
