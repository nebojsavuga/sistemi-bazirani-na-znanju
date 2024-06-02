package com.ftn.sbnz.model.events;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;

import com.ftn.sbnz.model.articles.Article;
import com.ftn.sbnz.model.users.User;

@Role(Role.Type.EVENT)
@Timestamp("executionTime")
@Entity
public class Purchase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Article article;

    @Column
    private boolean isProcessedForSportCode;

    @Column
    private boolean isProcessedForFavoriteCode;

    @Column
    private Date executionTime;

    @Column
    private float price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        Purchase other = (Purchase) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    public Purchase(Long id, User user, Article article, float price) {
        this.id = id;
        this.user = user;
        this.article = article;
        this.price = price;
        this.executionTime = Date.from(Instant.now());
        this.isProcessedForSportCode = false;
        this.isProcessedForFavoriteCode = false;
    }

    public Purchase(Long id, User user, Article article, float price, Date executionTime) {
        this.id = id;
        this.user = user;
        this.article = article;
        this.price = price;
        this.executionTime = executionTime;
        this.isProcessedForSportCode = false;
        this.isProcessedForFavoriteCode = false;
    }

    public Purchase(User user, Article article, float price) {
        this.user = user;
        this.article = article;
        this.price = price;
        this.executionTime = new Date();
        this.isProcessedForSportCode = false;
        this.isProcessedForFavoriteCode = false;
    }

    public Purchase() {
    }

    public Date getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Date executionTime) {
        this.executionTime = executionTime;
    }

    public boolean isProcessedForSportCode() {
        return isProcessedForSportCode;
    }

    public void setProcessedForSportCode(boolean isProcessedForSportCode) {
        this.isProcessedForSportCode = isProcessedForSportCode;
    }

    public boolean isProcessedForFavoriteCode() {
        return isProcessedForFavoriteCode;
    }

    public void setProcessedForFavoriteCode(boolean isProcessedForFavoriteCode) {
        this.isProcessedForFavoriteCode = isProcessedForFavoriteCode;
    }

}
