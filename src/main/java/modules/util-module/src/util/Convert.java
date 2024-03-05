package util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Locale;

public class Convert {
    public static LocalDate DateToLocalDate(Date date) {
        //Check if date is null
        if (date == null) {
            return null;
        }

        // Convert Date to LocalDate
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static LocalDate StringToLocalDate_MMMddYYYY(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
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

        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");

        // Format the double value using the DecimalFormat object
        return "₱" + decimalFormat.format(value);
    }

    public static Double CurrencyToDouble(String value) {
        if (value == null) {
            return null;
        }

        // Use NumberFormat to parse currency with appropriate Locale
        NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("en", "PH"));
        try {
            Number number = format.parse(value);
            return number.doubleValue();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


    public static String doubleToString(Double value) {
        if (value == null) {
            return null;
        }
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");

        // Format the double value using the DecimalFormat object
        return decimalFormat.format(value);
    }

    public static Double StringToDouble(String value) {
        if (value == null) {
            return null;
        }

        DecimalFormat format = new DecimalFormat("#0.##");
        try {
            return format.parse(value).doubleValue();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


    public static String MonthValueToString(int value) {
        if (value < 1 || value > 12) {
            return null;
        }
        return String.format("%02d", value);
    }

    public static double roundToTwoDecimalPlaces(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
