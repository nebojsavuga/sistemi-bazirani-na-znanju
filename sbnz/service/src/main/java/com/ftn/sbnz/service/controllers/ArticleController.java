package com.ftn.sbnz.service.controllers;

import java.util.Set;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.sbnz.service.config.JwtUtils;
import com.ftn.sbnz.service.controllers.dtos.ArticleDTO;
import com.ftn.sbnz.service.controllers.dtos.ArticleRatingDTO;
import com.ftn.sbnz.service.controllers.dtos.FullArticle;
import com.ftn.sbnz.service.controllers.dtos.RateArticleDTO;
import com.ftn.sbnz.service.services.IArticleService;

@RestController
@RequestMapping(value = "api/articles")
public class ArticleController {
    private IArticleService articleService;
    @Autowired
    private JwtUtils jwt;

    @Autowired
    public ArticleController(IArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<FullArticle> getArticle(@PathVariable Long id) {
        return new ResponseEntity<>(this.articleService
                .getArticle(id), HttpStatus.OK);
    }

    @PermitAll
    @GetMapping("/type")
    public ResponseEntity<Set<ArticleDTO>> getArticle(@RequestParam String type) {
        return new ResponseEntity<>(this.articleService
                .getArticlesByType(type), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> GetAllArticles(@RequestHeader("Authorization") String token) {
        String role = "";
        if (token != null && !token.isEmpty()) {
            String jwtt = token.substring(7);
            role = jwt.getRole(jwtt);
            if (!role.toLowerCase().contains("admin")) {
                return new ResponseEntity<>("Nemate pravo za upravljanje artiklima.", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("Nemate pravo za upravljanje artiklima.", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(this.articleService.getAll(), HttpStatus.OK);
    }

    @PermitAll
    @PostMapping("buy/{id}")
    public ResponseEntity<ArticleDTO> buyArticle(@PathVariable Long id,
            @RequestHeader("Authorization") String token,
            @RequestParam(value = "codeId", required = false) Long codeId) {
        Long userId = null;
        if (token != null && token != "") {
            String jwtt = token.substring(7);
            userId = jwt.getId(jwtt);
        }
        return new ResponseEntity<>(this.articleService
                .buyArticle(id, userId, codeId), HttpStatus.OK);
    }

    @PostMapping("rate")
    public ResponseEntity<RateArticleDTO> rateArticle(@Valid @RequestBody RateArticleDTO articleDTO,
            @RequestHeader("Authorization") String token) {
        Long userId = null;
        if (token != null && token != "") {
            String jwtt = token.substring(7);
            userId = jwt.getId(jwtt);
        }
        this.articleService.rateArticle(articleDTO, userId);
        return new ResponseEntity<>(articleDTO, HttpStatus.OK);
    }

    @GetMapping("rate/{id}")
    public ResponseEntity<Set<ArticleRatingDTO>> getRating(@PathVariable Long id,
            @RequestHeader(value = "Authorization", required = false) String token) {
        return new ResponseEntity<>(this.articleService.getRatings(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> addArticle(@Valid @RequestBody FullArticle articleDTO,
            @RequestHeader("Authorization") String token) {
        if (token != null && !token.isEmpty()) {
            String jwtt = token.substring(7);
            String role = jwt.getRole(jwtt);
            if (!role.toLowerCase().contains("admin")) {
                return new ResponseEntity<>("Nemate pravo za kreiranje artikala.", HttpStatus.BAD_REQUEST);
            }
        }
        this.articleService.addArticle(articleDTO);
        return new ResponseEntity<>(articleDTO, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteArticle(@PathVariable Long id,
            @RequestHeader("Authorization") String token) {
        String role = "";
        if (token != null && !token.isEmpty()) {
            String jwtt = token.substring(7);
            role = jwt.getRole(jwtt);
            if (!role.toLowerCase().contains("admin")) {
                return new ResponseEntity<>("Nemate pravo za upravljanje artiklima.", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("Nemate pravo za upravljanje artiklima.", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(this.articleService.deleteArticle(id), HttpStatus.OK);
    }

    @GetMapping("/purchases")
    public ResponseEntity<Set<ArticleDTO>> getPurchases(
            @RequestHeader(value = "Authorization", required = true) String token) {
        Long userId = null;
        if (token != null && token != "") {
            String jwtt = token.substring(7);
            userId = jwt.getId(jwtt);
        }
        return new ResponseEntity<>(this.articleService
                .getPurchases(userId), HttpStatus.OK);
    }

    @GetMapping("top-ratings")
    public ResponseEntity<?> getTopRatedArticles(
            @RequestHeader(value = "Authorization", required = true) String token) {
        String role = "";
        if (token != null && token != "") {
            String jwtt = token.substring(7);
            role = jwt.getRole(jwtt);
            if (!role.toLowerCase().contains("admin")) {
                return new ResponseEntity<>("Nemate pravo za upravljanje artiklima.", HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<>(this.articleService
                .getTopFiveRatedArticles(), HttpStatus.OK);
    }
}
