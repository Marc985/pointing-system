package com.HEI.app.employee;

import com.HEI.app.Category;
import com.HEI.app.calendar.Day;
import com.HEI.app.calendar.WorkCalendar;
import lombok.AllArgsConstructor;
import lombok.Data;


import java.util.Date;
import java.util.List;

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




    public abstract int normalWorkDays();
    public abstract List<Day> workDay(WorkCalendar workCalendar);

}
