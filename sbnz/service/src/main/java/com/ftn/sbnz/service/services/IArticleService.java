package com.ftn.sbnz.service.services;

import java.util.Set;

import com.ftn.sbnz.service.controllers.dtos.ArticleDTO;
import com.ftn.sbnz.service.controllers.dtos.RateArticleDTO;

public interface IArticleService {
    ArticleDTO getArticle(Long id);
    Set<ArticleDTO> getArticlesByType(String type);
    ArticleDTO buyArticle(Long id, Long userId);
    void rateArticle(RateArticleDTO articleDTO, Long userId);
}
