package com.ftn.sbnz.service.controllers.dtos;

import java.util.Date;

public class ArticleRatingDTO {

    public Long id;
    public int rating;
    public Date executionTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Date getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Date executionTime) {
        this.executionTime = executionTime;
    }

    public ArticleRatingDTO(Long id, int rating, Date executionTime) {
        this.id = id;
        this.rating = rating;
        this.executionTime = executionTime;
    }

    public ArticleRatingDTO() {
    }

}
