package com.ftn.sbnz.service.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.sbnz.model.users.User;
import com.ftn.sbnz.service.services.IUserService;

@CrossOrigin
@RestController
@RequestMapping(value = "api/users")
public class UserController {
	private static Logger log = LoggerFactory.getLogger(UserController.class);
	private IUserService userService;

	@Autowired
	public UserController(IUserService userService) {
		this.userService = userService;
	}

        
	@PutMapping()
	public ResponseEntity<User> login(@RequestBody LoginDTO loginDTO, HttpSession session) {
		User user = userService.getByEmailAndPassword(loginDTO.email, loginDTO.password);
		session.setAttribute("user", user);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@PostMapping(value = "/register")
	public ResponseEntity<User> register(@RequestBody RegisterDTO registerDTO) {
		User user = userService.register(registerDTO);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	
}
