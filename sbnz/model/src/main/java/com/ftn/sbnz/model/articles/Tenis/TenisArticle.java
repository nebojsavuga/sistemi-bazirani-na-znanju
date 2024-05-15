package com.ftn.sbnz.model.articles.Tenis;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.ftn.sbnz.model.articles.Article;

@Entity
@DiscriminatorValue("TenisArticle")
public class TenisArticle extends Article{
    
}
