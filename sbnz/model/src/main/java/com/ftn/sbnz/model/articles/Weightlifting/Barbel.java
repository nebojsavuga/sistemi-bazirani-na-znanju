package com.ftn.sbnz.model.articles.Weightlifting;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("Barbel")
public class Barbel extends WeightliftingArticle{
 
    @Column
    private float weight;

    @Enumerated(EnumType.STRING)
    private BarbelType type;
}
