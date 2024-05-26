package com.ftn.sbnz.service.controllers.dtos;

import java.util.List;

import com.ftn.sbnz.model.users.Gender;

public class UserDTO {
    public Long id;
    public float height;
    public int age;
    public Gender gender;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public float getHeight() {
        return height;
    }
    public void setHeight(float height) {
        this.height = height;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public UserDTO() {
    }
}
