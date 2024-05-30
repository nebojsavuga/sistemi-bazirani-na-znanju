package com.ftn.sbnz.service.controllers;

import java.util.HashSet;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.sbnz.model.Filters;
import com.ftn.sbnz.model.RecommendedArticleDTO;
import com.ftn.sbnz.model.sport.Sport;
import com.ftn.sbnz.model.sport.SportFootballPlayer;
import com.ftn.sbnz.model.sport.SportFootballType;
import com.ftn.sbnz.model.sport.SportLevel;
import com.ftn.sbnz.model.sport.SportOrientiringType;
import com.ftn.sbnz.model.sport.SportTenisField;
import com.ftn.sbnz.model.sport.SportWeightliftingType;
import com.ftn.sbnz.model.users.Gender;
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

    @GetMapping()
    public ResponseEntity<Set<RecommendedArticleDTO>> recommend(
            @RequestParam(value = "gender", required = false) Gender gender,
        @RequestParam(value = "height", required = false) Float height,
        @RequestParam(value = "age", required = false) Integer age,
        @RequestParam(value = "injuries", required = false) Set<Long> injuries,
        @RequestParam(value = "level", required = false) SportLevel level,
        @RequestParam(value = "sport", required = true) Sport sport,
        @RequestParam(value = "typeOfFootballPlayer", required = false) SportFootballPlayer typeOfFotballPlayer,
        @RequestParam(value = "typeOfFootball", required = false) SportFootballType typeOfFootball,
        @RequestParam(value = "typeOfRace", required = false) SportOrientiringType typeOfRace,
        @RequestParam(value = "typeOfField", required = false) SportTenisField typeOfField,
        @RequestParam(value = "typeOfWeightlifting", required = false) SportWeightliftingType typeOfWeightlifting,
            @RequestHeader(value = "Authorization", required = false) String token) {
        Long userId = null;
        if (token != null && !token.isEmpty()) {
            String jwtt = token.substring(7);
            userId = jwt.getId(jwtt);
        }
        Filters filters = new Filters();
        filters.gender = gender;
        filters.height = height != null ? height : 0.0f;
        filters.age = age != null ? age : 0;
        filters.injuries = injuries != null ? injuries : new HashSet<>();
        filters.level = level;
        filters.sport = sport;
        filters.typeOfFotballPlayer = typeOfFotballPlayer;
        filters.typeOfFootball = typeOfFootball;
        filters.typeOfRace = typeOfRace;
        filters.typeOfField = typeOfField;
        filters.typeOfWeightlifting = typeOfWeightlifting;
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