package com.ftn.sbnz.model.articles.Weightlifting;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("WeightliftingGear")
public class WeightliftingGear extends WeightliftingArticle{

    @Enumerated(EnumType.STRING)
    private TypeOfGear type;
    
}
