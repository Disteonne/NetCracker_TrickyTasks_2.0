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
        int result = 0;
        if (isValidDate(year, month, day) == true) {
            int[] offsetOfTheCentury = {0, 6, 4, 2};
            int[] offsetOfMonths = {0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5};
            int theCentury = year - year % 100;
            //String[] dayOfWeeks={ "SUN", "MON", "TUS", "WED", "THU", "FRI", "SAT"};
            int[] dayOfWeeksInt = {0, 1, 2, 3, 4, 5, 6};
            int offsetOfYears = (year % 100 + (year % 100) / 4) % 7-1;
            if (isLeapYear(year) == true && (month == 1 || month == 2)) {
                offsetOfYears -= 1;
                if (theCentury % 400 == 0) {
                    result = (offsetOfTheCentury[1] + offsetOfYears + offsetOfMonths[month - 1] + day % 7) % 7;
                }
                if (theCentury % 400 == 100) {
                    result = (offsetOfTheCentury[2] + offsetOfYears + offsetOfMonths[month - 1] + day % 7) % 7;
                }
                if (theCentury % 400 == 300) {
                    result = (offsetOfTheCentury[0] + offsetOfYears + offsetOfMonths[month - 1] + day % 7) % 7;
                }
                if (theCentury % 400 == 200) {
                    result = (offsetOfTheCentury[3] + offsetOfYears + offsetOfMonths[month - 1] + day % 7) % 7;
                }
            } else {
                if (theCentury % 400 == 0) {
                    result = (offsetOfTheCentury[1] + offsetOfYears + offsetOfMonths[month - 1] + day % 7) % 7;
                }
                if (theCentury % 400 == 100) {
                    result = (offsetOfTheCentury[2] + offsetOfYears + offsetOfMonths[month - 1] + day % 7) % 7;
                }
                if (theCentury % 400 == 300) {
                    result = (offsetOfTheCentury[0] + offsetOfYears + offsetOfMonths[month - 1] + day % 7) % 7;
                }
                if (theCentury % 400 == 200) {
                    result = (offsetOfTheCentury[3] + offsetOfYears + offsetOfMonths[month - 1] + day % 7) % 7;
                }
            }
        } else {
            throw new NoSuchElementException("Введена некорректная дата");
        }
        return result;
    }

    @Override
    public String toString(int year, int month, int day) {
        String result="";
        if(isValidDate(year,month,day)){
            switch (getDayOfWeek(year,month,day)){
                case 0:
                    result+="Monday "+day+"th ";
                    break;
                case 1:
                    result+="Tuesday "+day+"th ";
                    break;
                case 2:
                    result+="Wednesday "+day+"th ";
                    break;
                case 3:
                    result+="Thursday "+day+"th ";
                    break;
                case 4:
                    result+="Friday "+day+"th ";
                    break;
                case 5:
                    result+="Saturday "+day+"th ";
                    break;
                case 6:
                    result+="Sunday "+day+"th ";
                    break;
            }

            switch (month){
                case 1:
                    result+="January "+year;
                    break;
                case 2:
                    result+="February "+year;
                    break;
                case 3:
                    result+="March "+year;
                    break;
                case 4:
                    result+="April "+year;
                    break;
                case 5:
                    result+="May "+year;
                    break;
                case 6:
                    result+="June "+year;
                    break;
                case 7:
                    result+="July "+year;
                    break;
                case 8:
                    result+="August "+year;
                    break;
                case 9:
                    result+="September "+year;
                    break;
                case 10:
                    result+="October "+year;
                    break;
                case 11:
                    result+="November "+year;
                    break;
                case 12:
                    result+="December "+year;
                    break;
            }
            return result;
        }else
            throw new NoSuchElementException();
    }

    @Override
    public long CountDays(int year, int month, int day) {
        if (isValidDate(year,month,day)) {
            long res = 0;
            long countDayResult = 0;
            if (year < 1970) {
                int count_leap = 0;
                int tmp = year - 1;
                while (tmp < 1970) {
                    if (isLeapYear(year)) {
                        count_leap++;
                    }
                    tmp++;
                }
                countDayResult = count_leap * 366 + (1970 - year - count_leap) * 365; //кол-во дней(только года)
                long countDay = 0;
                int count_tmp = 0;
                while (count_tmp < month) {
                    countDay += getDayMonthNotLeap(year, month - count_tmp);
                    count_tmp++;
                }
                countDayResult -= countDay;
                // long dev = getDayMonthNotLeap(year, month) - day;
                countDayResult += getDayMonthNotLeap(year, month) - day;
                res = countDayResult + System.currentTimeMillis() / 1000 / 60 / 60 / 24 + 1;
            } else {
                int temp = year - 1970;
                int count_leap = 0;
                int tmp = 0;
                while (tmp < temp) {
                    if (isLeapYear(year - tmp)) {
                        count_leap++;
                    }
                    tmp++;
                }
                countDayResult = count_leap * 366 + (-1970 + year - count_leap) * 365;
                int countDay = 0;
                int count_tmp = 0;
                while (count_tmp < month) {
                    countDay += getDayMonthNotLeap(year, month - count_tmp);
                    count_tmp++;
                }
                countDayResult += countDay;
                long dev = getDayMonthNotLeap(year, month) - day;
                countDayResult -= dev;
                res = System.currentTimeMillis() / 1000 / 60 / 60 / 24 - countDayResult + 1;

            /*
            long time = System.currentTimeMillis();
            long seconds = System.currentTimeMillis() / 1000;
            //long second = seconds%60;
            long minute = seconds / 60;
            long hour = minute / 60;
            long days = (int) hour / 24;

            return time;
        }

             */
            }
            return res;
        }
        else
            throw new IllegalStateException();
    }

    public long getDayMonthNotLeap(int year,int month){

        if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
            return 31;
        }
        else if(month==2){
            return isLeapYear(year)? 29:28;
        }
        else
            return 30;
    }
}
