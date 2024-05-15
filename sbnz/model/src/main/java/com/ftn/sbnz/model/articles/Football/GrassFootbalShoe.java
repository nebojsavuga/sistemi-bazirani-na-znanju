package com.ftn.sbnz.model.articles.Football;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.hibernate.validator.constraints.Range;

@Entity
@DiscriminatorValue("GrassFootbalShoe")
public class GrassFootbalShoe extends FootbalShoe{
    
    @Column
    @Range(min=4, max=12)
    private int numberOfCrampsons;

    public int getNumberOfCrampsons() {
        return numberOfCrampsons;
    }

    public void setNumberOfCrampsons(int numberOfCrampsons) {
        this.numberOfCrampsons = numberOfCrampsons;
    }

    
}
