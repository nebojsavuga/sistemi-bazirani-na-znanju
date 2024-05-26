package com.ftn.sbnz.service.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.sbnz.model.Code;
import com.ftn.sbnz.model.articles.Article;
import com.ftn.sbnz.model.articles.Ball;
import com.ftn.sbnz.model.articles.Barbel;
import com.ftn.sbnz.model.articles.Rating;
import com.ftn.sbnz.model.events.Purchase;
import com.ftn.sbnz.model.users.User;
import com.ftn.sbnz.service.controllers.dtos.ArticleDTO;
import com.ftn.sbnz.service.controllers.dtos.ArticleRatingDTO;
import com.ftn.sbnz.service.controllers.dtos.FullArticle;
import com.ftn.sbnz.service.controllers.dtos.RateArticleDTO;
import com.ftn.sbnz.service.exceptions.BadRequestException;
import com.ftn.sbnz.service.exceptions.NotFoundException;
import com.ftn.sbnz.service.repositories.ArticleRepository;
import com.ftn.sbnz.service.repositories.CodeRepository;
import com.ftn.sbnz.service.repositories.PurchaseRepository;
import com.ftn.sbnz.service.repositories.RatingRepository;
import com.ftn.sbnz.service.repositories.UserRepository;

@Service
public class ArticleService implements IArticleService {
    private final KieContainer kieContainer;
    private ArticleRepository articleRepository;
    private UserRepository userRepository;
    private PurchaseRepository purchaseRepository;
    private RatingRepository ratingRepository;
    private CodeRepository codeRepository;

    @Autowired
    public ArticleService(KieContainer kieContainer,
            ArticleRepository articleRepository,
            UserRepository userRepository,
            PurchaseRepository purchaseRepository,
            RatingRepository ratingRepository,
            CodeRepository codeRepository) {
        this.kieContainer = kieContainer;
        this.articleRepository = articleRepository;
        this.userRepository = userRepository;
        this.purchaseRepository = purchaseRepository;
        this.ratingRepository = ratingRepository;
        this.codeRepository = codeRepository;
    }

