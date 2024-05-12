package com.ftn.sbnz.model.articles.Weightlifting;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class WeightliftingGlove extends WeightliftingArticle{
    
    @Column
    private String size;
}
