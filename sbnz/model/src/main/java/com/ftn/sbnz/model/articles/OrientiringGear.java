package com.ftn.sbnz.model.articles;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("OrientiringGear")
public class OrientiringGear extends OrientiringArticle{

    @Enumerated(EnumType.STRING)
    private TypeOfOrientiringGear type;

    public TypeOfOrientiringGear getType() {
        return type;
    }

    public void setType(TypeOfOrientiringGear type) {
        this.type = type;
    }

    
    
}
