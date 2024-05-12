package com.ftn.sbnz.model.articles.Tenis;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class TenisShoe extends TenisArticle{
    @Enumerated(EnumType.STRING)
    private Sole sole;
}
