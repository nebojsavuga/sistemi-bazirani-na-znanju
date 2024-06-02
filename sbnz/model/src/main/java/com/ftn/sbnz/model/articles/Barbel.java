package com.ftn.sbnz.model.articles;

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

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public BarbelType getType() {
        return type;
    }

    public void setType(BarbelType type) {
        this.type = type;
    }

    
}