    @Override
    public FullArticle getArticle(Long id) {
        Optional<Article> article = articleRepository.findById(id);
        if (article.isEmpty()) {
            throw new NotFoundException("Article with that id does not exist.");
        }
        List<ArticleRatingDTO> ratings = new ArrayList<>();
        for (Rating rating : article.get().getRatings()) {
            ratings.add(new ArticleRatingDTO(article.get().getId(), rating.getRating(), rating.getExecutionTime()));
        }
        Article opt = article.get();
        FullArticle fullArticle = new FullArticle();
        fullArticle.setId(opt.getId());
        fullArticle.setName(opt.getName());
        fullArticle.setBrandName(opt.getBrandName());
        fullArticle.setPrice(opt.getPrice());
        fullArticle.setArticleType(opt.getClassName());
        fullArticle.setArticleGenderType(opt.getGender().toString());
        fullArticle.setRatings(ratings);
        if (opt instanceof Ball) {
            Ball item = (Ball) opt;
            fullArticle.setBallType("Tip lopte: " + item.getType().toString());
        } else if(opt instanceof Barbel){
            Barbel item = (Barbel) opt;
            fullArticle.setBarbelType("Tip sipke: " + item.getType().toString());
            fullArticle.setBarbelType("Tezina sipke: " + item.getWeight());
        }


        return fullArticle;
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

    private float applyCode(Long codeId, Long userId, Article article, float price) {
        if (codeId == null) {
            return price;
        }
        Optional<Code> codeToUse = codeRepository.findById(codeId);
        if (codeToUse.isEmpty()) {
            throw new NotFoundException("Code with the given id doesn't exist.");
        }
        if (codeToUse.get().getUser().getId() != userId) {
            throw new NotFoundException("Code with the given id doesn't exist.");
        }
        if (codeToUse.get().isUsed()) {
            throw new BadRequestException("Code with the given id is already used.");
        }
        if (codeToUse.get().getFlag() == 0) {
            if (codeToUse.get().getSport() != article.getSport()) {
                throw new BadRequestException("Code is only for " + codeToUse.get().getSport());
            }
        }

        price = (price * (100 - codeToUse.get().getDiscountPercentage())) / 100;
        price = price - codeToUse.get().getDiscountPrice();
        if (price < 0) {
            price = 0;
        }
        codeToUse.get().setUsed(true);
        codeToUse.get().setExecutionTime(new Date());
        codeRepository.save(codeToUse.get());

        return price;
    }

    private void saveCodeAfter5Purchases(Code code, List<Purchase> purchases) {
        for (Purchase purch : purchases) {
            Optional<Purchase> purchaseToChange = purchaseRepository.findById(purch.getId());
            if (code.getFlag() == 0) {
                purchaseToChange.get().setProcessedForSportCode(true);
            }
            purchaseRepository.save(purchaseToChange.get());
        }
        codeRepository.save(code);
    }

    private void saveCodeAfter500ePurchased(Code code, List<Purchase> purchases) {
        for (Purchase purch : purchases) {
            Optional<Purchase> purchaseToChange = purchaseRepository.findById(purch.getId());
            if (code.getFlag() == 2) {
                purchaseToChange.get().setProcessedForFavoriteCode(true);
            }
            purchaseRepository.save(purchaseToChange.get());
        }
        codeRepository.save(code);
    }

    private void saveCodeAfter4UsedCodes(Code codePriceDiscount, List<Code> usedCodes) {
        for (Code usCode : usedCodes) {
            Optional<Code> codeToChange = codeRepository.findById(usCode.getId());
            codeRepository.delete(codeToChange.get());
        }
        codeRepository.save(codePriceDiscount);
    }

    private void saveCodeAfter3UsedLoyalCodes(Code codePriceDiscount, List<Code> usedCodes) {
        for (Code usCode : usedCodes) {
            Optional<Code> codeToChange = codeRepository.findById(usCode.getId());
            codeRepository.delete(codeToChange.get());
        }
        codeRepository.save(codePriceDiscount);
    }

    @Override
    public ArticleDTO buyArticle(Long id, Long userId, Long codeId) {
        Optional<Article> article = articleRepository.findById(id);
        if (article.isEmpty()) {
            throw new NotFoundException("Article with the given id doesn't exist.");
        }
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new NotFoundException("User with the given id doesn't exist.");
        }
        float price = article.get().getPrice();
        price = applyCode(codeId, userId, article.get(), price);
        Purchase purchase = new Purchase(user.get(), article.get(), price);
        purchaseRepository.save(purchase);
        List<Purchase> purchases = new ArrayList<>();
        List<Purchase> purchasesLoyal = new ArrayList<>();
        Code code = new Code();
        Code codeLoyal = new Code();
        List<Code> usedCodes = new ArrayList<>();
        List<Code> usedLoyalCodes = new ArrayList<>();
        Code codePriceDiscount = new Code();
        Code codeLoyalPriceDiscount = new Code();
        KieSession cepKsession = kieContainer.newKieSession("cepKsessionRealtime");
        cepKsession.setGlobal("purchases", purchases);
        cepKsession.setGlobal("code", code);
        cepKsession.setGlobal("purchasesLoyal", purchasesLoyal);
        cepKsession.setGlobal("codeLoyal", codeLoyal);
        cepKsession.setGlobal("usedCodes", usedCodes);
        cepKsession.setGlobal("codePriceDiscount", codePriceDiscount);
        cepKsession.setGlobal("codeLoyalPriceDiscount", codeLoyalPriceDiscount);
        cepKsession.setGlobal("usedLoyalCodes", usedLoyalCodes);

        Set<Purchase> purchases2 = user.get().getPurchases();
        for (Purchase purchase2 : purchases2) {
            cepKsession.insert(purchase2);
        }
        Set<Code> codesToInsert = user.get().getCodes();
        for (Code codeToInsert : codesToInsert) {
            if (codeToInsert.getExecutionTime() != null)
                cepKsession.insert(codeToInsert);
        }
        cepKsession.insert("cepKupovina");
        cepKsession.fireAllRules();
        if (code.getName() != null) {
            saveCodeAfter5Purchases(code, purchases);
        }
        if (codeLoyal.getName() != null) {
            saveCodeAfter500ePurchased(codeLoyal, purchasesLoyal);
        }
        if (codePriceDiscount.getName() != null) {
            saveCodeAfter4UsedCodes(codePriceDiscount, usedCodes);
        }
        if (codeLoyalPriceDiscount.getName() != null) {
            saveCodeAfter4UsedCodes(codeLoyalPriceDiscount, usedLoyalCodes);
        }
        return new ArticleDTO(article.get().getId(), article.get().getName(), purchase.getPrice(),
                article.get().getBrandName(), article.get().getClassName());
    }

    @Override
    public void rateArticle(RateArticleDTO articleDTO, Long userId) {
        Optional<Article> article = articleRepository.findById(articleDTO.getArticleId());
        if (article.isEmpty()) {
            throw new NotFoundException("Article with the given id doesn't exist.");
        }
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new NotFoundException("User with the given id doesn't exist.");
        }
        Optional<Rating> existingRating = this.ratingRepository
                .findByUserIdAndArticleId(userId, articleDTO.getArticleId());
        if (existingRating.isPresent()) {
            existingRating.get().setRating(articleDTO.getRating());
            existingRating.get().setExecutionTime(new Date());
            this.ratingRepository.save(existingRating.get());
            return;
        }
        Rating rating = new Rating(user.get(), article.get(), articleDTO.getRating());
        ratingRepository.save(rating);
    }

}
