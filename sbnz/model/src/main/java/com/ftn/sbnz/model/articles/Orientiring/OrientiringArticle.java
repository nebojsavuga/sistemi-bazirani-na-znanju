package com.ftn.sbnz.model.articles.Orientiring;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.ftn.sbnz.model.articles.Article;

@Entity
@DiscriminatorValue("OrientiringArticle")
public class OrientiringArticle extends Article{
    
}
