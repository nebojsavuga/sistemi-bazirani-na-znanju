package com.ftn.sbnz.service.services;

import java.util.Set;

import com.ftn.sbnz.service.controllers.dtos.ArticleDTO;

public interface IArticleService {
    ArticleDTO getArticle(Long id);
    Set<ArticleDTO> getArticlesByType(String type);
}
