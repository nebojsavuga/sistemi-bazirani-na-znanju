package com.ftn.sbnz.service.controllers.dtos;

public class RatedArticleDTO {
    public Long id;
    public String name;
    public float price;
    public String brandName;
    public String articleType;
    public String pathToImage;
    public double rating;
    public int totalRatings;

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

    public String getPathToImage() {
        return pathToImage;
    }

    public void setPathToImage(String pathToImage) {
        this.pathToImage = pathToImage;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getTotalRatings() {
        return totalRatings;
    }

    public void setTotalRatings(int totalRatings) {
        this.totalRatings = totalRatings;
    }

    public RatedArticleDTO(Long id, String name, float price, String brandName, String articleType, String pathToImage,
            double rating, int totalRatings) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.brandName = brandName;
        this.articleType = articleType;
        this.pathToImage = pathToImage;
        this.rating = rating;
        this.totalRatings = totalRatings;
    }

}
