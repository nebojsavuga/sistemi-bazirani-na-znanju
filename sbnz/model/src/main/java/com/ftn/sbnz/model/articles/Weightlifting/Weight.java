package com.ftn.sbnz.model.articles.Weightlifting;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Weight extends WeightliftingArticle{

    @Column
    private float weight;
    
}
