package com.HEI.app.employee;

import com.HEI.app.Category;
import com.HEI.app.calendar.Calendar;

import java.util.Date;

public final class Guard extends Employee {
    public Guard(String employeeId, String firstName, String lastName, Date birthdate, Date hiringDate, Date contratEndDate, double salary, Category category) {
        super(employeeId, firstName, lastName, birthdate, hiringDate, contratEndDate, salary, category);
    }

    @Override
    public float completedHours() {
        return 0;
    }
}
