package com.ftn.sbnz.model.articles;

import java.io.Serializable;
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

import com.ftn.sbnz.model.events.Purchase;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Article implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @Column
    private float price;

    @OneToMany(mappedBy = "article")
    private Set<Rating> ratings = new HashSet<Rating>();
    
    @OneToMany(mappedBy = "article")
    private Set<Purchase> purchases = new HashSet<Purchase>();

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

    public void addRating(Rating rating) {
        this.ratings.add(rating);
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
    public String toString() {
        return "Article [id=" + id + ", name=" + name + ", price=" + price + ", ratings=" + ratings + ", gender="
                + gender + "]";
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

        return true;
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

    public String getSupper() {
        Class<?> superclass = this.getClass().getSuperclass();
        return (superclass != null && superclass != Object.class) ? superclass.getSimpleName() : null;
    }

    public String getClassName() {
        return this.getClass().getSimpleName();
    }

    public String getParentClassName() {
        Class<?> parentClass = this.getClass().getSuperclass();
        if (parentClass != null) {
            return parentClass.getSimpleName();
        } else {
            return "No superclass"; 
        }
    }

    public String getGrandParentClassName() {
        Class<?> grandParentClass = this.getClass().getSuperclass().getSuperclass();
        if (grandParentClass != null) {
            return grandParentClass.getSimpleName();
        } else {
            return "No superclass"; 
        }
    }
}
