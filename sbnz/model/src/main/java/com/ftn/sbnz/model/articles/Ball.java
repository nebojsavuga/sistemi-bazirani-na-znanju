package com.ftn.sbnz.model.articles;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("Ball")
public class Ball extends FootballArticle{

    @Enumerated(EnumType.STRING)
    private BallType type;

    public BallType getType() {
        return type;
    }

    public void setType(BallType type) {
        this.type = type;
    }

    
    
}
