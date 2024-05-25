package com.ftn.sbnz.service.services;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.drools.template.DataProvider;
import org.drools.template.DataProviderCompiler;
import org.drools.template.objects.ArrayDataProvider;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.utils.KieHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ftn.sbnz.model.ClassNameBackward;
import com.ftn.sbnz.model.Filters;
import com.ftn.sbnz.model.RecommendedArticleDTO;
import com.ftn.sbnz.model.articles.Article;
import com.ftn.sbnz.model.articles.Rating;
import com.ftn.sbnz.model.events.Purchase;
import com.ftn.sbnz.model.users.ConcreteInjury;
import com.ftn.sbnz.model.users.Injury;
import com.ftn.sbnz.model.users.User;
import com.ftn.sbnz.service.exceptions.NotFoundException;
import com.ftn.sbnz.service.repositories.ArticleRepository;
import com.ftn.sbnz.service.repositories.ConcreteInjuryRepository;
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
    private ConcreteInjuryRepository concreteInjuryRepository;
    @Autowired
    private KieBase templateKieBase;

    private KieBase footballKieBase = null;
    private KieBase tenisKieBase = null;

    @Autowired
    public RecommendationService(KieContainer kieContainer, ArticleRepository articleRepository,
            InjuryRepository injuryRepository,
            PurchaseRepository purchaseRepository,
            RatingRepository ratingRepository,
            UserRepository userRepository,
            ConcreteInjuryRepository concreteInjuryRepository) {
        this.kieContainer = kieContainer;
        this.articleRepository = articleRepository;
        this.injuryRepository = injuryRepository;
        this.purchaseRepository = purchaseRepository;
        this.ratingRepository = ratingRepository;
        this.userRepository = userRepository;
        this.concreteInjuryRepository = concreteInjuryRepository;
    }

    @Override
    public Set<RecommendedArticleDTO> getRecommendations(Filters filters, Long userId) {
        Set<RecommendedArticleDTO> recommendations = new HashSet<>();
        KieSession kieSession = kieContainer.newKieSession("basicKsession");
        KieSession templateKsession = templateKieBase.newKieSession();
        List<Injury> injuries = injuryRepository.findAll();

        KieSession footballKsession = null;
        KieSession tenisKsession = null;
        if (this.footballKieBase != null) {
            footballKsession = footballKsession();
        }
        if (this.tenisKieBase != null) {
            tenisKsession = tenisKsession();
        }

        kieSession.setGlobal("recommendations", recommendations);
        templateKsession.setGlobal("recommendations", recommendations);
        kieSession.setGlobal("injuries", injuries);
        kieSession.insert(filters);
        templateKsession.insert(filters);
        if (this.footballKieBase != null) {
            footballKsession.setGlobal("recommendations", recommendations);
            footballKsession.insert(filters);
        }
        if (this.tenisKieBase != null) {
            tenisKsession.setGlobal("recommendations", recommendations);
            tenisKsession.insert(filters);
        }
        long totalArticles = articleRepository.count();
        int j = 0;
        for (int i = 0; i < totalArticles; i += 100) {
            PageRequest pageRequest = PageRequest.of(j, i + 100);
            Page<Article> allArticles = articleRepository.findAll(pageRequest);
            j += 1;
            for (Article article : allArticles) {
                kieSession.insert(article);
                templateKsession.insert(article);
                if (this.footballKieBase != null) {
                    footballKsession.insert(article);
                }
                if (this.tenisKieBase != null) {
                    tenisKsession.insert(article);
                }
            }
        }
        kieSession.fireAllRules();
        kieSession.dispose();
        templateKsession.fireAllRules();
        templateKsession.dispose();
        if (this.footballKieBase != null) {
            footballKsession.fireAllRules();
            footballKsession.dispose();
        }
        if (this.tenisKieBase != null) {
            tenisKsession.fireAllRules();
            tenisKsession.dispose();
        }
        KieSession cepKsession = kieContainer.newKieSession("cepKsessionRealtime");
        cepKsession.setGlobal("recommendations", recommendations);

        if (userId == null) {
            return recommendations;
        }
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            return recommendations;
        }
        List<ConcreteInjury> concreteInjuries = concreteInjuryRepository.findByUserId(userId);
        for (ConcreteInjury concreteInjury : concreteInjuries) {
            cepKsession.insert(concreteInjury);
        }
        cepKsession.setGlobal("injuries", injuries);
        cepKsession.insert(user);
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
        getClassNames(kbw, parentClasses, article.get().getClassName());
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

    private KieBase generateFootballKieBase(List<String> brandNames) {
        DataProviderCompiler converter = new DataProviderCompiler();
        InputStream footballStream = this.getClass().getResourceAsStream("/rules/basic/football-template.drt");
        String[][] brandNamesArray = new String[brandNames.size()][1];
        for (int i = 0; i < brandNames.size(); i++) {
            brandNamesArray[i][0] = brandNames.get(i);
        }
        DataProvider dataProviderFootball = new ArrayDataProvider(brandNamesArray);
        String footballDrl = converter.compile(dataProviderFootball, footballStream);

        KieHelper kieHelper = new KieHelper();
        kieHelper.addContent(footballDrl, ResourceType.DRL);

        KieServices kieServices = KieServices.Factory.get();
        kieHelper.addResource(kieServices.getResources().newClassPathResource("rules/basic/ftb-templates.drl"),
                ResourceType.DRL);

        KieBase kieBase = kieHelper.build();
        return kieBase;
    }

    private KieSession footballKsession() {
        return this.footballKieBase.newKieSession();
    }

    private KieSession tenisKsession() {
        return this.tenisKieBase.newKieSession();
    }

    @Override
    public void insertTemplate(List<String> brandNames, String sport) {
        if (sport.toLowerCase().equals("fudbal")) {
            this.footballKieBase = generateFootballKieBase(brandNames);
        } else {
            this.tenisKieBase = generateTenisKieBase(brandNames);
        }
    }

    private KieBase generateTenisKieBase(List<String> brandNames) {
        DataProviderCompiler converter = new DataProviderCompiler();
        InputStream tenisStream = this.getClass().getResourceAsStream("/rules/basic/template-tenis-template.drt");
        String[][] brandNamesArray = new String[brandNames.size()][1];
        for (int i = 0; i < brandNames.size(); i++) {
            brandNamesArray[i][0] = brandNames.get(i);
        }
        DataProvider dataProviderTenis = new ArrayDataProvider(brandNamesArray);
        String tenisDrl = converter.compile(dataProviderTenis, tenisStream);

        KieHelper kieHelper = new KieHelper();
        kieHelper.addContent(tenisDrl, ResourceType.DRL);

        KieServices kieServices = KieServices.Factory.get();
        kieHelper.addResource(kieServices.getResources().newClassPathResource("rules/basic/tns-templates.drl"),
                ResourceType.DRL);

        KieBase kieBase = kieHelper.build();
        return kieBase;
    }

}
