package com.mmdc_group10_oop.dataHandlingModule.util;

import java.time.LocalDate;
import java.time.LocalTime;

public class DateTimeCalculator {
    public static int totalDays(LocalDate startDate, LocalDate endDate) {
        return endDate.getDayOfYear() - startDate.getDayOfYear();
    }

    public static int totalMonths(LocalDate startDate, LocalDate endDate) {
        return endDate.getMonthValue() - startDate.getMonthValue();
    }

    public static double totalHours(LocalTime startDateHours, LocalTime endDateHours) {
        // Calculate the difference in hours
        double hoursDifference = endDateHours.getHour() - startDateHours.getHour();

        if (hoursDifference < 0) {
            hoursDifference += 24;
        }

        // Calculate the difference in  minutes
        double minutesDifference = endDateHours.getMinute() - startDateHours.getMinute();

        // If minutesDifference is negative, adjust hoursDifference accordingly
        if (minutesDifference < 0) {
            hoursDifference--;
            minutesDifference += 60;
        }

        minutesDifference /= 60;

        // Return the total hours including minutes
        return hoursDifference + minutesDifference;
    }

    public static void main(String[] args) {
        LocalDate start = LocalDate.now();
        LocalDate end = start.plusMonths(3);

        System.out.println(start);
        System.out.println(end);

        LocalTime hourStart = LocalTime.now().minusHours(4);
        LocalTime hourEnd = hourStart.plusHours(24).plusMinutes(45);

        System.out.println(hourStart);
        System.out.println(hourEnd);

        System.out.println(totalHours(hourStart, hourEnd));
        System.out.println(totalDays(start, end));
        System.out.println(totalMonths(start, end));
    }
}
