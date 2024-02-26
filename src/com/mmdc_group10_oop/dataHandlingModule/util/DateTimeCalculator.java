package com.mmdc_group10_oop.dataHandlingModule.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTimeCalculator {
    public static int totalDays(LocalDateTime startDate, LocalDateTime endDate) {
        return endDate.getDayOfYear() - startDate.getDayOfYear();
    }

    public static int totalMonths(LocalDateTime startDate, LocalDateTime endDate) {
        return endDate.getMonthValue() - startDate.getMonthValue();
    }

    public static double totalHours(LocalDateTime startDateHours, LocalDateTime endDateHours) {
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

    public static LocalDate parseDate(Date date) {

        // Convert Date to LocalDate
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static String dateFormatter(LocalDateTime date) {
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public static LocalTime parseTime(String timeString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return LocalTime.parse(timeString, formatter);
    }

    public static void main(String[] args) {
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = start.plusMonths(3);

        System.out.println(start);
        System.out.println(end);

        LocalDateTime hourStart = LocalDateTime.now().minusHours(4);
        LocalDateTime hourEnd = hourStart.plusHours(24).plusMinutes(45);

        System.out.println(hourStart);
        System.out.println(hourEnd);

        System.out.println(totalHours(hourStart, hourEnd));
        System.out.println(totalDays(start, end));
        System.out.println(totalMonths(start, end));
    }
}
