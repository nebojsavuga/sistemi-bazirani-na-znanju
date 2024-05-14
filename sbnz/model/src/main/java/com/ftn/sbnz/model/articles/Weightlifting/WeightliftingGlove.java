package com.ftn.sbnz.model.articles.Weightlifting;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("WeightliftingGlove")
public class WeightliftingGlove extends WeightliftingArticle{
    
    @Column
    private String size;
}
