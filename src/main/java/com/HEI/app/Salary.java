package com.HEI.app;

import lombok.Data;

@Data
public class Salary {
    private double grossSalary;
    private double netSalary;
    public Salary(double grossSalary){
        float netSalaryPercentage= 0.8F;
        this.grossSalary=grossSalary;
        this.netSalary=grossSalary*netSalaryPercentage;
    }

    public static void main(String[] args) {
        Salary salary=new Salary(100);

        System.out.println(salary.getNetSalary());
    }

}
