package com.ftn.sbnz.model.articles;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @Column
    private float price;

    @OneToMany(mappedBy = "article")
    private Set<Rating> ratings = new HashSet<Rating>();

    @Enumerated(EnumType.STRING)
    private ArticleGenderType gender;

    @Column
    private String brandName;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Set<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(Set<Rating> ratings) {
        this.ratings = ratings;
    }

    public ArticleGenderType getGender() {
        return gender;
    }

    public void setGender(ArticleGenderType gender) {
        this.gender = gender;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + Float.floatToIntBits(price);
        result = prime * result + ((ratings == null) ? 0 : ratings.hashCode());
        result = prime * result + ((gender == null) ? 0 : gender.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Article other = (Article) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
            return false;
        if (ratings == null) {
            if (other.ratings != null)
                return false;
        } else if (!ratings.equals(other.ratings))
            return false;
        if (gender != other.gender)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Article [id=" + id + ", name=" + name + ", price=" + price + ", ratings=" + ratings + ", gender="
                + gender + "]";
    }

    public Article() {
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Article(Long id, String name, float price, Set<Rating> ratings, ArticleGenderType gender, String brandName) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.ratings = ratings;
        this.gender = gender;
        this.brandName = brandName;
    }
}
