package com.ftn.sbnz.model.articles;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("TenisGear")
public class TenisGear extends TenisArticle{

    @Enumerated(EnumType.STRING)
    private TypeOfGear gearType;

    public TypeOfGear getGearType() {
        return gearType;
    }

    public void setGearType(TypeOfGear type) {
        this.gearType = type;
    }
    
}
