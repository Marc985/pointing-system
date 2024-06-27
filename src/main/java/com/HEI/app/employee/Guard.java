package com.HEI.app.employee;

import com.HEI.app.Category;
import com.HEI.app.Enum.DayType;
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
   private int nightHour;
   private int dayHour;


    public Guard(String employeeId, String firstName, String lastName, Date birthdate, Date hiringDate, Date contratEndDate, double salary, Category category) {
        super(employeeId, firstName, lastName, birthdate, hiringDate, contratEndDate, salary, category);
        presenceDays=new ArrayList<>();
        shiftType=ShiftType.DAY;
        dayHour=0;
        nightHour=0;


    }
    public ShiftType getShiftType(){
        return shiftType;
    }
    public void setShiftType(ShiftType shiftType){
        this.shiftType=shiftType;
    }

    public void addWorkedDay(WorkCalendar workCalendar){
        for(Day day:workCalendar.getDays()){

            presenceDays.add(day);
           // day.setCompletedHours(normalWorkDays());
            if(shiftType.equals(ShiftType.DAY)){
                dayHour+=normalWorkDays();
            }
            else if(shiftType.equals(ShiftType.NIGHT)){
                nightHour+=normalWorkDays();
            }

        }
    }
    public Salary calculateSalaries(){
        double normalRate = amountOfSalaryPerHour().getGrossSalary();
        double totalSalary = 0.0;

        for (Day day : presenceDays) {
            double dailySalary = normalRate * normalWorkDays();
            if (shiftType.equals(ShiftType.NIGHT)) {
                dailySalary += dailySalary * 0.3;
            }
           /* if (day.isWeekend()) {
                dailySalary += dailySalary * 0.4;
            }*/
            if (day.isHoliday()) {
                dailySalary += dailySalary * 0.5;
            }
            totalSalary += dailySalary;
        }

        return new Salary(Math.round(totalSalary));
    }


    public List<Day> getPresenceDays(){
        return presenceDays;
    }

    public float completedHour(){
        return nightHour+dayHour;
    }

    public void setAbsence(int dayOfMonth){
        presenceDays.removeIf(day -> day.getDate().getDate()==dayOfMonth);
    }
    public void setWorkHour(int nightHour,int dayHour,int weekDay){
      for(Day presence:presenceDays){

          if(presence.getDate().getDate()==weekDay){
              presence.setDayHour(dayHour);
              presence.setNightHour(nightHour);
              this.dayHour+=dayHour;
              this.nightHour+=nightHour;

          }
      }
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
private double calculateIncreasedHourPercentage(double normalSalaryPerHour){

    for(Day day:presenceDays){
        if(shiftType.equals(ShiftType.NIGHT)){
            normalSalaryPerHour*= 0.3F;
        }
        if(day.isWeekend()){
            normalSalaryPerHour*=0.4F;
        }
        if(day.isHoliday())
            normalSalaryPerHour*= 0.5F;


    }
    return normalSalaryPerHour;
}



}
