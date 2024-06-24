package com.HEI;

import com.HEI.app.Category;
import com.HEI.app.Salary;
import com.HEI.app.calendar.Day;
import com.HEI.app.calendar.WorkCalendar;
import com.HEI.app.employee.Guard;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        WorkCalendar juneCalendar=new WorkCalendar(6,2024);
        juneCalendar.addHoliday(25);
        juneCalendar.addHoliday(27);

        Guard guard=new Guard("1","john","doe", Date.from(Instant.now()),
                Date.from(Instant.now()),Date.from(Instant.now()),2000,new Category("guard",56,new Salary(110000)));
        guard.addWorkedDay(juneCalendar);
       // guard.setAbsence(10);
        guard.setWorkHour(12,18);
        System.out.println(guard.calculateSalaries());
        System.out.println(guard.completedHour());
        System.out.println(guard.overtimeHour(juneCalendar));
    }
}