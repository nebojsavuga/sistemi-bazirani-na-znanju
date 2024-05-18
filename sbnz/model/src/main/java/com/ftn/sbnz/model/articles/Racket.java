package com.ftn.sbnz.model.articles;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("Racket")
public class Racket extends TenisArticle{
    @Column
    private float weight;

    @Enumerated(EnumType.STRING)
    private TypeOfRacket type;

    @Enumerated(EnumType.STRING)
    private TypeOfRacketSpanning spanningType;

    @Column
    private float size;

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public TypeOfRacket getType() {
        return type;
    }

    public void setType(TypeOfRacket type) {
        this.type = type;
    }

    public TypeOfRacketSpanning getSpanningType() {
        return spanningType;
    }

    public void setSpanningType(TypeOfRacketSpanning spanningType) {
        this.spanningType = spanningType;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    
}
