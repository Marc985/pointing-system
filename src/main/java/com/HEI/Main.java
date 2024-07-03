package com.HEI;

import com.HEI.app.Category;
import com.HEI.app.Enum.ShiftType;
import com.HEI.app.Salary;
import com.HEI.app.calendar.Day;
import com.HEI.app.calendar.WorkCalendar;
import com.HEI.app.employee.Guard;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        WorkCalendar juneCalendar=new WorkCalendar(LocalDate.of(2024,5,26),LocalDate.of(2024,7,6));
        //juneCalendar.addHoliday(25);
       // juneCalendar.addHoliday(27);

// create a new guard named john
        Guard rakoto=new Guard("1","john","doe", Date.from(Instant.now()),
                Date.from(Instant.now()),Date.from(Instant.now()),2000,new Category("guard",70,new Salary(100000)));
        rakoto.addWorkedDay(juneCalendar);
       // guard.setAbsence(10);
      //  guard.setWorkHour(10,10,12);
        System.out.println(rakoto.calculateSalaries());
        System.out.println(rakoto.completedHour());
        System.out.println(rakoto.overtimeHour(juneCalendar));




        //create a new guard named rabe
        Guard rabe=new Guard("2","Rabe","Koto",Date.from(Instant.now()),
                Date.from(Instant.now()),Date.from(Instant.now()),2000,
                new Category("guard",98,new Salary(100000)));
        rabe.setShiftType(ShiftType.NIGHT);
        rabe.addWorkedDay(juneCalendar);
        System.out.println(rabe.calculateSalaries());
        System.out.println(rabe.completedHour());
    }





}