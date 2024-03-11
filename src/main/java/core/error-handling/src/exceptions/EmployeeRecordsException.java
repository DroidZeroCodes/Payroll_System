package exceptions;

import javax.swing.*;

public class EmployeeRecordsException extends Exception {

    public EmployeeRecordsException(String message, Throwable cause) {
        super(message, cause);
    }

    public static void throwError_NO_RECORD_FOUND() throws EmployeeRecordsException {
        String errorMessage = "No Record Found";
        JOptionPane.showMessageDialog(null, "Record Not Found", "Employee Record Error", JOptionPane.ERROR_MESSAGE);
        logException(errorMessage, new Throwable());
        throw new EmployeeRecordsException(errorMessage, new Throwable());
    }

    public static void throwError_DUPLICATE_RECORD() throws EmployeeRecordsException {
        String errorMessage = "Record Already Exists";
        JOptionPane.showMessageDialog(null, "Duplicate Record", "Employee Record Error", JOptionPane.ERROR_MESSAGE);
        logException(errorMessage, new Throwable());
        throw new EmployeeRecordsException(errorMessage, new Throwable());
    }

    public static void throwError_INVALID_SEARCH_FIELD() throws EmployeeRecordsException {
        String errorMessage = "Invalid Search Field";
        JOptionPane.showMessageDialog(null, "Invalid Search Field", "Employee Record Error", JOptionPane.ERROR_MESSAGE);
        logException(errorMessage, new Throwable());
        throw new EmployeeRecordsException(errorMessage, new Throwable());
    }

    public static void throwError_EMPTY_FIELD() throws EmployeeRecordsException {
        String errorMessage = "All Fields Are Required";
        JOptionPane.showMessageDialog(null, "All Fields Are Required", "Employee Record Error", JOptionPane.ERROR_MESSAGE);
        logException(errorMessage, new Throwable());
        throw new EmployeeRecordsException(errorMessage, new Throwable());
    }

    public static void throwError_NO_CHANGE() throws EmployeeRecordsException {
        String errorMessage = "No Change Made";
        JOptionPane.showMessageDialog(null, "No Change Made", "Employee Record Error", JOptionPane.ERROR_MESSAGE);
        logException(errorMessage, new Throwable());
        throw new EmployeeRecordsException(errorMessage, new Throwable());
    }

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
