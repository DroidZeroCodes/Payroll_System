package exceptions;

import javax.swing.*;

public class SystemLoginException extends Exception {
    public SystemLoginException(String message, Throwable cause) {
        super(message, cause);
    }

    public static void throwLoginError_INCORRECT_USERNAME_OR_PASSWORD() throws SystemLoginException {
        String errorMessage = "Incorrect Username or Password";
        logException(errorMessage, new Throwable());
        JOptionPane.showMessageDialog(null, errorMessage, "Login Error", JOptionPane.ERROR_MESSAGE);
        throw new SystemLoginException("Invalid Username or Password", new Throwable());
    }

    public static void throwLoginError_MISSING_USERNAME_OR_PASSWORD() throws SystemLoginException {
        String errorMessage = "Missing Username or Password";
        logException(errorMessage, new Throwable());
        JOptionPane.showMessageDialog(null, errorMessage, "Login Error", JOptionPane.ERROR_MESSAGE);
        throw new SystemLoginException("Missing Username or Password", new Throwable());
    }

    // Method to log the exception to console
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
