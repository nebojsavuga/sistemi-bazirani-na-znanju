package com.ftn.sbnz.service.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.sbnz.model.Filters;
import com.ftn.sbnz.model.RecommendedArticleDTO;
import com.ftn.sbnz.model.articles.Article;
import com.ftn.sbnz.service.repositories.ArticleRepository;

@Service
public class RecommendationService implements IRecommendationService {

	private final KieContainer kieContainer;
    private Set<RecommendedArticleDTO> recommendations = new HashSet<>();
    private ArticleRepository articleRepository;

    @Autowired
    public RecommendationService(KieContainer kieContainer, ArticleRepository articleRepository) {
        this.kieContainer = kieContainer;
        this.articleRepository = articleRepository;
    }

    @Override
    public Set<RecommendedArticleDTO> getRecommendations(Filters filters) {
        
        KieSession kieSession = kieContainer.newKieSession("basicKsession");
        RecommendedArticleDTO rc = new RecommendedArticleDTO();
        kieSession.setGlobal("recommendations", recommendations);
        kieSession.insert(rc);
        kieSession.insert(filters);
        List<Article> allArticles = articleRepository.findAll();
        for(Article article: allArticles){
            RecommendedArticleDTO recomendedArticle = new RecommendedArticleDTO();
            recomendedArticle.brandName = article.getBrandName();
            recomendedArticle.name = article.getName();
            recomendedArticle.price = article.getPrice();
            recomendedArticle.id = article.getId();
            kieSession.insert(recomendedArticle);
             
        }
        kieSession.fireAllRules();
        kieSession.dispose();
        return recommendations;
    }
}
