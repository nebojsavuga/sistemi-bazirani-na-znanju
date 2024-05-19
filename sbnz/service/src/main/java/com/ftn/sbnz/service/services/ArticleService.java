package com.ftn.sbnz.service.services;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.sbnz.model.articles.Article;
import com.ftn.sbnz.service.controllers.dtos.ArticleDTO;
import com.ftn.sbnz.service.exceptions.NotFoundException;
import com.ftn.sbnz.service.repositories.ArticleRepository;

@Service
public class ArticleService implements IArticleService {

    private ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public ArticleDTO getArticle(Long id) {
        Optional<Article> article = articleRepository.findById(id);
        if (article.isEmpty()) {
            throw new NotFoundException("Article with that id does not exist.");
        }
        return new ArticleDTO(
                article.get().getId(),
                article.get().getName(),
                article.get().getPrice(),
                article.get().getBrandName(),
                "");
    }

    @Override
    public Set<ArticleDTO> getArticlesByType(String type) {
        Class<?> classType;
        try {
            classType = Class.forName("com.ftn.sbnz.model.articles." + type);
        } catch (ClassNotFoundException e) {
            throw new NotFoundException("No articles of type " + type + " found.");

        }
        Set<Article> articles = articleRepository.findArticlesByType(classType);
        if (articles.isEmpty()) {
            throw new NotFoundException("No articles of type " + classType.getSimpleName() + " found.");
        }
        return articles.stream()
                .map(article -> new ArticleDTO(
                        article.getId(),
                        article.getName(),
                        article.getPrice(),
                        article.getBrandName(),
                        type))
                .collect(Collectors.toSet());
    }

}
