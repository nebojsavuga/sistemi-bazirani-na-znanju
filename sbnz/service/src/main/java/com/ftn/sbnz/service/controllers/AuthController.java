package com.ftn.sbnz.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.sbnz.model.users.User;
import com.ftn.sbnz.service.config.JwtUtils;
import com.ftn.sbnz.service.controllers.dtos.LoginDTO;
import com.ftn.sbnz.service.controllers.dtos.RegisterDTO;
import com.ftn.sbnz.service.controllers.dtos.TokenDTO;
import com.ftn.sbnz.service.services.IUserService;

@RestController
@RequestMapping(value = "api/auth")
public class AuthController {

    private IUserService userService;
    @Autowired
    private JwtUtils jwt;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        try {
            User user = userService.getByEmail(loginDTO.email);
            if (!passwordEncoder.matches(loginDTO.password, user.getPassword())) {
                return new ResponseEntity<>("Invalid credentials", HttpStatus.BAD_REQUEST);
            }
            String jwtToken = jwt.generate(user.getUsername(), user.getId(), user.getRole().toString());
            return new ResponseEntity<>(new TokenDTO(jwtToken), HttpStatus.OK);
        } catch (AuthenticationException ex) {
            throw ex;
        }
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterDTO registerDTO) {
        User user = userService.register(registerDTO);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
