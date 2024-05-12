package com.ftn.sbnz.model.articles.Orientiring;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Sweatpants extends OrientiringArticle{
    @Enumerated(EnumType.STRING)
    private SweatpantsType type;
}
