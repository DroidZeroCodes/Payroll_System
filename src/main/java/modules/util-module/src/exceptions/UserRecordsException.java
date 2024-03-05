package exceptions;

import javax.swing.*;

public class UserRecordsException extends Exception {
    public UserRecordsException(String message, Throwable cause) {
        super(message, cause);
    }

    public static void throwError_NO_RECORD_FOUND() throws UserRecordsException {
        String errorMessage = "Record Not Found";
        logException(errorMessage, new Throwable());
        JOptionPane.showMessageDialog(null, errorMessage, "User Records Error", JOptionPane.ERROR_MESSAGE);
        throw new UserRecordsException(errorMessage, new Throwable());
    }

    // Method to log the exception to console
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
