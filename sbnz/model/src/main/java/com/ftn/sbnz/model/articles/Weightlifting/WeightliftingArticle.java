package com.ftn.sbnz.model.articles.Weightlifting;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.ftn.sbnz.model.articles.Article;

@Entity
@DiscriminatorValue("WeightliftingArticle")
public class WeightliftingArticle extends Article{
    
    public String getText(){
        return "Hello";
    }
}
