package TaskThree;

import java.util.NoSuchElementException;

public class DateInImpl implements DateIn {
    public DateInImpl() {
        super();
    }

    @Override
    public boolean isLeapYear(int year) {
        return (year % 100 == 0 && year % 400 == 0 || year % 4 == 0 && year % 100 != 0) ? true : false;
    }

    @Override
    public boolean isValidDate(int year, int month, int day) {
        boolean isTrue = false;
        if (year > 0 && isLeapYear(year) == true) { //високосный год
            if (month > 0 && month <= 12) {
                if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                    if (day > 0 && day <= 31) {
                        isTrue = true;
                    }
                } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                    if (day > 0 && day <= 30) {
                        isTrue = true;
                    }
                } else {
                    if (day > 0 && day <= 29)
                        isTrue = true;
                }
            }
        }
        if (year > 0 && isLeapYear(year) != true) {
            if (month > 0 && month <= 12) {
                if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                    if (day > 0 && day <= 31) {
                        isTrue = true;
                    }
                } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                    if (day > 0 && day <= 30) {
                        isTrue = true;
                    }
                } else {
                    if (day > 0 && day <= 28)
                        isTrue = true;
                }
            }
        }
        return isTrue;
    }

    @Override
    public int getDayOfWeek(int year, int month, int day) {
        int result=0;
        if (isValidDate(year, month, day) == true) {
            int[] offsetOfTheCentury={0,6,4,2};
            int[] offsetOfMonths={0,3,3,6,1,4,6,2,5,0,3,5};
            int theCentury=year-year%100;
            //String[] dayOfWeeks={ "SUN", "MON", "TUS", "WED", "THU", "FRI", "SAT"};
            int[] dayOfWeeksInt={0,1,2,3,4,5,6};
            int offsetOfYears= (year%100 + (year%100)/4)%7;
            if(isLeapYear(year)==true && (month==1 || month==2)){
                offsetOfYears-=1;
                if(theCentury%400==0){
                    result=(offsetOfTheCentury[1]+offsetOfYears+offsetOfMonths[month-1]+day%7)%7;
                }
                if(theCentury%400==100){
                    result=(offsetOfTheCentury[2]+offsetOfYears+offsetOfMonths[month-1]+day%7)%7;
                }
                if(theCentury%400==300){
                    result=(offsetOfTheCentury[0]+offsetOfYears+offsetOfMonths[month-1]+day%7)%7;
                }
                if(theCentury%400==200){
                    result=(offsetOfTheCentury[3]+offsetOfYears+offsetOfMonths[month-1]+day%7)%7;
                }
            }else {
                if(theCentury%400==0){
                    result=(offsetOfTheCentury[1]+offsetOfYears+offsetOfMonths[month-1]+day%7)%7;
                }
                if(theCentury%400==100){
                    result=(offsetOfTheCentury[2]+offsetOfYears+offsetOfMonths[month-1]+day%7)%7;
                }
                if(theCentury%400==300){
                    result=(offsetOfTheCentury[0]+offsetOfYears+offsetOfMonths[month-1]+day%7)%7;
                }
                if(theCentury%400==200){
                    result=(offsetOfTheCentury[3]+offsetOfYears+offsetOfMonths[month-1]+day%7)%7;
                }
            }
        }else {
            throw new NoSuchElementException("Введена некорректная дата");
        }
            /*
            int Y = 0;
            String yY = "";
            if (year >= 1901 && year <= 2000) {
                if (isLeapYear(year) == false) {
                    int Yv = year - 1;
                    //Находим ближ високосный
                    for (int i = 1; i < 5; i++) {
                        if (isLeapYear(Yv) == true) {
                            break;
                        }
                    }
                    yY += (50 -Yv/2 + year % 100-Yv)%7; //Смещение года
                }
            }
            int a, y, m, R;
            a = (14 - month) / 12;
            y = year - a;
            m = month + 12 * a - 2;
            R = 7000 + (day + y + y / 4 - y / 100 + y / 400 + (31 * m) / 12);
            return R % 7;
        }
        return 0;
             */
        return result;
    }

    @Override
    public String toString(int year, int month, int day) {
        return null;
    }

    @Override
    public int CountDays(int year, int month, int day) {
        return 0;
    }
}
