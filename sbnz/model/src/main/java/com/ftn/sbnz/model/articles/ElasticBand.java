package com.ftn.sbnz.model.articles;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.Min;

@Entity
@DiscriminatorValue("ElasticBand")
public class ElasticBand extends WeightliftingArticle{
    
    @Column
    @Min(1)
    private float ebWeight;

    public float getEbWeight() {
        return ebWeight;
    }

    public void setEbWeight(float weight) {
        this.ebWeight = weight;
    }
}
