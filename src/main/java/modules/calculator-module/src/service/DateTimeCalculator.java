package service;

import java.time.LocalDate;
import java.time.LocalTime;

public class DateTimeCalculator {
    public static int totalDays(LocalDate startDate, LocalDate endDate) {
        return endDate.getDayOfYear() - startDate.getDayOfYear();
    }

    public static int totalMonths(LocalDate startDate, LocalDate endDate) {
        return endDate.getMonthValue() - startDate.getMonthValue();
    }

    public static LocalTime totalHours(LocalTime startDateHours, LocalTime endDateHours) {
        // Calculate the difference in hours
        double hoursDifference = endDateHours.getHour() - startDateHours.getHour();

        if (hoursDifference < 0) {
            hoursDifference += 24;
        }

        // Calculate the difference in  minutes
        double minutesDifference = endDateHours.getMinute() - startDateHours.getMinute();

        System.out.println(minutesDifference);
        // If minutesDifference is negative, adjust hoursDifference accordingly
        if (minutesDifference < 0) {
            hoursDifference--;
            minutesDifference += 60;
        }

        // Return the total hours including minutes
        return LocalTime.of((int) hoursDifference, (int) minutesDifference);
    }

    public static void main(String[] args) {
        LocalDate start = LocalDate.now();
        LocalDate end = start.plusMonths(3);

        System.out.println(start);
        System.out.println(end);

        LocalTime hourStart = LocalTime.now();
        LocalTime hourEnd = hourStart.plusHours(2).plusMinutes(0);

        System.out.println(hourStart);
        System.out.println(hourEnd);

        System.out.println(totalHours(hourStart, hourEnd));
        System.out.println(totalDays(start, end));
        System.out.println(totalMonths(start, end));
    }
}
