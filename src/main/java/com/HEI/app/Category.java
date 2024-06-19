package com.HEI.app;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Category {
    private String name;
    private float workHour;
    private Salary salaryPerWeek;
    public Category(String name,float workHour,Salary salaryPerWeek){
        this.name=name;
        this.workHour=workHour;
        this.salaryPerWeek=salaryPerWeek;
    }

}
