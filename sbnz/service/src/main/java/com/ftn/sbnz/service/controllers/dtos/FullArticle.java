package com.ftn.sbnz.service.controllers.dtos;

import java.util.List;

public class FullArticle {
    private Long id;
    private String name;
    private float price;
    private String brandName;
    private String articleType;
    private String imagePath;
    private String articleGenderType;
    private List<ArticleRatingDTO> ratings;
    private String ballType;
    private String barbellWeight;
    private String barbelType;
    private String dumbellWeight;
    private String elasticBandWeight;
    private String typeOfFootballGear;
    private String numberOfCramponsFootballShoeCrampons;
    private String numberOfCramponsGrassFootballShoe;
    private String typeOfOrientiringGear;
    private String racketWeight;
    private String racketType;
    private String racketSize;
    private String racketSpanning;
    private String sweatpantsType;
    private String typeOfTenisGear;
    private String tenisShoeSole;
    private String weightliftingWeight;
    private String weightliftingTypeOfGear;
    private String weightliftingGloveSize;
    private String image;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getArticleType() {
        return articleType;
    }

    public void setArticleType(String articleType) {
        this.articleType = articleType;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getArticleGenderType() {
        return articleGenderType;
    }

    public void setArticleGenderType(String articleGenderType) {
        this.articleGenderType = articleGenderType;
    }

    public List<ArticleRatingDTO> getRatings() {
        return ratings;
    }

    public void setRatings(List<ArticleRatingDTO> ratings) {
        this.ratings = ratings;
    }

    public String getBallType() {
        return ballType;
    }

    public void setBallType(String ballType) {
        this.ballType = ballType;
    }

    public String getBarbellWeight() {
        return barbellWeight;
    }

    public void setBarbellWeight(String barbellWeight) {
        this.barbellWeight = barbellWeight;
    }

    public String getBarbelType() {
        return barbelType;
    }

    public void setBarbelType(String barbelType) {
        this.barbelType = barbelType;
    }

    public String getDumbellWeight() {
        return dumbellWeight;
    }

    public void setDumbellWeight(String dumbellWeight) {
        this.dumbellWeight = dumbellWeight;
    }

    public String getElasticBandWeight() {
        return elasticBandWeight;
    }

    public void setElasticBandWeight(String elasticBandWeight) {
        this.elasticBandWeight = elasticBandWeight;
    }

    public String getTypeOfFootballGear() {
        return typeOfFootballGear;
    }

    public void setTypeOfFootballGear(String typeOfFootballGear) {
        this.typeOfFootballGear = typeOfFootballGear;
    }

    public String getNumberOfCramponsFootballShoeCrampons() {
        return numberOfCramponsFootballShoeCrampons;
    }

    public void setNumberOfCramponsFootballShoeCrampons(String numberOfCramponsFootballShoeCrampons) {
        this.numberOfCramponsFootballShoeCrampons = numberOfCramponsFootballShoeCrampons;
    }

    public String getNumberOfCramponsGrassFootballShoe() {
        return numberOfCramponsGrassFootballShoe;
    }

    public void setNumberOfCramponsGrassFootballShoe(String numberOfCramponsGrassFootballShoe) {
        this.numberOfCramponsGrassFootballShoe = numberOfCramponsGrassFootballShoe;
    }

    public String getTypeOfOrientiringGear() {
        return typeOfOrientiringGear;
    }

    public void setTypeOfOrientiringGear(String typeOfOrientiringGear) {
        this.typeOfOrientiringGear = typeOfOrientiringGear;
    }

    public String getRacketWeight() {
        return racketWeight;
    }

    public void setRacketWeight(String racketWeight) {
        this.racketWeight = racketWeight;
    }

    public String getRacketType() {
        return racketType;
    }

    public void setRacketType(String racketType) {
        this.racketType = racketType;
    }

    public String getRacketSpanning() {
        return racketSpanning;
    }

    public void setRacketSpanning(String racketSpanning) {
        this.racketSpanning = racketSpanning;
    }

    public String getSweatpantsType() {
        return sweatpantsType;
    }

    public void setSweatpantsType(String sweatpantsType) {
        this.sweatpantsType = sweatpantsType;
    }

    public String getTypeOfTenisGear() {
        return typeOfTenisGear;
    }

    public void setTypeOfTenisGear(String typeOfTenisGear) {
        this.typeOfTenisGear = typeOfTenisGear;
    }

    public String getTenisShoeSole() {
        return tenisShoeSole;
    }

    public void setTenisShoeSole(String tenisShoeSole) {
        this.tenisShoeSole = tenisShoeSole;
    }

    public String getWeightliftingWeight() {
        return weightliftingWeight;
    }

    public void setWeightliftingWeight(String weightliftingWeight) {
        this.weightliftingWeight = weightliftingWeight;
    }

    public String getWeightliftingTypeOfGear() {
        return weightliftingTypeOfGear;
    }

    public void setWeightliftingTypeOfGear(String weightliftingTypeOfGear) {
        this.weightliftingTypeOfGear = weightliftingTypeOfGear;
    }

    public String getWeightliftingGloveSize() {
        return weightliftingGloveSize;
    }

    public void setWeightliftingGloveSize(String weightliftingGloveSize) {
        this.weightliftingGloveSize = weightliftingGloveSize;
    }

    public FullArticle() {
    }

    public FullArticle(Long id, String name, float price, String brandName, String articleType, String imagePath,
            String articleGenderType, List<ArticleRatingDTO> ratings, String ballType, String barbellWeight, String barbelType,
            String dumbellWeight, String elasticBandWeight, String typeOfFootballGear,
            String numberOfCramponsFootballShoeCrampons, String numberOfCramponsGrassFootballShoe,
            String typeOfOrientiringGear, String racketWeight, String racketType, String racketSpanning,
            String sweatpantsType, String typeOfTenisGear, String tenisShoeSole, String weightliftingWeight,
            String weightliftingTypeOfGear, String weightliftingGloveSize) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.brandName = brandName;
        this.articleType = articleType;
        this.imagePath = imagePath;
        this.articleGenderType = articleGenderType;
        this.ratings = ratings;
        this.ballType = ballType;
        this.barbellWeight = barbellWeight;
        this.barbelType = barbelType;
        this.dumbellWeight = dumbellWeight;
        this.elasticBandWeight = elasticBandWeight;
        this.typeOfFootballGear = typeOfFootballGear;
        this.numberOfCramponsFootballShoeCrampons = numberOfCramponsFootballShoeCrampons;
        this.numberOfCramponsGrassFootballShoe = numberOfCramponsGrassFootballShoe;
        this.typeOfOrientiringGear = typeOfOrientiringGear;
        this.racketWeight = racketWeight;
        this.racketType = racketType;
        this.racketSpanning = racketSpanning;
        this.sweatpantsType = sweatpantsType;
        this.typeOfTenisGear = typeOfTenisGear;
        this.tenisShoeSole = tenisShoeSole;
        this.weightliftingWeight = weightliftingWeight;
        this.weightliftingTypeOfGear = weightliftingTypeOfGear;
        this.weightliftingGloveSize = weightliftingGloveSize;
    }

    public FullArticle(Long id, String name, float price, String brandName, String articleType, String imagePath,
            String articleGenderType, List<ArticleRatingDTO> ratings) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.brandName = brandName;
        this.articleType = articleType;
        this.imagePath = imagePath;
        this.articleGenderType = articleGenderType;
        this.ratings = ratings;
    }

    public String getRacketSize() {
        return racketSize;
    }

    public void setRacketSize(String racketSize) {
        this.racketSize = racketSize;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}