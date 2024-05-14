package com.ftn.sbnz.model.DTO;

import org.hibernate.validator.constraints.Range;

public class RatingDTO {
    private long articleId;

    @Range(min = 1,max = 5)
    private int rating;

    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    
    
}
