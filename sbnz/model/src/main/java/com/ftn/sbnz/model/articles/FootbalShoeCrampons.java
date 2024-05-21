package com.ftn.sbnz.model.articles;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.Min;

@Entity
@DiscriminatorValue("FootbalShoeCrampons")
public class FootbalShoeCrampons extends FootbalShoe{
    
    @Column
    @Min(1)
    private int numberOfCrampons;

    public int getNumberOfCrampons() {
        return numberOfCrampons;
    }

    public void setNumberOfCrampons(int numberOfCrampons) {
        this.numberOfCrampons = numberOfCrampons;
    }
    
}
