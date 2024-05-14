package com.ftn.sbnz.service.services;

import java.util.Set;

import com.ftn.sbnz.model.Filters;
import com.ftn.sbnz.model.RecommendedArticleDTO;

public interface IRecommendationService {
    Set<RecommendedArticleDTO> getRecommendations(Filters filters);
}
