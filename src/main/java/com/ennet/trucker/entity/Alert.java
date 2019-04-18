package com.ennet.trucker.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Alert {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String vin;
    private String rule;
    private Priority priorityType;


    public Alert(){
    }

    public Alert(String vin, String rule, Priority priorityType) {
        this.id = UUID.randomUUID().toString();
        this.vin = vin;
        this.rule = rule;
        this.priorityType = priorityType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public Priority getPriorityType() {
        return priorityType;
    }

    public void setPriorityType(Priority priorityType) {
        this.priorityType = priorityType;
    }
}
