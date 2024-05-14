package com.ftn.sbnz.service.services;

import java.util.Set;

import com.ftn.sbnz.service.controllers.dtos.Filters;
import com.ftn.sbnz.service.controllers.dtos.RecommendedArticleDTO;

public interface IRecommendationService {
    Set<RecommendedArticleDTO> getRecommendations(Filters filters);
}
