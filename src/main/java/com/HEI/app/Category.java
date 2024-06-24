package com.HEI.app;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Category {
    private String name;
    private int normalWorkHourPerWeek;
    private Salary normalSalaryPerWeek;
    public Category(String name,float workHour,Salary salaryPerWeek){
        this.name=name;
        this.normalWorkHourPerWeek= (int) workHour;
        this.normalSalaryPerWeek=salaryPerWeek;
    }

}
