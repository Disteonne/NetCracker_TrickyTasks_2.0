package TaskThree;

import org.junit.Test;

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
        //assertEquals(1,dateIn.getDayOfWeek(1986,6,23));
        int res=dateIn.getDayOfWeek(2020,2,29);
        //assertEquals(4,dateIn.getDayOfWeek(1999,1,14));
        assertEquals(6,dateIn.getDayOfWeek(2020,2,29));
    }
}