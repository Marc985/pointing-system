package com.HEI.app;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Category {
    private String name;
    private float normalWorkHour;
    private Salary normalSalaryPerWeek;
    public Category(String name,float workHour,Salary salaryPerWeek){
        this.name=name;
        this.normalWorkHour=workHour;
        this.normalSalaryPerWeek=salaryPerWeek;
    }

}
