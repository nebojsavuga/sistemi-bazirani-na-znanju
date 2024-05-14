package com.ftn.sbnz.model.articles.Orientiring;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("OrientiringGear")
public class OrientiringGear extends OrientiringArticle{

    @Enumerated(EnumType.STRING)
    private TypeOfGear type;
    
}
