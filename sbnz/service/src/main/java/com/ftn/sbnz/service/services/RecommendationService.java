package com.ftn.sbnz.service.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ftn.sbnz.model.Filters;
import com.ftn.sbnz.model.RecommendedArticleDTO;
import com.ftn.sbnz.model.articles.Article;
import com.ftn.sbnz.service.repositories.ArticleRepository;

@Service
public class RecommendationService implements IRecommendationService {

    private final KieContainer kieContainer;
    private ArticleRepository articleRepository;

    @Autowired
    public RecommendationService(KieContainer kieContainer, ArticleRepository articleRepository) {
        this.kieContainer = kieContainer;
        this.articleRepository = articleRepository;
    }

    @Override
    public Set<RecommendedArticleDTO> getRecommendations(Filters filters) {
        Set<RecommendedArticleDTO> recommendations = new HashSet<>();
        KieSession kieSession = kieContainer.newKieSession("basicKsession");
        kieSession.setGlobal("recommendations", recommendations);
        kieSession.insert(filters);

        long totalArticles = articleRepository.count();
        int j = 0;
        for (int i = 0; i < totalArticles; i += 100) {
            PageRequest pageRequest = PageRequest.of(j, i + 100);
            Page<Article> allArticles = articleRepository.findAll(pageRequest);
            j += 1;
            for (Article article : allArticles) {
                kieSession.insert(article);
            }
        }

        kieSession.fireAllRules();
        kieSession.dispose();
        return recommendations;
    }
}
