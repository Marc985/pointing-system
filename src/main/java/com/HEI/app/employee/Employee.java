package com.HEI.app.employee;

import com.HEI.app.Category;
import com.HEI.app.calendar.WorkCalendar;
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

    public void amountToBePayed(){
        var oneDay=24;
        var oneWeek=7;
        double salaryPerDay=category.getNormalSalaryPerWeek().getNetSalary()/(oneDay*oneWeek);
        //return completedHours()*salaryPerDay;
    }

}
