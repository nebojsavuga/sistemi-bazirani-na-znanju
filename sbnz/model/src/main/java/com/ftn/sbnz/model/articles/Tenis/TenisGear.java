package com.ftn.sbnz.model.articles.Tenis;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;



@Entity
public class TenisGear extends TenisArticle{

    @Enumerated(EnumType.STRING)
    private TypeOfGear type;
    
}
