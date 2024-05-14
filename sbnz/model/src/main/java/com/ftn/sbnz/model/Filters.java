package com.ftn.sbnz.model;

import java.util.HashSet;
import java.util.Set;

import com.ftn.sbnz.model.sport.Sport;
import com.ftn.sbnz.model.sport.SportFootballPlayer;
import com.ftn.sbnz.model.sport.SportFootballType;
import com.ftn.sbnz.model.sport.SportLevel;
import com.ftn.sbnz.model.sport.SportOrientiringType;
import com.ftn.sbnz.model.sport.SportTenisField;
import com.ftn.sbnz.model.sport.SportWeightliftingType;
import com.ftn.sbnz.model.users.Gender;

public class Filters {
    public Gender gender;
    public float height;
    public int age;
    public Set<Long> injuries = new HashSet<>();
    public SportLevel level;
    public Sport sport;
    public SportFootballPlayer typeOfFotballPlayer;
    public SportFootballType typeOfFootball;
    public SportOrientiringType typeOfRace;
    public SportTenisField typeOfField;
    public SportWeightliftingType typeOfWeightlifting;

    public Filters() {
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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

    public Set<Long> getInjuries() {
        return injuries;
    }

    public void setInjuries(Set<Long> injuries) {
        this.injuries = injuries;
    }

    public SportLevel getLevel() {
        return level;
    }

    public void setLevel(SportLevel level) {
        this.level = level;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public SportFootballPlayer getTypeOfFotballPlayer() {
        return typeOfFotballPlayer;
    }

    public void setTypeOfFotballPlayer(SportFootballPlayer typeOfFotballPlayer) {
        this.typeOfFotballPlayer = typeOfFotballPlayer;
    }

    public SportFootballType getTypeOfFootball() {
        return typeOfFootball;
    }

    public void setTypeOfFootball(SportFootballType typeOfFootball) {
        this.typeOfFootball = typeOfFootball;
    }

    public SportOrientiringType getTypeOfRace() {
        return typeOfRace;
    }

    public void setTypeOfRace(SportOrientiringType typeOfRace) {
        this.typeOfRace = typeOfRace;
    }

    public SportTenisField getTypeOfField() {
        return typeOfField;
    }

    public void setTypeOfField(SportTenisField typeOfField) {
        this.typeOfField = typeOfField;
    }

    public SportWeightliftingType getTypeOfWeightlifting() {
        return typeOfWeightlifting;
    }

    public void setTypeOfWeightlifting(SportWeightliftingType typeOfWeightlifting) {
        this.typeOfWeightlifting = typeOfWeightlifting;
    }

}
