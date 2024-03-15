package util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Locale;

/**
 * Utility class for converting between different data types and formats.
 * <p>
 * Available methods:
 * <ul>
 *     <li>{@link Convert#DateToLocalDate(Date)}</li>
 *     <li>{@link Convert#StringToLocalDate_yyyyMMdd(String)}</li>
 *     <li>{@link Convert#StringToLocalTime(String)}</li>
 *     <li>{@link Convert#doubleToString(Double)}</li>
 *     <li>{@link Convert#StringToDouble(String)}</li>
 *     <li>{@link Convert#roundToTwoDecimalPlaces(double)}</li>
 * </ul>
 */

@SuppressWarnings("unused")
public class Convert {
    /**
     * Converts a java.util.Date object to java.time.LocalDate.
     *
     * @param date the Date object to convert
     * @return the corresponding LocalDate object
     */
    public static LocalDate DateToLocalDate(Date date) {
        if (date == null) {
            return null;
        }
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * Converts a string in "yyyy-MM-dd" format to LocalDate.
     *
     * @param date the string representing the date
     * @return the corresponding LocalDate object
     */
    public static LocalDate StringToLocalDate_yyyyMMdd(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(date, formatter);
    }

    /**
     * Converts a string representing time to LocalTime.
     *
     * @param time the string representing the time
     * @return the corresponding LocalTime object
     */
    public static LocalTime StringToLocalTime(String time) {
        if (time == null || time.isEmpty()) {
            return null;
        }
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm");
            return LocalTime.parse(time, formatter);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    /**
     * Converts a Double value to a string with two decimal places.
     *
     * @param value the Double value to convert
     * @return the formatted string
     */
    public static String doubleToString(Double value) {
        if (value == null) {
            return null;
        }
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00", DecimalFormatSymbols.getInstance(Locale.US));
        return decimalFormat.format(value);
    }

    /**
     * Converts a string to a Double value.
     *
     * @param value the string to convert
     * @return the corresponding Double value
     */
    public static Double StringToDouble(String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        DecimalFormat format = new DecimalFormat("#,##0.00");
        try {
            return format.parse(value).doubleValue();
        } catch (ParseException | NumberFormatException e) {
            return Double.valueOf(value);
        }
    }

    /**
     * Converts a month value to a string with two digits.
     *
     * @param value the month value to convert
     * @return the formatted string
     */
    public static String MonthValueToString(int value) {
        if (value < 1 || value > 12) {
            return null;
        }
        return String.format("%02d", value);
    }

    /**
     * Rounds a double value to two decimal places.
     *
     * @param value the value to round
     * @return the rounded value
     */
    public static double roundToTwoDecimalPlaces(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
