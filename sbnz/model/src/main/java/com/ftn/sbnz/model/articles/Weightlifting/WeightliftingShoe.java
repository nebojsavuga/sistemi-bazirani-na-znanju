package com.ftn.sbnz.model.articles.Weightlifting;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("WeightliftingShoe")
public class WeightliftingShoe extends WeightliftingArticle{
    
}
