package com.ftn.sbnz.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.hibernate.validator.constraints.Range;
import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;

import com.ftn.sbnz.model.users.User;

@Role(Role.Type.EVENT)
@Timestamp("executionTime")
@Entity
public class Code implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Range(min = 0, max = 100)
    @Column
    private float discountPercentage;

    @Range(min = 0, max = 10000)
    @Column
    private float discountPrice;

    @Column
    private boolean isUsed;

    @ManyToOne
    private User user;

    // 0 - for sport
    // 1 - for article
    // 2 - for favorite article
    @Range(min = 0, max = 2)
    @Column
    private int flag;

    @Column
    private String sport;

    @Column
    private Date executionTime;

    public Code(String name, @Range(min = 0, max = 100) float discountPercentage,
            @Range(min = 0, max = 10000) float discountPrice, boolean isUsed, User user,
            @Range(min = 0, max = 2) int flag, String sport) {
        this.name = name;
        this.discountPercentage = discountPercentage;
        this.discountPrice = discountPrice;
        this.isUsed = isUsed;
        this.user = user;
        this.flag = flag;
        this.sport = sport;
    }
    

    public Code() {
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
        Code other = (Code) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }



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

    public float getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(float discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public float getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(float discountPrice) {
        this.discountPrice = discountPrice;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean isUsed) {
        this.isUsed = isUsed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    

    public Date getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Date executionTime) {
        this.executionTime = executionTime;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }
}