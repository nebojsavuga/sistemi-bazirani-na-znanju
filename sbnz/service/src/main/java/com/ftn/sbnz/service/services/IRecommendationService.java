package com.ftn.sbnz.service.services;

import java.util.List;
import java.util.Set;

import com.ftn.sbnz.model.Filters;
import com.ftn.sbnz.model.RecommendedArticleDTO;

public interface IRecommendationService {
    Set<RecommendedArticleDTO> getRecommendations(Filters filters, Long userId);

    List<String> getParents(Long id);

    Set<RecommendedArticleDTO> recommendBasedOnArticle(Long id);

    void insertTemplate(List<String> brandNames);
}
