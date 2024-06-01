package com.ftn.sbnz.service.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.sbnz.model.users.ConcreteInjury;
import com.ftn.sbnz.model.users.User;
import com.ftn.sbnz.service.config.JwtUtils;
import com.ftn.sbnz.service.controllers.dtos.ArticleDTO;
import com.ftn.sbnz.service.controllers.dtos.CodeDTO;
import com.ftn.sbnz.service.controllers.dtos.ConcreteInjuryDTO;
import com.ftn.sbnz.service.controllers.dtos.LoggedUserDTO;
import com.ftn.sbnz.service.controllers.dtos.LoggedUserInjuryDTO;
import com.ftn.sbnz.service.controllers.dtos.RegisterDTO;
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

	@PutMapping("/edit-profile")
	public ResponseEntity<String> register(@RequestBody RegisterDTO registerDTO,
			@RequestHeader("Authorization") String token) {
		Long userId = null;
		if (token != null && token != "") {
			String jwtt = token.substring(7);
			userId = jwt.getId(jwtt);
		}
		User user = userService.edit(registerDTO, userId);
		return new ResponseEntity<>("Edited profile.", HttpStatus.OK);
	}

	@PostMapping("/add-injury")
	public ResponseEntity<String> addInjury(@RequestBody ConcreteInjuryDTO injuryDTO,
			@RequestHeader("Authorization") String token) {
		Long userId = null;
		if (token != null && token != "") {
			String jwtt = token.substring(7);
			userId = jwt.getId(jwtt);
		}
		String injuryText = userService.addInjury(injuryDTO, userId);
		return new ResponseEntity<>(injuryText, HttpStatus.OK);
	}

	@GetMapping("/profile")
	public ResponseEntity<LoggedUserDTO> getLoggedUserProfile(
			@RequestHeader("Authorization") String token) {
		Long userId = null;
		if (token != null && token != "") {
			String jwtt = token.substring(7);
			userId = jwt.getId(jwtt);
		}
		LoggedUserDTO loggedUser = userService.getLoggedUserById(userId);
		return new ResponseEntity<>(loggedUser, HttpStatus.OK);
	}

	@GetMapping("/injuries")
	public ResponseEntity<List<LoggedUserInjuryDTO>> getLoggedUserAll(@RequestHeader("Authorization") String token) {
		Long userId = null;
		if (token != null && token != "") {
			String jwtt = token.substring(7);
			userId = jwt.getId(jwtt);
		}
		List<LoggedUserInjuryDTO> injuries = userService.getLoggedUserInjuries(userId);
		return new ResponseEntity<>(injuries,
				HttpStatus.OK);
	}

	@DeleteMapping("/injury/{id}")
	public ResponseEntity<String> deleteUserInjury(@PathVariable("id") Long injuryId,
			@RequestHeader("Authorization") String token) {
		Long userId = null;
		if (token != null && token != "") {
			String jwtt = token.substring(7);
			userId = jwt.getId(jwtt);
		}
		userService.deleteUserInjury(injuryId, userId);
		return new ResponseEntity<>("Successfully deleted concrete injury", HttpStatus.OK);
	}

	@DeleteMapping("/favorite-articles/{id}")
	public ResponseEntity<Boolean> deleteFavoriteArticle(@PathVariable("id") Long articleId,
			@RequestHeader("Authorization") String token) {
				Long userId = null;
		if (token != null && token != "") {
			String jwtt = token.substring(7);
			userId = jwt.getId(jwtt);
		}
		boolean deleted = userService.deleteFavoriteArticle(articleId, userId);
		return new ResponseEntity<>(deleted, HttpStatus.OK);
	}

	@GetMapping("/codes")
	public ResponseEntity<List<CodeDTO>> getCodes(@RequestHeader(value = "Authorization", required = true) String token) {
		Long userId = null;
		if (token != null && token != "") {
			String jwtt = token.substring(7);
			userId = jwt.getId(jwtt);
		}
		List<CodeDTO> codes = userService.getCodes(userId);
		return new ResponseEntity<>(codes,
				HttpStatus.OK);
	}
}
