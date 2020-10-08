package TaskThree;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class DateInImaplTest {

    @Test
    public void isLeapYear() {
        DateIn dateIn=new DateInImpl();
        assertEquals(false,dateIn.isLeapYear(2021));
    }

    @Test
    public void isValidDate() {
        DateIn dateIn=new DateInImpl();
        assertEquals(true,dateIn.isValidDate(1999,2,28));
    }
    @Test
    public void getDayOfWeek(){
        DateIn dateIn=new DateInImpl();
        //assertEquals(0,dateIn.getDayOfWeek(1986,6,23));   //DONE
        //assertEquals(3,dateIn.getDayOfWeek(1999,1,14));   //DONE
        //assertEquals(5,dateIn.getDayOfWeek(2020,2,29));   //DONE
        //assertEquals(6,dateIn.getDayOfWeek(2022,8,21));   //DONE
        //assertEquals(6,dateIn.getDayOfWeek(2141,4,30));   //DONE
        //assertEquals(2,dateIn.getDayOfWeek(2320,11,3));   //DONE
    }
    @Test(expected = NoSuchElementException.class)
    public void getDayOfWeekException(){
        DateIn dateIn=new DateInImpl();
        dateIn.getDayOfWeek(-18,10,22);
    }
    @Test
    public void testToString(){
        DateIn dateIn=new DateInImpl();
        assertEquals("Tuesday 25th February 2020",dateIn.toString(2020,2,25));
    }
    @Test
    public void getCountDays(){
        DateIn dateIn=new DateInImpl();
        //long res=dateIn.CountDays(2019,10,8);
        assertEquals(0,dateIn.CountDays(1999,1,14));
    }
}