package com.ftn.sbnz.service.controllers.dtos;

import java.sql.Date;

import com.ftn.sbnz.model.users.Injury;

public class ConcreteInjuryDTO {
    private Date executionTime;
    private String injury;
    public Date getExecutionTime() {
        return executionTime;
    }
    public void setExecutionTime(Date executionTime) {
        this.executionTime = executionTime;
    }
    public String getInjury() {
        return injury;
    }
    public void setInjury(String injury) {
        this.injury = injury;
    }

    
    
}
