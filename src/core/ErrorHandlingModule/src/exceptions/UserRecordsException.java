package exceptions;

import javax.swing.*;

/**
 * An exception class for user records-related errors.
 */
public class UserRecordsException extends Exception {

    /**
     * Constructs a new UserRecordsException with the specified detail message and cause.
     *
     * @param message the detail message (which is saved for later retrieval by the getMessage() method)
     * @param cause   the cause (which is saved for later retrieval by the getCause() method)
     */
    public UserRecordsException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Throws a UserRecordsException for the case of no record found.
     *
     * @throws UserRecordsException the UserRecordsException with the corresponding error message
     */
    public static void throwError_NO_RECORD_FOUND() throws UserRecordsException {
        String errorMessage = "Record Not Found";
        logException(errorMessage, new Throwable());
        showErrorDialog(errorMessage);
        JOptionPane.showMessageDialog(null, "Record Not Found", "Error", JOptionPane.ERROR_MESSAGE);
        throw new UserRecordsException(errorMessage, new Throwable());
    }

    /**
     * Throws a UserRecordsException for the case of password mismatch.
     *
     * @throws UserRecordsException the UserRecordsException with the corresponding error message
     */
    public static void throwError_PASSWORD_MISMATCH() throws UserRecordsException {
        String errorMessage = "Password Mismatch";
        logException(errorMessage, new Throwable());
        showErrorDialog(errorMessage);
        JOptionPane.showMessageDialog(null, "Password Does Not Match", "Error", JOptionPane.ERROR_MESSAGE);
        throw new UserRecordsException(errorMessage, new Throwable());
    }

    /**
     * Throws a UserRecordsException for the case of the new password being the same as the old password.
     *
     * @throws UserRecordsException the UserRecordsException with the corresponding error message
     */
    public static void throwError_SAME_PASSWORD() throws UserRecordsException {
        String errorMessage = "New password cannot be the same as old password";
        logException(errorMessage, new Throwable());
        showErrorDialog(errorMessage);
        JOptionPane.showMessageDialog(null, "New password cannot be the same as old password", "Error", JOptionPane.ERROR_MESSAGE);
        throw new UserRecordsException(errorMessage, new Throwable());
    }

    /**
     * Throws a UserRecordsException for the case of nothing to update.
     *
     * @throws UserRecordsException the UserRecordsException with the corresponding error message
     */
    public static void throwError_NOTHING_TO_UPDATE() throws UserRecordsException {
        String errorMessage = "Nothing to update";
        logException(errorMessage, new Throwable());
        showErrorDialog(errorMessage);
        throw new UserRecordsException(errorMessage, new Throwable());
    }

    /**
     * Displays an error dialog with the specified message.
     *
     * @param message the error message to display
     */
    private static void showErrorDialog(String message) {
        JOptionPane.showMessageDialog(null, message, "User Records Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Logs the exception message and cause to the console.
     *
     * @param message the exception message
     * @param cause   the cause of the exception
     */
    private static void logException(String message, Throwable cause) {
        System.err.println("User Records Exception: " + message);
        if (cause != null) {
            System.err.println("Cause: " + cause.getMessage());
            for (StackTraceElement element : cause.getStackTrace()) {
                System.err.println(element);
            }
        }
    }
}
