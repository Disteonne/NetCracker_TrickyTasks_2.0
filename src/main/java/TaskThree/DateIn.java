package TaskThree;

public interface DateIn {
    boolean isLeapYear(int year);
    boolean isValidDate(int year,int month,int day);
    int getDayOfWeek(int year,int month,int day);
    String toString(int year,int month,int day);
    long CountDays(int year,int month,int day);
}
