package exceptions;

import javax.swing.*;

/**
 * An exception class for system login-related errors.
 */
public class SystemLoginException extends Exception {

    /**
     * Constructs a new SystemLoginException with the specified detail message and cause.
     *
     * @param message the detail message (which is saved for later retrieval by the getMessage() method)
     * @param cause   the cause (which is saved for later retrieval by the getCause() method)
     */
    public SystemLoginException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Throws a SystemLoginException for the case of incorrect username or password.
     *
     * @throws SystemLoginException the SystemLoginException with the corresponding error message
     */
    public static void throwLoginError_INCORRECT_USERNAME_OR_PASSWORD() throws SystemLoginException {
        String errorMessage = "Incorrect Username or Password";
        logException(errorMessage, new Throwable());
        showErrorDialog(errorMessage);
        throw new SystemLoginException("Invalid Username or Password", new Throwable());
    }

    /**
     * Throws a SystemLoginException for the case of missing username or password.
     *
     * @throws SystemLoginException the SystemLoginException with the corresponding error message
     */
    public static void throwLoginError_MISSING_USERNAME_OR_PASSWORD() throws SystemLoginException {
        String errorMessage = "Missing Username or Password";
        logException(errorMessage, new Throwable());
        showErrorDialog(errorMessage);
        throw new SystemLoginException("Missing Username or Password", new Throwable());
    }

    /**
     * Displays an error dialog with the specified message.
     *
     * @param message the error message to display
     */
    private static void showErrorDialog(String message) {
        JOptionPane.showMessageDialog(null, message, "Login Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Logs the exception message and cause to the console.
     *
     * @param message the exception message
     * @param cause   the cause of the exception
     */
    private static void logException(String message, Throwable cause) {
        System.err.println("System Login Exception: " + message);
        if (cause != null) {
            System.err.println("Cause: " + cause.getMessage());
            for (StackTraceElement element : cause.getStackTrace()) {
                System.err.println(element);
            }
        }
    }
}
