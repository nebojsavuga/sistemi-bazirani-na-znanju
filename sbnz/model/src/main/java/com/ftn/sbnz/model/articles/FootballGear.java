package com.ftn.sbnz.model.articles;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("FootballGear")
public class FootballGear extends FootballArticle{
    
    @Enumerated(EnumType.STRING)
    private GearTypeFootball type;

    public GearTypeFootball getType() {
        return type;
    }

    public void setType(GearTypeFootball type) {
        this.type = type;
    }

    



}
