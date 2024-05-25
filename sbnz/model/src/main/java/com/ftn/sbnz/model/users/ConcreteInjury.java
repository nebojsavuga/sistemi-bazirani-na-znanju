package com.ftn.sbnz.model.users;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;

@Role(Role.Type.EVENT)
@Timestamp("executionTime")
@Entity
@Table(name = "ConcreteInjury")
public class ConcreteInjury implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @Column
    private Date executionTime;

    @ManyToOne
    @JoinColumn(name = "injuryId")
    private Injury injury;
    
    public ConcreteInjury(Long id, User user, Date timestamp, Injury injury) {
        this.id = id;
        this.user = user;
        this.executionTime = timestamp;
        this.injury = injury;
    }

    public ConcreteInjury() {
    }

    @Override
    public String toString() {
        return "ConcreteInjury [id=" + id + ", user=" + user + ", timestamp=" + executionTime + ", injury=" + injury + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConcreteInjury that = (ConcreteInjury) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

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

    public Date getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Date executionTime) {
        this.executionTime = executionTime;
    }

    public Injury getInjury() {
        return injury;
    }

    public void setInjury(Injury injury) {
        this.injury = injury;
    }

    
}
