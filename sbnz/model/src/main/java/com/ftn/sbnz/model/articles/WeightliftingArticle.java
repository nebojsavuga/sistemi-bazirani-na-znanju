package com.ftn.sbnz.model.articles;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("WeightliftingArticle")
public class WeightliftingArticle extends Article{
    
    public String getText(){
        return "Hello";
    }
}
