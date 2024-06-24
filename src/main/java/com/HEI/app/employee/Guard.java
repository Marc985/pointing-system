package com.HEI.app.employee;

import com.HEI.app.Category;
import com.HEI.app.Enum.ShiftType;
import com.HEI.app.Salary;
import com.HEI.app.calendar.Day;
import com.HEI.app.calendar.WorkCalendar;
import lombok.Data;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public final class Guard extends Employee {
   private final List<Day> presenceDays;
   @Setter
   private ShiftType shiftType;
    public Guard(String employeeId, String firstName, String lastName, Date birthdate, Date hiringDate, Date contratEndDate, double salary, Category category) {
        super(employeeId, firstName, lastName, birthdate, hiringDate, contratEndDate, salary, category);
        presenceDays=new ArrayList<>();
        shiftType=ShiftType.DAY;
    }
    public ShiftType getShiftType(){
        return shiftType;
    }

    public void addWorkedDay(WorkCalendar workCalendar){
        presenceDays.addAll(workCalendar.getDays());
        presenceDays.forEach(presence->{
            presence.setCompletedHours(normalWorkDays());
        });

    }
    public Salary calculateSalaries(){
        List<Day> presence=presenceDays;

        double amount=amountOfSalaryPerHour().getGrossSalary()*completedHour();
        return new Salary(amount);
    }


    public List<Day> getPresenceDays(){
        return presenceDays;
    }

    public float completedHour(){
        return presenceDays.stream().mapToInt(Day::getCompletedHours).sum();
    }

    public void setAbsence(int dayOfMonth){
        presenceDays.removeIf(day -> day.getDate().getDate()==dayOfMonth);
    }
    public void setWorkHour(int hour,int weekDay){
        presenceDays.forEach(presence->{
            if(presence.getDate().getDate()==weekDay){
                presence.setCompletedHours(hour);
            }
        });
    }


   public Salary amountOfSalaryPerHour(){


        double amount=getCategory().getNormalSalaryPerWeek().getGrossSalary()/getCategory().getNormalWorkHourPerWeek();

        return new Salary(amount);
   }

    @Override
    public int normalWorkDays() {
        int normalDayWorkPerWeek=7;
        return getCategory().getNormalWorkHourPerWeek()/normalDayWorkPerWeek;
    }

    @Override
    public List<Day> workDay(WorkCalendar workCalendar) {

        return workCalendar.getDays();
    }
public float overtimeHour(WorkCalendar workCalendar){
        int normalWorkDay=workDay(workCalendar).size()*normalWorkDays();
        if(completedHour()>normalWorkDay){
            return completedHour()-normalWorkDay;
        }
        return 0;

}

}
