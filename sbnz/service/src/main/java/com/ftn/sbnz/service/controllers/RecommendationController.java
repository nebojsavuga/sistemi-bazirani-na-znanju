package com.ftn.sbnz.service.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.sbnz.model.Filters;
import com.ftn.sbnz.model.RecommendedArticleDTO;
import com.ftn.sbnz.model.sport.Sport;
import com.ftn.sbnz.service.config.JwtUtils;
import com.ftn.sbnz.service.controllers.dtos.BrandNamesDTO;
import com.ftn.sbnz.service.services.IRecommendationService;

@RestController
@RequestMapping(value = "api/recommendation")
public class RecommendationController {

    private IRecommendationService recommendationService;
    @Autowired
    JwtUtils jwt;

    @Autowired
    public RecommendationController(IRecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @PutMapping()
    public ResponseEntity<Set<RecommendedArticleDTO>> recommend(@RequestBody Filters filters,
            @RequestHeader(value = "Authorization", required = false) String token) {
        Long userId = null;
        if (token != null && !token.isEmpty()) {
            String jwtt = token.substring(7);
            userId = jwt.getId(jwtt);
        }
        return new ResponseEntity<>(this.recommendationService.getRecommendations(filters, userId), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<String>> getParents(@PathVariable Long id) {
        return new ResponseEntity<>(this.recommendationService.getParents(id), HttpStatus.OK);
    }
    
    @GetMapping("/based-on-article/{id}")
    public ResponseEntity<Set<RecommendedArticleDTO>> recommendBasedOnArticle(@PathVariable Long id){
        return new ResponseEntity<>(this.recommendationService.recommendBasedOnArticle(id), HttpStatus.OK);
    }

    @PutMapping("football-template")
    public ResponseEntity<Set<RecommendedArticleDTO>> insertFootballTemplate(
            @RequestBody BrandNamesDTO brandNames,
            @RequestHeader("Authorization") String token) {
        if (token != null && token != "") {
            String jwtt = token.substring(7);
            String role = jwt.getRole(jwtt);
            if(!role.toLowerCase().contains("admin")){
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        }else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        this.recommendationService.insertTemplate(brandNames.getBrandNames(), Sport.Fudbal.toString());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("tenis-template")
    public ResponseEntity<Set<RecommendedArticleDTO>> insertTenisTemplate(
            @RequestBody BrandNamesDTO brandNames,
            @RequestHeader("Authorization") String token) {
        if (token != null && token != "") {
            String jwtt = token.substring(7);
            String role = jwt.getRole(jwtt);
            if(!role.toLowerCase().contains("admin")){
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        }else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        this.recommendationService.insertTemplate(brandNames.getBrandNames(), Sport.Tenis.toString());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}