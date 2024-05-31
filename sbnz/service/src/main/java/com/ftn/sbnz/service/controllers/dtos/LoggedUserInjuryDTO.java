package com.ftn.sbnz.service.controllers.dtos;

import java.util.Date;



public class LoggedUserInjuryDTO {
    private Long id;
    private Date executionTime;
    private String injury;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
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
