package com.ftn.sbnz.model.articles.Football;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.ftn.sbnz.model.articles.Article;

@Entity
@DiscriminatorValue("FootballArticle")
public class FootballArticle extends Article{
    
}
