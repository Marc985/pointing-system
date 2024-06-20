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
                Date.from(Instant.now()),Date.from(Instant.now()),2000,new Category("guard",8,new Salary(110000)));
        guard.workedDay(juneCalendar);
        guard.setAbsence(9);
        System.out.println(guard.completedHour());
    }
}