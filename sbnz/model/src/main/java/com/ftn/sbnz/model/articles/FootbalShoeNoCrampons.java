package com.ftn.sbnz.model.articles;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("FootbalShoeNoCrampons")
public class FootbalShoeNoCrampons extends FootbalShoe{
    
}
