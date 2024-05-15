package com.ftn.sbnz.service.controllers;

import java.util.Set;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.sbnz.model.DTO.RatingDTO;
import com.ftn.sbnz.model.articles.Article;
import com.ftn.sbnz.model.users.User;
import com.ftn.sbnz.service.controllers.dtos.LoginDTO;
import com.ftn.sbnz.service.controllers.dtos.RegisterDTO;
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

	@PutMapping(value = "/favorite-article/{articleId}")
	public ResponseEntity<String> addFavoriteArticle(@PathVariable("articleId") Long id, HttpSession session){

		String name = userService.addFavoriteArticle(id, session);

		return new ResponseEntity<>(name, HttpStatus.OK);
	}

	@GetMapping(value = "/favorite-articles")
	public ResponseEntity<Set<Article>> getFavoriteArticles(HttpSession session){

		Set<Article>articles = userService.getFavoriteArticles(session);

		return new ResponseEntity<>(articles, HttpStatus.OK);
	}

	@PostMapping(value = "/rate-article")
	public ResponseEntity<RatingDTO> RateArticle(@RequestBody RatingDTO ratingDTO, HttpSession session){

		RatingDTO rating = userService.rateArticle(ratingDTO, session);

		return new ResponseEntity<>(rating, HttpStatus.OK);
	}
}
