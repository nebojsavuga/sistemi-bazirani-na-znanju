package com.ftn.sbnz.service.services;

import java.util.List;
import java.util.Set;

import com.ftn.sbnz.model.Filters;
import com.ftn.sbnz.model.RecommendedArticleDTO;
import com.ftn.sbnz.model.users.User;

public interface IRecommendationService {
    Set<RecommendedArticleDTO> getRecommendations(Filters filters, User user);

    List<String> getParents(Long id);
}
