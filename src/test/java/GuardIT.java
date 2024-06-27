
import com.HEI.app.Category;
import com.HEI.app.Enum.ShiftType;
import com.HEI.app.Salary;
import com.HEI.app.calendar.WorkCalendar;
import com.HEI.app.employee.Guard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Date;

public class GuardIT {
    @Test
    void checkRakotoSalary(){
        WorkCalendar juneCalendar=new WorkCalendar(6,2024,6);


        Guard rakoto=new Guard("1","Rakoto","doe", Date.from(Instant.now()),
                Date.from(Instant.now()),Date.from(Instant.now()),2000,new Category("guard",70,new Salary(100000)));
        rakoto.addWorkedDay(juneCalendar);
        Assertions.assertEquals(600000.0,rakoto.calculateSalaries().getGrossSalary());
    }
    @Test
    void checkRabeSalary(){

        WorkCalendar juneCalendar=new WorkCalendar(6,2024,6);
        Guard rabe=new Guard("2","Rabe","rabe",Date.from(Instant.now()),
                Date.from(Instant.now()),Date.from(Instant.now()),2000,
                new Category("guard",98,new Salary(100000)));
        rabe.setShiftType(ShiftType.NIGHT);
        rabe.addWorkedDay(juneCalendar);


        Assertions.assertEquals(780000.0,rabe.calculateSalaries().getGrossSalary());

    }
    @Test
    void checkRakotoSalaryWithHoliday(){
        WorkCalendar juneCalendar=new WorkCalendar(6,2024,6);
        juneCalendar.addHoliday(17);
        juneCalendar.addHoliday(25);
         juneCalendar.addHoliday(26);

        Guard rakoto=new Guard("1","Rakoto","doe", Date.from(Instant.now()),
                Date.from(Instant.now()),Date.from(Instant.now()),2000,new Category("guard",70,new Salary(100000)));
        rakoto.addWorkedDay(juneCalendar);
        Assertions.assertEquals(621429,rakoto.calculateSalaries().getGrossSalary());

    }
    @Test
    void checkRabeSalaryWithHoliday(){
        WorkCalendar juneCalendar=new WorkCalendar(6,2024,6);
        juneCalendar.addHoliday(17);
        juneCalendar.addHoliday(25);
        juneCalendar.addHoliday(26);
        Guard rabe=new Guard("2","Rabe","rabe",Date.from(Instant.now()),
                Date.from(Instant.now()),Date.from(Instant.now()),2000,
                new Category("guard",98,new Salary(100000)));
        rabe.setShiftType(ShiftType.NIGHT);
        rabe.addWorkedDay(juneCalendar);
        Assertions.assertEquals(807857.0,rabe.calculateSalaries().getGrossSalary());

    }



}
