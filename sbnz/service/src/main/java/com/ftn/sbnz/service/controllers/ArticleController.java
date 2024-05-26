package com.ftn.sbnz.service.controllers;

import java.util.Set;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
}
