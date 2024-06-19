package com.HEI.app.employee;

import com.HEI.app.Category;
import com.HEI.app.calendar.Calendar;
import lombok.AllArgsConstructor;
import lombok.Data;


import java.util.Date;
@Data
@AllArgsConstructor
public abstract sealed class  Employee permits Guard{
    private String employeeId;
    private String firstName;
    private String lastName;
    private Date birthdate;
    private Date hiringDate;
    private Date contratEndDate;
    private double salary;
    private Category category;
    public abstract float completedHours();

    public double amountToBePayed(){
        var oneDay=24;
        var oneWeek=7;
        double salaryPerDay=category.getSalaryPerWeek().getNetSalary()/(oneDay*oneWeek);
        return completedHours()*salaryPerDay;
    }

}
