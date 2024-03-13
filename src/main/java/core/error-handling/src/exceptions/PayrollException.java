package exceptions;

import javax.swing.*;

/**
 * An exception class for payroll-related errors.
 */
public class PayrollException extends Exception {

    /**
     * Constructs a new PayrollException with the specified detail message and cause.
     *
     * @param message the detail message (which is saved for later retrieval by the getMessage() method)
     * @param cause   the cause (which is saved for later retrieval by the getCause() method)
     */
    public PayrollException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Throws a PayrollException for the case when no record is found.
     *
     * @throws PayrollException the PayrollException with the corresponding error message
     */
    public static void throwError_NO_RECORD_FOUND() throws PayrollException {
        String errorMessage = "Record Not Found";
        logException(errorMessage, new Throwable());
        showErrorDialog(errorMessage);
        throw new PayrollException("Record Not Found", new Throwable());
    }

    /**
     * Throws a PayrollException for the case when no payroll is processed for a period.
     *
     * @throws PayrollException the PayrollException with the corresponding error message
     */
    public static void throwError_NO_PAYROLL_PROCESSED() throws PayrollException {
        String errorMessage = "No Payroll Processed For This Period";
        logException(errorMessage, new Throwable());
        showErrorDialog(errorMessage);
        throw new PayrollException("No Payroll Processed For This Period", new Throwable());
    }

    /**
     * Throws a PayrollException for the case when payroll run fails.
     *
     * @throws PayrollException the PayrollException with the corresponding error message
     */
    public static void throwError_FAILED_PAYROLL() throws PayrollException {
        String errorMessage = "Payroll Run Failed";
        logException(errorMessage, new Throwable());
        showErrorDialog(errorMessage);
        throw new PayrollException("Payroll Run Failed", new Throwable());
    }

    /**
     * Throws a PayrollException for the case when payroll is already processed for a period.
     *
     * @throws PayrollException the PayrollException with the corresponding error message
     */
    public static void throwError_PAYROLL_ALREADY_PROCESSED() throws PayrollException {
        String errorMessage = "Payroll Already Processed For This Period";
        logException(errorMessage, new Throwable());
        showErrorDialog(errorMessage);
        throw new PayrollException("Record Already Has Payroll", new Throwable());
    }

    /**
     * Throws a PayrollException for the case of an invalid search field.
     *
     * @throws PayrollException the PayrollException with the corresponding error message
     */
    public static void throwError_INVALID_SEARCH_FIELD() throws PayrollException {
        String errorMessage = "Invalid Search Field";
        logException(errorMessage, new Throwable());
        showErrorDialog(errorMessage);
        throw new PayrollException("Invalid Search Field", new Throwable());
    }

    /**
     * Displays an error dialog with the specified message.
     *
     * @param message the error message to display
     */
    private static void showErrorDialog(String message) {
        JOptionPane.showMessageDialog(null, message, "Payroll Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Logs the exception message and cause to the console.
     *
     * @param message the exception message
     * @param cause   the cause of the exception
     */
    private static void logException(String message, Throwable cause) {
        System.err.println("Payroll Exception: " + message);
        if (cause != null) {
            System.err.println("Cause: " + cause.getMessage());
            for (StackTraceElement element : cause.getStackTrace()) {
                System.err.println(element);
            }
        }
    }
}
