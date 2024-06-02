package com.ftn.sbnz.service.services;

import java.util.List;
import java.util.Set;

import com.ftn.sbnz.service.controllers.dtos.ArticleDTO;
import com.ftn.sbnz.service.controllers.dtos.ArticleRatingDTO;
import com.ftn.sbnz.service.controllers.dtos.FullArticle;
import com.ftn.sbnz.service.controllers.dtos.RateArticleDTO;
import com.ftn.sbnz.service.controllers.dtos.RatedArticleDTO;
import com.ftn.sbnz.service.controllers.dtos.SportSalesDTO;

public interface IArticleService {
    FullArticle getArticle(Long id);
    Set<ArticleDTO> getArticlesByType(String type);
    ArticleDTO buyArticle(Long id, Long userId, Long codeId);
    void rateArticle(RateArticleDTO articleDTO, Long userId);
    FullArticle addArticle(FullArticle article);
    List<ArticleDTO> getAll();
    boolean deleteArticle(Long id);
    Set<ArticleRatingDTO> getRatings(Long id);
    Set<ArticleDTO> getPurchases(Long userId);
    Set<RatedArticleDTO> getTopFiveRatedArticles();
    SportSalesDTO getSportSales();
}
