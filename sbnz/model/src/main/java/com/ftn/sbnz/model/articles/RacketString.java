package com.ftn.sbnz.model.articles;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("RacketString")
public class RacketString extends TenisArticle{
    
}
