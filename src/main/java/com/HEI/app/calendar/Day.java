package com.HEI.app.calendar;

import com.HEI.app.Enum.DayType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
@AllArgsConstructor
@Data
public class Day {
    private String name;
    private LocalDate date;
    private DayType type;
}
