package com.HEI.app.calendar;

import com.HEI.app.Enum.DayType;
import lombok.Data;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Data
public class WorkCalendar {
private List<Day> days;
public WorkCalendar(int month, int year,int numWeeks){

    days=new ArrayList<>();
    Calendar calendar =Calendar.getInstance();
    calendar.set(year,month-1,1);
    int daysInMonth=calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    for(int i=1;i<=numWeeks*7;i++){
        int dayOfWeek=calendar.get(Calendar.DAY_OF_WEEK);
        days.add(new Day(dayOfWeek, calendar.getTime(),DayType.regular));
        calendar.add(Calendar.DAY_OF_MONTH,1);
    }
}
public  void addHoliday(float day){
    days.forEach(workDay -> {
        if(workDay.getDate().getDate()==day){
            workDay.setType(DayType.holiday);
        }
    });
}

}
