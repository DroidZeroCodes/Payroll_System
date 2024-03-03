package service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class DateTimeCalculator {
    private static final LocalTime REGULAR_HOURS_START = LocalTime.of(8, 0);
    private static final LocalTime END_OF_REGULAR_HOURS = LocalTime.of(17, 0);
    private static final LocalTime GRACE_PERIOD = LocalTime.of(8, 10);


    public static int totalDays(LocalDate startDate, LocalDate endDate) {
        return endDate.getDayOfYear() - startDate.getDayOfYear();
    }

    public static int totalMonths(LocalDate startDate, LocalDate endDate) {
        return endDate.getMonthValue() - startDate.getMonthValue();
    }

    public static LocalTime calculateRegularHoursWorked(LocalTime timeIn, LocalTime timeOut) {
        Duration duration = Duration.between(timeIn, timeOut);
        if (duration.isNegative()) {
            duration = duration.plus(Duration.ofDays(1));
        }
        return LocalTime.of(duration.toHoursPart(), duration.toMinutesPart());
    }
    public static LocalTime calculateOvertimeHours(LocalTime timeIn, LocalTime timeOut) {
      LocalTime totalHours = calculateRegularHoursWorked(timeIn, timeOut);
      return totalHours.isAfter(END_OF_REGULAR_HOURS) ? totalHours.minusHours(END_OF_REGULAR_HOURS.getHour()) : LocalTime.of(0,0);
    }

    public static double calculateHours(LocalTime hoursWorked) {
        int hours = hoursWorked.getHour();
        int minutes = hoursWorked.getMinute();
        return (double) hours + (double) minutes /60;
    }

    //Tests
    public static void main(String[] args) {
        LocalDate start = LocalDate.now();
        LocalDate end = start.plusMonths(3);

        System.out.println(start);
        System.out.println(end);

        LocalTime hourStart = LocalTime.now();
        LocalTime hourEnd = hourStart.plusHours(2).plusMinutes(30);

        System.out.println(hourStart);
        System.out.println(hourEnd);

        System.out.println(calculateRegularHoursWorked(hourStart, hourEnd));
        System.out.println(totalDays(start, end));
        System.out.println(totalMonths(start, end));
        System.out.println(calculateOvertimeHours(LocalTime.of(8, 0),LocalTime.of(17,30)));
    }
}
