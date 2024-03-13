package exceptions;

import javax.swing.*;

/**
 * An exception class for employee record-related errors.
 */
public class EmployeeRecordsException extends Exception {

    /**
     * Constructs a new EmployeeRecordsException with the specified detail message and cause.
     *
     * @param message the detail message (which is saved for later retrieval by the getMessage() method)
     * @param cause   the cause (which is saved for later retrieval by the getCause() method)
     */
    public EmployeeRecordsException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Throws an EmployeeRecordsException for the case when no record is found.
     *
     * @throws EmployeeRecordsException the EmployeeRecordsException with the corresponding error message
     */
    public static void throwError_NO_RECORD_FOUND() throws EmployeeRecordsException {
        String errorMessage = "No Record Found";
        showErrorDialog(errorMessage);
        logException(errorMessage, new Throwable());
        throw new EmployeeRecordsException(errorMessage, new Throwable());
    }

    /**
     * Throws an EmployeeRecordsException for the case of a duplicate record.
     *
     * @throws EmployeeRecordsException the EmployeeRecordsException with the corresponding error message
     */
    public static void throwError_DUPLICATE_RECORD() throws EmployeeRecordsException {
        String errorMessage = "Record Already Exists";
        showErrorDialog(errorMessage);
        logException(errorMessage, new Throwable());
        throw new EmployeeRecordsException(errorMessage, new Throwable());
    }

    /**
     * Throws an EmployeeRecordsException for the case of an invalid search field.
     *
     * @throws EmployeeRecordsException the EmployeeRecordsException with the corresponding error message
     */
    public static void throwError_INVALID_SEARCH_FIELD() throws EmployeeRecordsException {
        String errorMessage = "Invalid Search Field";
        showErrorDialog(errorMessage);
        logException(errorMessage, new Throwable());
        throw new EmployeeRecordsException(errorMessage, new Throwable());
    }

    /**
     * Throws an EmployeeRecordsException for the case of an empty field.
     *
     * @throws EmployeeRecordsException the EmployeeRecordsException with the corresponding error message
     */
    public static void throwError_EMPTY_FIELD() throws EmployeeRecordsException {
        String errorMessage = "All Fields Are Required";
        showErrorDialog(errorMessage);
        logException(errorMessage, new Throwable());
        throw new EmployeeRecordsException(errorMessage, new Throwable());
    }

    /**
     * Throws an EmployeeRecordsException for the case when no change is made.
     *
     * @throws EmployeeRecordsException the EmployeeRecordsException with the corresponding error message
     */
    public static void throwError_NO_CHANGE() throws EmployeeRecordsException {
        String errorMessage = "No Change Made";
        showErrorDialog(errorMessage);
        logException(errorMessage, new Throwable());
        throw new EmployeeRecordsException(errorMessage, new Throwable());
    }

    /**
     * Displays an error dialog with the specified message.
     *
     * @param message the error message to display
     */
    private static void showErrorDialog(String message) {
        JOptionPane.showMessageDialog(null, message, "Employee Record Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Logs the exception message and cause to the console.
     *
     * @param message the exception message
     * @param cause   the cause of the exception
     */
    private static void logException(String message, Throwable cause) {
        System.err.println("Employee Record Exception: " + message);
        if (cause != null) {
            System.err.println("Cause: " + cause.getMessage());
            for (StackTraceElement element : cause.getStackTrace()) {
                System.err.println(element);
            }
        }
    }
}
