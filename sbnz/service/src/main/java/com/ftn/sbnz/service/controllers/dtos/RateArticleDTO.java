package com.ftn.sbnz.service.controllers.dtos;

import org.hibernate.validator.constraints.Range;

public class RateArticleDTO {
    private Long articleId;
    @Range(min = 1, max = 5)
    private int rating;

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public RateArticleDTO() {
    }

    public RateArticleDTO(Long articleId, @Range(min = 1, max = 5) int rating) {
        this.articleId = articleId;
        this.rating = rating;
    }

}
