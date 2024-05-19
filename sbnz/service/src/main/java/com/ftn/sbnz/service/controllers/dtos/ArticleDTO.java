package com.ftn.sbnz.service.controllers.dtos;

public class ArticleDTO {
    public Long id;
    public String name;
    public float price;
    public String brandName;
    public String articleType;

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

    public ArticleDTO(Long id, String name, float price, String brandName, String articleType) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.brandName = brandName;
        this.articleType = articleType;
    }
}
