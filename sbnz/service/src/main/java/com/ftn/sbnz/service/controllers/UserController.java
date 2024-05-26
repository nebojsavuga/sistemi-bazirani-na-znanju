package com.ftn.sbnz.service.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.sbnz.model.users.User;
import com.ftn.sbnz.service.config.JwtUtils;
import com.ftn.sbnz.service.controllers.dtos.ArticleDTO;
import com.ftn.sbnz.service.controllers.dtos.UserDTO;
import com.ftn.sbnz.service.services.IUserService;

@RestController
@RequestMapping(value = "api/users")
public class UserController {

	private IUserService userService;
	@Autowired
	private JwtUtils jwt;

	@Autowired
	public UserController(IUserService userService) {
		this.userService = userService;
	}

	@PutMapping(value = "/favorite-article/{articleId}")
	public ResponseEntity<String> addFavoriteArticle(@PathVariable("articleId") Long id,
			@RequestHeader("Authorization") String token) {
		Long userId = null;
		if (token != null && token != "") {
			String jwtt = token.substring(7);
			userId = jwt.getId(jwtt);
		}
		String name = userService.addFavoriteArticle(id, userId);

		return new ResponseEntity<>(name, HttpStatus.OK);
	}

	@GetMapping(value = "/favorite-articles")
	public ResponseEntity<Set<ArticleDTO>> getFavoriteArticles(
			@RequestHeader("Authorization") String token) {
		Long userId = null;
		if (token != null && token != "") {
			String jwtt = token.substring(7);
			userId = jwt.getId(jwtt);
		}

		Set<ArticleDTO> articles = userService.getFavoriteArticles(userId);

		return new ResponseEntity<>(articles, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> getUser(@PathVariable("id") Long id,
			@RequestHeader("Authorization") String token) {
		UserDTO user = userService.getById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
}
