package com.ftn.sbnz.service.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ftn.sbnz.model.ClassNameBackward;
import com.ftn.sbnz.model.Filters;
import com.ftn.sbnz.model.RecommendedArticleDTO;
import com.ftn.sbnz.model.articles.Article;
import com.ftn.sbnz.model.articles.Rating;
import com.ftn.sbnz.model.events.Purchase;
import com.ftn.sbnz.model.users.Injury;
import com.ftn.sbnz.model.users.User;
import com.ftn.sbnz.service.exceptions.NotFoundException;
import com.ftn.sbnz.service.repositories.ArticleRepository;
import com.ftn.sbnz.service.repositories.InjuryRepository;
import com.ftn.sbnz.service.repositories.PurchaseRepository;
import com.ftn.sbnz.service.repositories.RatingRepository;
import com.ftn.sbnz.service.repositories.UserRepository;

@Service
public class RecommendationService implements IRecommendationService {

    private final KieContainer kieContainer;
    private ArticleRepository articleRepository;
    private InjuryRepository injuryRepository;
    private PurchaseRepository purchaseRepository;
    private RatingRepository ratingRepository;
    private UserRepository userRepository;

    @Autowired
    public RecommendationService(KieContainer kieContainer, ArticleRepository articleRepository,
            InjuryRepository injuryRepository,
            PurchaseRepository purchaseRepository,
            RatingRepository ratingRepository,
            UserRepository userRepository) {
        this.kieContainer = kieContainer;
        this.articleRepository = articleRepository;
        this.injuryRepository = injuryRepository;
        this.purchaseRepository = purchaseRepository;
        this.ratingRepository = ratingRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Set<RecommendedArticleDTO> getRecommendations(Filters filters, Long userId) {
        Set<RecommendedArticleDTO> recommendations = new HashSet<>();
        KieSession kieSession = kieContainer.newKieSession("basicKsession");
        List<Injury> injuries = injuryRepository.findAll();

        kieSession.setGlobal("recommendations", recommendations);
        kieSession.setGlobal("injuries", injuries);
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

        KieSession cepKsession = kieContainer.newKieSession("cepKsessionRealtime");
        cepKsession.setGlobal("recommendations", recommendations);
        
        if (userId == null) {
            return recommendations;
        }
        Optional<User> user = userRepository.findById(userId);
        if(user.isEmpty()){
            return recommendations;
        }
        cepKsession.insert(filters);
        j = 0;
        for (int i = 0; i < totalArticles; i += 100) {
            PageRequest pageRequest = PageRequest.of(j, i + 100);
            Page<Article> allArticles = articleRepository.findAll(pageRequest);
            j += 1;
            for (Article article : allArticles) {
                cepKsession.insert(article);
            }
        }
        Set<Purchase> purchases = purchaseRepository.findByUserId(user.get().getId());
        for (Purchase purchase : purchases) {
            cepKsession.insert(purchase);
        }

        Set<Rating> ratings = ratingRepository.findByUserId(user.get().getId());
        for (Rating rating : ratings) {
            cepKsession.insert(rating);
        }
        cepKsession.fireAllRules();
        cepKsession.dispose();

        return recommendations;
    }

    private List<String> getClassNames(KieSession kbw, List<String> parentClasses, String childName) {
        List<ClassNameBackward> names = new ArrayList<>();
        names.add(new ClassNameBackward("FootballArticle", "Article"));
        names.add(new ClassNameBackward("Ball", "FootballArticle"));
        names.add(new ClassNameBackward("FootbalShoe", "FootballArticle"));
        names.add(new ClassNameBackward("FootballGear", "FootballArticle"));
        names.add(new ClassNameBackward("FootbalShoeCrampons", "FootbalShoe"));
        names.add(new ClassNameBackward("FootbalShoeNoCrampons", "FootbalShoe"));
        names.add(new ClassNameBackward("GrassFootbalShoe", "FootbalShoe"));

        names.add(new ClassNameBackward("OrientiringArticle", "Article"));
        names.add(new ClassNameBackward("OrientiringGear", "OrientiringArticle"));
        names.add(new ClassNameBackward("OrientiringShoe", "OrientiringArticle"));
        names.add(new ClassNameBackward("Sweatpants", "OrientiringArticle"));
        names.add(new ClassNameBackward("BigCramponOrientiringShoe", "OrientiringShoe"));
        names.add(new ClassNameBackward("NoCramponOrientiringShoe", "OrientiringShoe"));

        names.add(new ClassNameBackward("TenisArticle", "Article"));
        names.add(new ClassNameBackward("Racket", "TenisArticle"));
        names.add(new ClassNameBackward("RacketString", "TenisArticle"));
        names.add(new ClassNameBackward("TenisGear", "TenisArticle"));
        names.add(new ClassNameBackward("TenisShoe", "TenisArticle"));
        names.add(new ClassNameBackward("Grip", "TenisArticle"));


        names.add(new ClassNameBackward("WeightliftingArticle", "Article"));
        names.add(new ClassNameBackward("Barbel", "WeightliftingArticle"));
        names.add(new ClassNameBackward("Dumbell", "WeightliftingArticle"));
        names.add(new ClassNameBackward("ElasticBand", "WeightliftingArticle"));
        names.add(new ClassNameBackward("Weight", "WeightliftingArticle"));
        names.add(new ClassNameBackward("WeightliftingGear", "WeightliftingArticle"));
        names.add(new ClassNameBackward("WeightliftingShoe", "WeightliftingArticle"));
        names.add(new ClassNameBackward("WeightliftingGlove", "WeightliftingArticle"));
        for (ClassNameBackward cnmb : names) {
            kbw.insert(cnmb);
        }
        
        parentClasses.add(childName);
        kbw.insert(childName);
        kbw.fireAllRules();
        // kbw.dispose();
        return parentClasses;
    }

    @Override
    public List<String> getParents(Long id) {
        Optional<Article> article = articleRepository.findById(id);
        if (article.isEmpty()) {
            throw new NotFoundException("Article with that id does not exist.");
        }

        KieSession kbw = kieContainer.newKieSession("bwKsession");
        List<String> parentClasses = new ArrayList<>();
        kbw.setGlobal("parentClasses", parentClasses);
        List<String> classes = getClassNames(kbw, parentClasses, article.get().getClassName());
        return classes;
    }

    @Override
    public Set<RecommendedArticleDTO> recommendBasedOnArticle(Long id) {
        Optional<Article> article = articleRepository.findById(id);
        if (article.isEmpty()) {
            throw new NotFoundException("Article with that id does not exist.");
        }
        KieSession kbw = kieContainer.newKieSession("bwKsession");
        List<String> parentClasses = new ArrayList<>();
        Set<RecommendedArticleDTO> recommendations = new HashSet<>();
        kbw.setGlobal("parentClasses", parentClasses);
        kbw.setGlobal("recommendations", recommendations);
        kbw.insert("level");
        List<String> classes = getClassNames(kbw, parentClasses, article.get().getClassName());
        long totalArticles = articleRepository.count();
        int j = 0;
        for (int i = 0; i < totalArticles; i += 100) {
            PageRequest pageRequest = PageRequest.of(j, i + 100);
            Page<Article> allArticles = articleRepository.findAll(pageRequest);
            j += 1;
            for (Article articleAll : allArticles) {
                kbw.insert(articleAll);
            }
        }
        kbw.fireAllRules();
        return recommendations;
    }

    
}
