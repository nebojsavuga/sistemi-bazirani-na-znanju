package com.ftn.sbnz.model.articles;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("WeightliftingGlove")
public class WeightliftingGlove extends WeightliftingArticle{
    
    @Column
    private String gloveSize;

    public String getGloveSize() {
        return gloveSize;
    }

    public void setGloveSize(String gloveSize) {
        this.gloveSize = gloveSize;
    }

    
}
