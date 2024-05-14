package com.ftn.sbnz.service.controllers.dtos;

import java.util.HashSet;
import java.util.Set;

import com.ftn.sbnz.model.sport.Sport;
import com.ftn.sbnz.model.sport.SportLevel;
import com.ftn.sbnz.model.users.Gender;

public class Filters {
    public Gender gender;
    public float height;
    public int age;
    public Set<Long> injuries = new HashSet<>();
    public SportLevel level;
    public Sport sport;
}
