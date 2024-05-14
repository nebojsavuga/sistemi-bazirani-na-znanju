package com.ftn.sbnz.model.articles.Football;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("FootbalShoe")
public class FootbalShoe extends FootballArticle{
    
}
