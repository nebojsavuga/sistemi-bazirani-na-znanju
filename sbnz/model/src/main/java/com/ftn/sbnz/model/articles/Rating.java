package com.ftn.sbnz.model.articles;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.ftn.sbnz.model.users.User;
import org.hibernate.validator.constraints.Range;
import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;

@Role(Role.Type.EVENT)
@Timestamp("executionTime")
@Entity
public class Rating implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "articleId")
    private Article article;

    @Column
    private Date executionTime;

    @Column
    @Range(min = 1,max = 5)
    private int rating;

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



    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }


    @Override
    public String toString() {
        return "Rating [id=" + id + ", user=" + user + ", article=" + article + ", timestamp=" + executionTime + ", rating="
                + rating + "]";
    }

    public Rating() {
    }

    public Rating(Long id, User user, Article article, Date executionTime, int rating) {
        this.id = id;
        this.user = user;
        this.article = article;
        this.executionTime = executionTime;
        this.rating = rating;
    }
    public Rating(User user, Article article, int rating) {
        this.user = user;
        this.article = article;
        this.executionTime = new Date();
        this.rating = rating;
    }

    public Date getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Date executionTime) {
        this.executionTime = executionTime;
    }
}
