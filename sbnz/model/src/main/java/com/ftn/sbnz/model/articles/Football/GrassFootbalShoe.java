package com.ftn.sbnz.model.articles.Football;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.validator.constraints.Range;

@Entity
public class GrassFootbalShoe extends FootbalShoe{
    
    @Column
    @Range(min=4, max=12)
    private int numberOfCrampsons;
}
