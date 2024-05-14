package com.ftn.sbnz.model.articles.Football;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("Ball")
public class Ball extends FootballArticle{

    @Enumerated(EnumType.STRING)
    private BallType type;
    
}
