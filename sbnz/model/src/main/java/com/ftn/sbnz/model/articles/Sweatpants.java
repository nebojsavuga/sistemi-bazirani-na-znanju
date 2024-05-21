package com.ftn.sbnz.model.articles;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("Sweatpants")
public class Sweatpants extends OrientiringArticle{
    @Enumerated(EnumType.STRING)
    private SweatpantsType type;

    public SweatpantsType getType() {
        return type;
    }

    public void setType(SweatpantsType type) {
        this.type = type;
    }

    
}
