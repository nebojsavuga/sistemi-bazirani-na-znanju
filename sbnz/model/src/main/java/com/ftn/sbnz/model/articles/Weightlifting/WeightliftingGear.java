package com.ftn.sbnz.model.articles.Weightlifting;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("WeightliftingGear")
public class WeightliftingGear extends WeightliftingArticle{

    @Enumerated(EnumType.STRING)
    private WlTypeOfGear type;

    public WlTypeOfGear getType() {
        return type;
    }

    public void setType(WlTypeOfGear type) {
        this.type = type;
    }
    
    
}
