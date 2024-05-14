package com.ftn.sbnz.service.controllers;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.sbnz.model.articles.Article;
import com.ftn.sbnz.model.users.User;
import com.ftn.sbnz.service.exceptions.BadCredentialsException;
import com.ftn.sbnz.service.services.IUserService;

@CrossOrigin
@RestController
@RequestMapping(value = "api/users")
public class UserController {

	private IUserService userService;

	@Autowired
	public UserController(IUserService userService) {
		this.userService = userService;
	}

        
	@PutMapping()
	public ResponseEntity<User> login(@RequestBody LoginDTO loginDTO, HttpSession session) {
		User user = userService.getByEmailAndPassword(loginDTO.email, loginDTO.password);
		if (user == null){
			throw new BadCredentialsException("Bad credentials!");
		}
		session.setAttribute("user", user);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@PostMapping(value = "/register")
	public ResponseEntity<User> register(@RequestBody RegisterDTO registerDTO) {
		User user = userService.register(registerDTO);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@PutMapping(value = "/add/favoriteArticle/{articleId}")
	public ResponseEntity<Article> addFavoriteArticle(@PathVariable("articleId") Long id, HttpSession session){

		Article article = userService.addFavoriteArticle(id, session);

		return new ResponseEntity<>(article, HttpStatus.OK);
	}

	
}
