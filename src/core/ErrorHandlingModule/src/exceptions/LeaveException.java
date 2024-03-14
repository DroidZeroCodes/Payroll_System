package exceptions;

import javax.swing.*;

/**
 * An exception class for leave-related errors.
 */

@SuppressWarnings({"unused", "FieldCanBeLocal"})

public class LeaveException extends Exception {

    /**
     * Constructs a new LeaveException with the specified detail message and cause.
     *
     * @param message the detail message (which is saved for later retrieval by the getMessage() method)
     * @param cause   the cause (which is saved for later retrieval by the getCause() method)
     */
    public LeaveException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Throws a LeaveException for the case of an invalid date.
     *
     * @throws LeaveException the LeaveException with the corresponding error message
     */
    public static void throwError_INVALID_DATE() throws LeaveException {
        String errorMessage = "Invalid Date";
        showErrorDialog(errorMessage);
        logException(errorMessage, new Throwable());
        throw new LeaveException("Invalid Leave Date", new Throwable());
    }

    /**
     * Throws a LeaveException for the case of an invalid date range.
     *
     * @throws LeaveException the LeaveException with the corresponding error message
     */
    public static void throwError_INVALID_DATE_RANGE() throws LeaveException {
        String errorMessage = "Invalid Date Range";
        showErrorDialog(errorMessage);
        logException(errorMessage, new Throwable());
        throw new LeaveException("Start Date cannot be after End Date", new Throwable());
    }

    /**
     * Throws a LeaveException for the case of conflicting dates.
     *
     * @throws LeaveException the LeaveException with the corresponding error message
     */
    public static void throwError_CONFLICTING_DATES() throws LeaveException {
        String errorMessage = "Conflicting Dates";
        showErrorDialog(errorMessage);
        logException(errorMessage, new Throwable());
        throw new LeaveException("Conflicting Leave Request Found", new Throwable());
    }

    /**
     * Throws a LeaveException for the case of insufficient leave balance.
     *
     * @throws LeaveException the LeaveException with the corresponding error message
     */
    public static void throwError_INSUFFICIENT_BALANCE() throws LeaveException {
        String errorMessage = "Insufficient Leave Balance";
        showErrorDialog(errorMessage);
        logException(errorMessage, new Throwable());
        throw new LeaveException("Insufficient Leave Balance", new Throwable());
    }

    /**
     * Throws a LeaveException for the case when no record is found.
     *
     * @throws LeaveException the LeaveException with the corresponding error message
     */
    public static void throwError_NO_RECORD_FOUND() throws LeaveException {
        String errorMessage = "Record Not Found";
        showErrorDialog(errorMessage);
        logException(errorMessage, new Throwable());
        throw new LeaveException("Record Not Found", new Throwable());
    }

    /**
     * Throws a LeaveException for the case of no leave balance.
     *
     * @throws LeaveException the LeaveException with the corresponding error message
     */
    public static void throwError_NO_LEAVE_BALANCE() throws LeaveException {
        String errorMessage = "No Leave Balance";
        showErrorDialog(errorMessage);
        logException(errorMessage, new Throwable());
        throw new LeaveException("No Leave Balance", new Throwable());
    }

    /**
     * Throws a LeaveException for the case of failure to update leave balance.
     *
     * @throws LeaveException the LeaveException with the corresponding error message
     */
    public static void throwError_FAILURE_TO_UPDATE_LEAVE_BALANCE() throws LeaveException {
        String errorMessage = "Failed to Update Leave Balance";
        showErrorDialog(errorMessage);
        logException(errorMessage, new Throwable());
        throw new LeaveException("Failed to Update Leave Balance", new Throwable());
    }

    /**
     * Displays an error dialog with the specified message.
     *
     * @param message the error message to display
     */
    private static void showErrorDialog(String message) {
        JOptionPane.showMessageDialog(null, message, "Leave Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Logs the exception message and cause to the console.
     *
     * @param message the exception message
     * @param cause   the cause of the exception
     */
    private static void logException(String message, Throwable cause) {
        System.err.println("Leave Exception: " + message);
        if (cause != null) {
            System.err.println("Cause: " + cause.getMessage());
            for (StackTraceElement element : cause.getStackTrace()) {
                System.err.println(element);
            }
        }
    }

}
