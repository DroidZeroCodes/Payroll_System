package com.mmdc_group10_oop.dataHandlingModule.util;

import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Convert {
    public static LocalDate DateToLocalDate(Date date) {

        // Convert Date to LocalDate
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static LocalDate MDYtoLocalDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        return LocalDate.parse(date, formatter);
    }

    public static String LocalDateToMDY(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        return date.format(formatter);
    }
}
