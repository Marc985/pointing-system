package com.HEI.app.calendar;

import com.HEI.app.Enum.DayType;
import lombok.Data;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Data
public class WorkCalendar {
private List<Day> days;
    public WorkCalendar(LocalDate startDate, LocalDate endDate) {
        days = new ArrayList<>();

        Date start = Date.from(startDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date end = Date.from(endDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(start);

        while (!calendar.getTime().after(end)) {
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            days.add(new Day(dayOfWeek, calendar.getTime(), DayType.regular));
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }
    }
public  void addHoliday(int day,int month){
    days.forEach(workDay -> {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(workDay.getDate());
        int workDayMonth = calendar.get(Calendar.MONTH);
        int workDayDay = calendar.get(Calendar.DAY_OF_MONTH);

        if (workDayDay == day && workDayMonth == month - 1) {
            workDay.setType(DayType.holiday);
        }
    });
}

}
