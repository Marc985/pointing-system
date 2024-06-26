package com.HEI.app.calendar;

import com.HEI.app.Enum.DayType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Data
public class Day {
    private String name;
    private Date date;
    private DayType type;
    private int dayHour;
    private int nightHour;
    private int completedHours;
    public Day(int day,Date date,DayType type){
            this.name=dayOfWeek(day);
            this.date=date;
            this.type=type;
    }
    private String dayOfWeek(int day){
        String[] days={"dimanche","lundi","mardi","mercredi","jeudi","vendredi","samedi"};
        return days[day-1];
    }
    public boolean isWeekend(){
        return name.equals("dimanche");
    }
    public boolean isHoliday(){
        return type.equals(DayType.holiday);
    }




}
