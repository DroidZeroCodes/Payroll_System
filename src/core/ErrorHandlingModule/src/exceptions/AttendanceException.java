package exceptions;

import javax.swing.*;

/**
 * An exception class for attendance-related errors.
 */

@SuppressWarnings({"unused", "FieldCanBeLocal"})

public class AttendanceException extends Exception {

    /**
     * Constructs a new AttendanceException with the specified detail message and cause.
     *
     * @param message the detail message (which is saved for later retrieval by the getMessage() method)
     * @param cause   the cause (which is saved for later retrieval by the getCause() method)
     */
    public AttendanceException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Throws an AttendanceException for the case when a user is already clocked in.
     *
     * @throws AttendanceException the AttendanceException with the corresponding error message
     */
    public static void throwError_ALREADY_CLOCKED_IN() throws AttendanceException {
        String errorMessage = "You Have Already Clocked In";
        showErrorDialog(errorMessage);
        logException(errorMessage, new Throwable());
        throw new AttendanceException(errorMessage, new Throwable());
    }

    /**
     * Throws an AttendanceException for the case when a user is not yet clocked in.
     *
     * @throws AttendanceException the AttendanceException with the corresponding error message
     */
    public static void throwError_NOT_CLOCKEDIN() throws AttendanceException {
        String errorMessage = "You Have Not Clocked In. Please Clock In First";
        showErrorDialog(errorMessage);
        logException(errorMessage, new Throwable());
        throw new AttendanceException(errorMessage, new Throwable());
    }

    /**
     * Throws an AttendanceException for the case when a user is already clocked out.
     *
     * @throws AttendanceException the AttendanceException with the corresponding error message
     */
    public static void throwError_ALREADY_CLOCKED_OUT() throws AttendanceException {
        String errorMessage = "You Have Already Clocked Out";
        showErrorDialog(errorMessage);
        logException(errorMessage, new Throwable());
        throw new AttendanceException(errorMessage, new Throwable());
    }

    /**
     * Throws an AttendanceException for the case when no record is found.
     *
     * @throws AttendanceException the AttendanceException with the corresponding error message
     */
    public static void throwError_NO_RECORD_FOUND() throws AttendanceException {
        String errorMessage = "No Record Found";
        showErrorDialog(errorMessage);
        logException(errorMessage, new Throwable());
        throw new AttendanceException(errorMessage, new Throwable());
    }

    /**
     * Throws an AttendanceException for the case of an invalid date.
     *
     * @throws AttendanceException the AttendanceException with the corresponding error message
     */
    public static void throwError_INVALID_DATE() throws AttendanceException {
        String errorMessage = "Invalid Date";
        showErrorDialog(errorMessage);
        logException(errorMessage, new Throwable());
        throw new AttendanceException(errorMessage, new Throwable());
    }

    /**
     * Displays an error dialog with the specified message.
     *
     * @param message the error message to display
     */
    private static void showErrorDialog(String message) {
        JOptionPane.showMessageDialog(null, message, "Attendance Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Logs the exception message and cause to the console.
     *
     * @param message the exception message
     * @param cause   the cause of the exception
     */
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
