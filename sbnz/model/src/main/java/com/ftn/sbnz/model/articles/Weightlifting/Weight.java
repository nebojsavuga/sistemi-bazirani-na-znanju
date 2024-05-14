package com.ftn.sbnz.model.articles.Weightlifting;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Weight")
public class Weight extends WeightliftingArticle{

    @Column
    private float weight;
    
}
