package com.ftn.sbnz.model.articles;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Grip")
public class Grip extends TenisArticle{
    
}
