package com.ftn.sbnz.model.articles.Weightlifting;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Min;

@Entity
public class Dumbell extends WeightliftingArticle {

    @Column
    @Min(1)
    private float weight;
}
