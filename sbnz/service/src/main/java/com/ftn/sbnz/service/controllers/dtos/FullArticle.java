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
    private float barbellWeight;
    private String barbelType;
    private float dumbellWeight;
    private float elasticBandWeight;
    private String typeOfFootballGear;
    private Integer numberOfCramponsFootballShoeCrampons;
    private Integer numberOfCramponsGrassFootballShoe;
    private String typeOfOrientiringGear;
    private float racketWeight;
    private String racketType;
    private String racketSpanning;
    private String sweatpantsType;
    private String typeOfTenisGear;
    private String tenisShoeSole;
    private float weightliftingWeight;
    private String weightliftingTypeOfGear;
    private String weightliftingGloveSize;

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

    public float getBarbellWeight() {
        return barbellWeight;
    }

    public void setBarbellWeight(float barbellWeight) {
        this.barbellWeight = barbellWeight;
    }

    public String getBarbelType() {
        return barbelType;
    }

    public void setBarbelType(String barbelType) {
        this.barbelType = barbelType;
    }

    public float getDumbellWeight() {
        return dumbellWeight;
    }

    public void setDumbellWeight(float dumbellWeight) {
        this.dumbellWeight = dumbellWeight;
    }

    public float getElasticBandWeight() {
        return elasticBandWeight;
    }

    public void setElasticBandWeight(float elasticBandWeight) {
        this.elasticBandWeight = elasticBandWeight;
    }

    public String getTypeOfFootballGear() {
        return typeOfFootballGear;
    }

    public void setTypeOfFootballGear(String typeOfFootballGear) {
        this.typeOfFootballGear = typeOfFootballGear;
    }

    public Integer getNumberOfCramponsFootballShoeCrampons() {
        return numberOfCramponsFootballShoeCrampons;
    }

    public void setNumberOfCramponsFootballShoeCrampons(Integer numberOfCramponsFootballShoeCrampons) {
        this.numberOfCramponsFootballShoeCrampons = numberOfCramponsFootballShoeCrampons;
    }

    public Integer getNumberOfCramponsGrassFootballShoe() {
        return numberOfCramponsGrassFootballShoe;
    }

    public void setNumberOfCramponsGrassFootballShoe(Integer numberOfCramponsGrassFootballShoe) {
        this.numberOfCramponsGrassFootballShoe = numberOfCramponsGrassFootballShoe;
    }

    public String getTypeOfOrientiringGear() {
        return typeOfOrientiringGear;
    }

    public void setTypeOfOrientiringGear(String typeOfOrientiringGear) {
        this.typeOfOrientiringGear = typeOfOrientiringGear;
    }

    public float getRacketWeight() {
        return racketWeight;
    }

    public void setRacketWeight(float racketWeight) {
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

    public float getWeightliftingWeight() {
        return weightliftingWeight;
    }

    public void setWeightliftingWeight(float weightliftingWeight) {
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
            String articleGenderType, List<ArticleRatingDTO> ratings, String ballType, float barbellWeight, String barbelType,
            float dumbellWeight, float elasticBandWeight, String typeOfFootballGear,
            Integer numberOfCramponsFootballShoeCrampons, Integer numberOfCramponsGrassFootballShoe,
            String typeOfOrientiringGear, float racketWeight, String racketType, String racketSpanning,
            String sweatpantsType, String typeOfTenisGear, String tenisShoeSole, float weightliftingWeight,
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
}