package com.ftn.sbnz.service.services;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.sbnz.model.articles.Article;
import com.ftn.sbnz.model.events.Purchase;
import com.ftn.sbnz.model.users.User;
import com.ftn.sbnz.service.controllers.dtos.ArticleDTO;
import com.ftn.sbnz.service.exceptions.NotFoundException;
import com.ftn.sbnz.service.repositories.ArticleRepository;
import com.ftn.sbnz.service.repositories.PurchaseRepository;
import com.ftn.sbnz.service.repositories.UserRepository;

@Service
public class ArticleService implements IArticleService {

    private ArticleRepository articleRepository;
    private UserRepository userRepository;
    private PurchaseRepository purchaseRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository,
            UserRepository userRepository,
            PurchaseRepository purchaseRepository) {
        this.articleRepository = articleRepository;
        this.userRepository = userRepository;
        this.purchaseRepository = purchaseRepository;
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
                article.get().getClassName());
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

    @Override
    public ArticleDTO buyArticle(Long id, Long userId) {
        Optional<Article> article = articleRepository.findById(id);
        if (article.isEmpty()) {
            throw new NotFoundException("Article with the given id doesn't exist.");
        }
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new NotFoundException("User with the given id doesn't exist.");
        }
        Purchase purchase = new Purchase(user.get(), article.get(), article.get().getPrice());
        purchaseRepository.save(purchase);
        return new ArticleDTO(article.get().getId(), article.get().getName(), purchase.getPrice(),
                article.get().getBrandName(), article.get().getClassName());
    }

}
