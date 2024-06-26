package com.ftn.sbnz.model.articles;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("TenisShoe")
public class TenisShoe extends TenisArticle{
    @Enumerated(EnumType.STRING)
    private Sole sole;

    public Sole getSole() {
        return sole;
    }

    public void setSole(Sole sole) {
        this.sole = sole;
    }

    
}
