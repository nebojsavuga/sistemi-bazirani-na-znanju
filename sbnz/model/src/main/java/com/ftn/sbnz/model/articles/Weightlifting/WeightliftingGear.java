package com.ftn.sbnz.model.articles.Weightlifting;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class WeightliftingGear extends WeightliftingArticle{

    @Enumerated(EnumType.STRING)
    private TypeOfGear type;
    
}
