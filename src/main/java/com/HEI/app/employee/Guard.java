package com.HEI.app.employee;

import com.HEI.app.Category;
import com.HEI.app.calendar.Day;
import com.HEI.app.calendar.WorkCalendar;
import lombok.Data;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public final class Guard extends Employee {
    List<Day> presenceDays;
    public Guard(String employeeId, String firstName, String lastName, Date birthdate, Date hiringDate, Date contratEndDate, double salary, Category category) {
        super(employeeId, firstName, lastName, birthdate, hiringDate, contratEndDate, salary, category);
        presenceDays=new ArrayList<>();
    }
    public void workedDay(WorkCalendar workCalendar){
        presenceDays.addAll(workCalendar.getDays().stream().filter(
                day -> !day.isWeekend() && !day.isHoliday()
        ).toList());

    }
    public List<Day> getPresenceDays(){
        return presenceDays;
    }

    public float completedHour(){
        return getCategory().getNormalWorkHour()*presenceDays.size();
    }
    public void setAbsence(int dayOfMonth){
        presenceDays.removeIf(day -> day.getDate().getDate()==dayOfMonth);
    }


}
