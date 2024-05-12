package com.ftn.sbnz.model.articles.Football;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class FootballGear extends FootballArticle{
    
    @Enumerated(EnumType.STRING)
    private GearType type;

}
