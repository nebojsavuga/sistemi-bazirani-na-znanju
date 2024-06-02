package com.ftn.sbnz.service.controllers.dtos;

import java.util.Date;

public class CodeDTO {
    public Long id;
    public float discountPercentage;
    public float discountPrice;
    public boolean isUsed;
    public String name;
    public String sport;
    public Long userId;
    public int flag;
    public Date executionTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int isFlag() {
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

    public CodeDTO(Long id, float discountPercentage, float discountPrice, boolean isUsed, String name, String sport,
            Long userId, int flag, Date executionTime) {
        this.id = id;
        this.discountPercentage = discountPercentage;
        this.discountPrice = discountPrice;
        this.isUsed = isUsed;
        this.name = name;
        this.sport = sport;
        this.userId = userId;
        this.flag = flag;
        this.executionTime = executionTime;
    }

}
