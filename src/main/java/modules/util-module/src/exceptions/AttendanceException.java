package exceptions;

import javax.swing.*;

public class AttendanceException extends Exception {
    public AttendanceException(String message, Throwable cause) {
        super(message, cause);
    }

    public static void throwError_ALREADY_CLOCKED_IN() throws AttendanceException {
        String errorMessage = "You Have Already Clocked In";
        JOptionPane.showMessageDialog(null, errorMessage, "Attendance Error", JOptionPane.ERROR_MESSAGE);
        logException(errorMessage, new Throwable());
        throw new AttendanceException(errorMessage, new Throwable());
    }

    public static void throwError_NOT_CLOCKEDIN() throws AttendanceException {
        String errorMessage = "You Have Not Clocked In. Please Clock In First";
        JOptionPane.showMessageDialog(null, errorMessage, "Attendance Error", JOptionPane.ERROR_MESSAGE);
        logException(errorMessage, new Throwable());
        throw new AttendanceException(errorMessage, new Throwable());
    }

    public static void throwError_ALREADY_CLOCKED_OUT() throws AttendanceException {
        String errorMessage = "You Have Already Clocked Out";
        JOptionPane.showMessageDialog(null, errorMessage, "Attendance Error", JOptionPane.ERROR_MESSAGE);
        logException(errorMessage, new Throwable());
        throw new AttendanceException(errorMessage, new Throwable());
    }

    public static void throwError_NO_RECORD_FOUND() throws AttendanceException {
        String errorMessage = "No Record Found";
        JOptionPane.showMessageDialog(null, errorMessage, "Attendance Error", JOptionPane.ERROR_MESSAGE);
        logException(errorMessage, new Throwable());
        throw new AttendanceException(errorMessage, new Throwable());
    }

    public static void throwError_INVALID_DATE() throws AttendanceException {
        String errorMessage = "Invalid Date";
        JOptionPane.showMessageDialog(null, errorMessage, "Attendance Error", JOptionPane.ERROR_MESSAGE);
        logException(errorMessage, new Throwable());
        throw new AttendanceException(errorMessage, new Throwable());
    }

    // Method to log the exception to console
    private static void logException(String message, Throwable cause) {
        System.err.println("Attendance Exception: " + message);
        if (cause != null) {
            System.err.println("Cause: " + cause.getMessage());
            for (StackTraceElement element : cause.getStackTrace()) {
                System.err.println(element);
            }
        }
    }
}