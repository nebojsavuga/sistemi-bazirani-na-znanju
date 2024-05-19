package com.ftn.sbnz.service.controllers;

import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.sbnz.model.users.User;
import com.ftn.sbnz.service.controllers.dtos.ArticleDTO;
import com.ftn.sbnz.service.controllers.dtos.RateArticleDTO;
import com.ftn.sbnz.service.exceptions.BadCredentialsException;
import com.ftn.sbnz.service.exceptions.UnauthorizedException;
import com.ftn.sbnz.service.services.IArticleService;

@CrossOrigin
@RestController
@RequestMapping(value = "api/articles")
public class ArticleController {
    private IArticleService articleService;

    @Autowired
    public ArticleController(IArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleDTO> getArticle(@PathVariable Long id) {
        return new ResponseEntity<>(this.articleService
                .getArticle(id), HttpStatus.OK);
    }

    @GetMapping("/type")
    public ResponseEntity<Set<ArticleDTO>> getArticle(@RequestParam String type) {
        return new ResponseEntity<>(this.articleService
                .getArticlesByType(type), HttpStatus.OK);
    }

    @PostMapping("buy/{id}")
    public ResponseEntity<ArticleDTO> buyArticle(@PathVariable Long id, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if(user == null){
            throw new UnauthorizedException("Please log in.");
        }
        return new ResponseEntity<>(this.articleService
                .buyArticle(id, user.getId()), HttpStatus.OK);
    }

    @PostMapping("rate")
    public ResponseEntity<RateArticleDTO> rateArticle(@Valid @RequestBody RateArticleDTO articleDTO , HttpSession session) {
        User user = (User) session.getAttribute("user");
        if(user == null){
            throw new UnauthorizedException("Please log in.");
        }
        this.articleService.rateArticle(articleDTO, user.getId());
        return new ResponseEntity<>(articleDTO, HttpStatus.OK);
    }
}
