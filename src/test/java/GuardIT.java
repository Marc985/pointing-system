
import com.HEI.app.Category;
import com.HEI.app.Enum.ShiftType;
import com.HEI.app.Salary;
import com.HEI.app.calendar.WorkCalendar;
import com.HEI.app.employee.Guard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

public class GuardIT {
    @Test
    void checkRakotoJuneSalary(){
        WorkCalendar juneCalendar=new WorkCalendar(LocalDate.of(2024,5,26),LocalDate.of(2024,7,6));


        Guard rakoto=new Guard("1","Rakoto","doe", Date.from(Instant.now()),
                Date.from(Instant.now()),Date.from(Instant.now()),2000,new Category("guard",70,new Salary(100000)));
        rakoto.addWorkedDay(juneCalendar);
        Assertions.assertEquals(600000.0,rakoto.calculateSalaries().getGrossSalary());
    }
    @Test
    void checkRabeJuneSalary(){

        WorkCalendar juneCalendar=new WorkCalendar(LocalDate.of(2024,5,26),LocalDate.of(2024,7,6));
        Guard rabe=new Guard("2","Rabe","rabe",Date.from(Instant.now()),
                Date.from(Instant.now()),Date.from(Instant.now()),2000,
                new Category("guard",98,new Salary(100000)));
        rabe.setShiftType(ShiftType.NIGHT);
        rabe.addWorkedDay(juneCalendar);


        Assertions.assertEquals(780000.0,rabe.calculateSalaries().getGrossSalary());

    }
    @Test
    void checkRakotoJuneSalaryWithHoliday(){
        WorkCalendar juneCalendar=new WorkCalendar(LocalDate.of(2024,5,26),LocalDate.of(2024,7,6));
        juneCalendar.addHoliday(17,6);
        juneCalendar.addHoliday(25,6);
         juneCalendar.addHoliday(26,6);

        Guard rakoto=new Guard("1","Rakoto","doe", Date.from(Instant.now()),
                Date.from(Instant.now()),Date.from(Instant.now()),2000,new Category("guard",70,new Salary(100000)));
        rakoto.addWorkedDay(juneCalendar);
        Assertions.assertEquals(621429,rakoto.calculateSalaries().getGrossSalary());

    }
    @Test
    void checkRabeJuneSalaryWithHoliday(){
        WorkCalendar juneCalendar=new WorkCalendar(LocalDate.of(2024,5,26),LocalDate.of(2024,7,6));
        juneCalendar.addHoliday(17,6);
        juneCalendar.addHoliday(25,6);
        juneCalendar.addHoliday(26,6);
        Guard rabe=new Guard("2","Rabe","rabe",Date.from(Instant.now()),
                Date.from(Instant.now()),Date.from(Instant.now()),2000,
                new Category("guard",98,new Salary(100000)));
        rabe.setShiftType(ShiftType.NIGHT);
        rabe.addWorkedDay(juneCalendar);
        Assertions.assertEquals(807857.0,rabe.calculateSalaries().getGrossSalary());

    }

    @Test
    void rakoto(){
        WorkCalendar juneCalendar=new WorkCalendar(LocalDate.of(2024,5,26),LocalDate.of(2024,7,6));
        juneCalendar.addHoliday(26,6);
        Guard rakoto=new Guard("2","rakoto","rakoto",Date.from(Instant.now()),
                Date.from(Instant.now()),Date.from(Instant.now()),2000,
                new Category("guard",98,new Salary(100000)));
        rakoto.addWorkedDay(juneCalendar);
        //Assertions.assertEquals(807857.0,rabe.calculateSalaries().getGrossSalary());
        System.out.println(rakoto.calculateSalaries());
        System.out.println(juneCalendar.getDays().size());
    }
    @Test
    void rabe(){
        WorkCalendar juneCalendar=new WorkCalendar(LocalDate.of(2024,5,26),LocalDate.of(2024,7,6));
        juneCalendar.addHoliday(26,6);
        Guard rakoto=new Guard("2","rakoto","rakoto",Date.from(Instant.now()),
                Date.from(Instant.now()),Date.from(Instant.now()),2000,
                new Category("guard",98,new Salary(100000)));
        rakoto.setShiftType(ShiftType.NIGHT);

        rakoto.addWorkedDay(juneCalendar);
        //Assertions.assertEquals(807857.0,rabe.calculateSalaries().getGrossSalary());
        System.out.println(rakoto.calculateSalaries());
        System.out.println(juneCalendar.getDays());

    }



}
