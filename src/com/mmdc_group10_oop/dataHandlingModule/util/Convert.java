package com.mmdc_group10_oop.dataHandlingModule.util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class Convert {
    public static LocalDate DateToLocalDate(Date date) {
        //Check if date is null
        if (date == null) {
            return null;
        }

        // Convert Date to LocalDate
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static LocalDate MDYtoLocalDate(String date) {
        if (date == null) {
            return null;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        return LocalDate.parse(date, formatter);
    }

    public static LocalDate StringToLocalDate(String date) {
        if (date == null) {
            return null;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(date, formatter);
    }
    public static String LocalDateToMDY(LocalDate date) {
        if (date == null) {
            return null;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        return date.format(formatter);
    }


    public static LocalTime StringToLocalTime(String time) {
        if (time == null || time.isEmpty()) {
            return null;
        }

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm");
            return LocalTime.parse(time, formatter);
        } catch (DateTimeParseException e) {
            // Handle the parsing exception here
            return null;
        }
    }

    public static String doubleToCurrency(Double value) {
        if (value == null) {
            return null;
        }
        return String.format("₱%,.2f", value);
    }

    public static String doubleToString(Double value) {
        if (value == null) {
            return null;
        }
        return String.format("%,.2f", value);
    }
}
