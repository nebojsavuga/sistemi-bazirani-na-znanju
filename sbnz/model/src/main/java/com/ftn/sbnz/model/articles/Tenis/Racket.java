package com.ftn.sbnz.model.articles.Tenis;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Racket extends TenisArticle{
    @Column
    private float weight;

    @Enumerated(EnumType.STRING)
    private TypeOfRacket type;

    @Enumerated(EnumType.STRING)
    private TypeOfRacketSpanning spanningType;

    @Column
    private float size;
}
