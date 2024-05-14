package com.ftn.sbnz.service.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.sbnz.service.controllers.dtos.Filters;
import com.ftn.sbnz.service.controllers.dtos.RecommendedArticleDTO;
import com.ftn.sbnz.service.services.IRecommendationService;

@CrossOrigin
@RestController
@RequestMapping(value = "api/recommendation")
public class RecommendationController {

    private IRecommendationService recommendationService;

    @Autowired
    public RecommendationController(IRecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @PostMapping(value = "/")
    public ResponseEntity<Set<RecommendedArticleDTO>> recommend(@RequestBody Filters filters) {
        return new ResponseEntity<>(this.recommendationService.getRecommendations(filters), HttpStatus.OK);
    }
}