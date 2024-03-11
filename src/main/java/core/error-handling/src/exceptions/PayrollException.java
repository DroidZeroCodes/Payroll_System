package exceptions;

import javax.swing.*;

public class PayrollException extends Exception {
    public PayrollException(String message, Throwable cause) {
        super(message, cause);
    }

    public static void throwPayrollError_INVALID_DATE() throws PayrollException {
        String errorMessage = "Invalid Date";
        logException(errorMessage, new Throwable());
        JOptionPane.showMessageDialog(null, errorMessage, "Payroll Error", JOptionPane.ERROR_MESSAGE);
        throw new PayrollException("Invalid Payroll Date", new Throwable());
    }

    public static void throwError_NO_RECORD_FOUND() throws PayrollException {
        String errorMessage = "Record Not Found";
        logException(errorMessage, new Throwable());
        JOptionPane.showMessageDialog(null, errorMessage, "Payroll Error", JOptionPane.ERROR_MESSAGE);
        throw new PayrollException("Record Not Found", new Throwable());
    }

    public static void throwError_NO_PAYROLL_PROCESSED() throws PayrollException {
        String errorMessage = "No Payroll Processed For This Period";
        logException(errorMessage, new Throwable());
        JOptionPane.showMessageDialog(null, errorMessage, "Payroll Error", JOptionPane.ERROR_MESSAGE);
        throw new PayrollException("No Payroll Processed For This Period", new Throwable());
    }

    public static void throwError_FAILED_PAYROLL() throws PayrollException {
        String errorMessage = "Payroll Run Failed";
        logException(errorMessage, new Throwable());
        JOptionPane.showMessageDialog(null, errorMessage, "Payroll Error", JOptionPane.ERROR_MESSAGE);
        throw new PayrollException("Payroll Run Failed", new Throwable());
    }

    public static void throwError_PAYROLL_ALREADY_PROCESSED() throws PayrollException {
        String errorMessage = "Payroll Already Processed For This Period";
        logException(errorMessage, new Throwable());
        JOptionPane.showMessageDialog(null, errorMessage, "Payroll Error", JOptionPane.ERROR_MESSAGE);
        throw new PayrollException("Record Already Has Payroll", new Throwable());
    }

    public static void throwError_FAILED_REPORT_GENERATION() throws PayrollException {
        String errorMessage = "Report Generation Failed";
        logException(errorMessage, new Throwable());
        JOptionPane.showMessageDialog(null, errorMessage, "Payroll Report Error", JOptionPane.ERROR_MESSAGE);
        throw new PayrollException("Report Generation Failed", new Throwable());
    }

    // Method to log the exception to console
    public static void throwError_INVALID_SEARCH_FIELD() throws PayrollException {
        String errorMessage = "Invalid Search Field";
        logException(errorMessage, new Throwable());
        JOptionPane.showMessageDialog(null, errorMessage, "Payroll Error", JOptionPane.ERROR_MESSAGE);
        throw new PayrollException("Invalid Search Field", new Throwable());
    }

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
