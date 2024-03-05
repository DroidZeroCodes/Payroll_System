package exceptions;

import javax.swing.*;

public class LeaveException extends Exception {
    public LeaveException(String message, Throwable cause) {
        super(message, cause);
    }

    public static void throwError_INVALID_DATE() throws LeaveException {
        String errorMessage = "Invalid Date";
        JOptionPane.showMessageDialog(null, errorMessage, "Leave Error", JOptionPane.ERROR_MESSAGE);
        logException(errorMessage, new Throwable());
        throw new LeaveException("Invalid Leave Date", new Throwable());
    }

    public static void throwError_INVALID_DATE_RANGE() throws LeaveException {
        String errorMessage = "Invalid Date Range";
        JOptionPane.showMessageDialog(null, errorMessage, "Leave Error", JOptionPane.ERROR_MESSAGE);
        logException(errorMessage, new Throwable());
        throw new LeaveException("Start Date cannot be after End Date", new Throwable());
    }

    public static void throwError_CONFLICTING_DATES() throws LeaveException {
        String errorMessage = "Conflicting Dates";
        JOptionPane.showMessageDialog(null, errorMessage, "Leave Error", JOptionPane.ERROR_MESSAGE);
        logException(errorMessage, new Throwable());
        throw new LeaveException("Conflicting Leave Request Found", new Throwable());
    }

    public static void throwError_INSUFFICIENT_BALANCE() throws LeaveException {
        String errorMessage = "Insufficient Leave Balance";
        JOptionPane.showMessageDialog(null, errorMessage, "Leave Error", JOptionPane.ERROR_MESSAGE);
        logException(errorMessage, new Throwable());
        throw new LeaveException("Insufficient Leave Balance", new Throwable());
    }

    public static void throwError_NO_RECORD_FOUND() throws LeaveException {
        String errorMessage = "Record Not Found";
        JOptionPane.showMessageDialog(null, errorMessage, "Leave Error", JOptionPane.ERROR_MESSAGE);
        logException(errorMessage, new Throwable());
        throw new LeaveException("Record Not Found", new Throwable());
    }

    public static void throwError_NO_LEAVE_BALANCE() throws LeaveException {
        String errorMessage = "No Leave Balance";
        JOptionPane.showMessageDialog(null, errorMessage, "Leave Balance Error", JOptionPane.ERROR_MESSAGE);
        logException(errorMessage, new Throwable());
        throw new LeaveException("No Leave Balance", new Throwable());
    }

    public static void throwError_FAILURE_TO_UPDATE_LEAVE_BALANCE() throws LeaveException {
        String errorMessage = "Failed to Update Leave Balance";
        JOptionPane.showMessageDialog(null, errorMessage, "Leave Balance Error", JOptionPane.ERROR_MESSAGE);
        logException(errorMessage, new Throwable());
        throw new LeaveException("Failed to Update Leave Balance", new Throwable());
    }

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
