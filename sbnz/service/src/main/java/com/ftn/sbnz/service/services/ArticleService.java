package com.ftn.sbnz.service.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Base64;
import java.util.Calendar;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.sbnz.model.Code;
import com.ftn.sbnz.model.articles.Article;
import com.ftn.sbnz.model.articles.ArticleGenderType;
import com.ftn.sbnz.model.articles.Ball;
import com.ftn.sbnz.model.articles.Barbel;
import com.ftn.sbnz.model.articles.Dumbell;
import com.ftn.sbnz.model.articles.ElasticBand;
import com.ftn.sbnz.model.articles.FootbalShoeCrampons;
import com.ftn.sbnz.model.articles.FootballGear;
import com.ftn.sbnz.model.articles.GrassFootbalShoe;
import com.ftn.sbnz.model.articles.OrientiringGear;
import com.ftn.sbnz.model.articles.Racket;
import com.ftn.sbnz.model.articles.Rating;
import com.ftn.sbnz.model.articles.Sweatpants;
import com.ftn.sbnz.model.articles.TenisGear;
import com.ftn.sbnz.model.articles.TenisShoe;
import com.ftn.sbnz.model.articles.Weight;
import com.ftn.sbnz.model.articles.WeightliftingGear;
import com.ftn.sbnz.model.articles.WeightliftingGlove;
import com.ftn.sbnz.model.events.Purchase;
import com.ftn.sbnz.model.users.User;
import com.ftn.sbnz.service.controllers.dtos.ArticleDTO;
import com.ftn.sbnz.service.controllers.dtos.ArticleRatingDTO;
import com.ftn.sbnz.service.controllers.dtos.FullArticle;
import com.ftn.sbnz.service.controllers.dtos.RateArticleDTO;
import com.ftn.sbnz.service.controllers.dtos.RatedArticleDTO;
import com.ftn.sbnz.service.controllers.dtos.SportSaleDTO;
import com.ftn.sbnz.service.controllers.dtos.SportSalesDTO;
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
    private static final Pattern BASE64_IMAGE_PATTERN = Pattern.compile("^data:image/(\\w+);base64,");

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
        fullArticle.setImagePath(opt.getPathToImage());
        if (opt instanceof Ball) {
            Ball item = (Ball) opt;
            fullArticle.setBallType("Tip lopte: " + item.getType().toString());
        } else if (opt instanceof Barbel) {
            Barbel item = (Barbel) opt;
            fullArticle.setBarbelType("Tip sipke: " + item.getType().toString());
            fullArticle.setBarbelType("Tezina sipke: " + item.getWeight());
        } else if (opt instanceof Dumbell) {
            Dumbell item = (Dumbell) opt;
            fullArticle.setDumbellWeight("Tezina bucice: " + item.getWeight());
        } else if (opt instanceof ElasticBand) {
            ElasticBand item = (ElasticBand) opt;
            fullArticle.setElasticBandWeight("Tezina elasticne trake: " + item.getEbWeight());
        } else if (opt instanceof FootballGear) {
            FootballGear item = (FootballGear) opt;
            fullArticle.setTypeOfFootballGear("Tip opreme: " + item.getType().toString());
        } else if (opt instanceof FootbalShoeCrampons) {
            FootbalShoeCrampons item = (FootbalShoeCrampons) opt;
            fullArticle.setNumberOfCramponsFootballShoeCrampons("Broj krampona: " + item.getNumberOfCrampons());
        } else if (opt instanceof GrassFootbalShoe) {
            GrassFootbalShoe item = (GrassFootbalShoe) opt;
            fullArticle.setNumberOfCramponsGrassFootballShoe("Broj krampona: " + item.getNumberOfCrampsons());
        } else if (opt instanceof OrientiringGear) {
            OrientiringGear item = (OrientiringGear) opt;
            fullArticle.setTypeOfOrientiringGear("Tip opreme: " + item.getType().toString());
        } else if (opt instanceof Racket) {
            Racket item = (Racket) opt;
            fullArticle.setRacketSpanning("Spanovanje: " + item.getSpanningType().toString());
            fullArticle.setRacketType("Tip reketa: " + item.getType().toString());
            fullArticle.setRacketWeight("Tezina reketa: " + item.getWeight());
            fullArticle.setRacketSize("Velicina reketa (in): " + item.getSize());
        } else if (opt instanceof Sweatpants) {
            Sweatpants item = (Sweatpants) opt;
            fullArticle.setSweatpantsType("Tip trenerke: " + item.getType().toString());
        } else if (opt instanceof TenisGear) {
            TenisGear item = (TenisGear) opt;
            fullArticle.setTypeOfTenisGear("Tip opreme: " + item.getGearType().toString());
        } else if (opt instanceof TenisShoe) {
            TenisShoe item = (TenisShoe) opt;
            fullArticle.setTenisShoeSole("Tip djona: " + item.getSole().toString());
        } else if (opt instanceof Weight) {
            Weight item = (Weight) opt;
            fullArticle.setWeightliftingWeight("Tezina tega: " + item.getWeight());
        } else if (opt instanceof WeightliftingGear) {
            WeightliftingGear item = (WeightliftingGear) opt;
            fullArticle.setWeightliftingTypeOfGear("Tip opreme: " + item.getType().toString());
        } else if (opt instanceof WeightliftingGlove) {
            WeightliftingGlove item = (WeightliftingGlove) opt;
            fullArticle.setWeightliftingGloveSize("Velicina rukavice: " + item.getGloveSize());
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
        List<Article> allArticles = articleRepository.findAll();

        Set<Article> articles = new HashSet<>();
        for (Article article : allArticles) {
            if (classType.isInstance(article)) {
                articles.add(article);
            }
        }
        if (articles.isEmpty()) {
            throw new NotFoundException("No articles of type " + classType.getSimpleName() + " found.");
        }
        return articles.stream()
                .map(article -> new ArticleDTO(
                        article.getId(),
                        article.getName(),
                        article.getPrice(),
                        article.getBrandName(),
                        type,
                        article.getPathToImage()))
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
            saveCodeAfter3UsedLoyalCodes(codeLoyalPriceDiscount, usedLoyalCodes);
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

    @Override
    public FullArticle addArticle(FullArticle article) {
        Article art = new Article();
        art.setBrandName(article.getBrandName());
        art.setName(article.getName());
        art.setGender(ArticleGenderType.valueOf(article.getArticleGenderType()));
        art.setPrice(article.getPrice());

        art = articleRepository.save(art);
        article.setId(art.getId());
        String image = article.getImage();
        try {
            // Extract the image file type from the Base64 string
            Matcher matcher = BASE64_IMAGE_PATTERN.matcher(image);
            if (!matcher.find()) {
                throw new BadRequestException("Los format slike.");
            }
            String fileType = matcher.group(1); // Extracts the file type (e.g., png, jpg)

            // Decode the Base64 image string
            String base64Image = image.substring(image.indexOf(",") + 1);
            byte[] imageBytes = Base64.getDecoder().decode(base64Image);

            // Define the path where the image will be saved
            String directoryPath = "service/images";
            File directory = new File(directoryPath);
            if (!directory.exists()) {
                directory.mkdirs(); // Create the directory if it doesn't exist
            }

            File imageFile = new File(directoryPath + "/" + article.getId() + "." + fileType);
            art.setPathToImage(article.getId() + "." + fileType);
            articleRepository.save(art);
            // Save the image to the file system
            try (FileOutputStream fos = new FileOutputStream(imageFile)) {
                fos.write(imageBytes);
            }

        } catch (IOException e) {
            throw new BadRequestException(e.getLocalizedMessage());
        }
        return article;
    }

    @Override
    public List<ArticleDTO> getAll() {
        List<Article> articles = this.articleRepository.findAll();
        return articles.stream()
                .map(article -> new ArticleDTO(
                        article.getId(),
                        article.getName(),
                        article.getPrice(),
                        article.getBrandName(),
                        article.getClassName(),
                        article.getPathToImage()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteArticle(Long id) {
        Optional<Article> article = articleRepository.findById(id);
        if (article.isEmpty()) {
            throw new NotFoundException("Article with that id does not exist.");
        }
        this.articleRepository.delete(article.get());
        return true;
    }

    @Override
    public Set<ArticleRatingDTO> getRatings(Long id) {
        Optional<Article> article = articleRepository.findById(id);
        if (article.isEmpty()) {
            throw new NotFoundException("Article with that id does not exist.");
        }
        Set<Rating> ratings = article.get().getRatings();

        return ratings.stream()
                .map(rating -> new ArticleRatingDTO(
                        rating.getId(),
                        rating.getRating(),
                        rating.getExecutionTime()))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<ArticleDTO> getPurchases(Long userId) {
        Set<Purchase> purchases = purchaseRepository.findByUserId(userId);
        return purchases.stream()
                .map(articlePurchase -> new ArticleDTO(
                        articlePurchase.getArticle().getId(),
                        articlePurchase.getArticle().getName(),
                        articlePurchase.getPrice(),
                        articlePurchase.getArticle().getBrandName(),
                        articlePurchase.getArticle().getClassName(),
                        articlePurchase.getArticle().getPathToImage()))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<RatedArticleDTO> getTopFiveRatedArticles() {
        List<Article> allArticles = articleRepository.findAll();

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -1);
        Date oneYearAgo = calendar.getTime();
        List<RatedArticleDTO> topRated = new ArrayList<>();
        for (Article article : allArticles) {
            Set<Rating> recentRatings = article.getRatings().stream()
                    .filter(rating -> rating.getExecutionTime().after(oneYearAgo))
                    .collect(Collectors.toSet());
            double averageRating = recentRatings.stream()
                    .mapToDouble(Rating::getRating)
                    .average()
                    .orElse(0);
            topRated.add(new RatedArticleDTO(article.getId(), article.getName(),
                    article.getPrice(), article.getBrandName(),
                    article.getClassName(), article.getPathToImage(), averageRating, recentRatings.size()));
        }

        Set<RatedArticleDTO> topRatedArticles = topRated.stream()
                .filter(article -> article.getRating() > 0)
                .sorted(Comparator.comparingDouble(RatedArticleDTO::getRating).reversed())
                .limit(5)
                .collect(Collectors.toSet());
        return topRatedArticles;
    }

    @Override
    public SportSalesDTO getSportSales() {
        List<Purchase> purchases = purchaseRepository.findAll();
        List<SportSaleDTO> sales = new ArrayList<>();
        SportSaleDTO football = new SportSaleDTO("fudbal", 0);
        SportSaleDTO weights = new SportSaleDTO("dizanjeTegova", 0);
        SportSaleDTO orientiring = new SportSaleDTO("orijentiring", 0);
        SportSaleDTO tenis = new SportSaleDTO("tenis", 0);

        for (Purchase purchase : purchases) {
            String sport = purchase.getArticle().getSport().toLowerCase();
            if (sport.equals("fudbal")) {
                football.addSale();
            } else if (sport.equals("dizanjetegova")) {
                weights.addSale();
            } else if (sport.equals("orijentiring") || sport.equals("orientiring")) {
                orientiring.addSale();
            } else if (sport.equals("tenis")) {
                tenis.addSale();
            }
        }
        sales.add(football);
        sales.add(tenis);
        sales.add(orientiring);
        sales.add(weights);
        return new SportSalesDTO(sales, purchases.size());
    }
}
