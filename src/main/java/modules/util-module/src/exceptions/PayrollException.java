package exceptions;

import javax.swing.*;

public class PayrollException extends Exception {
    public PayrollException(String message) {
        super(message);
    }

    public static void throwPayrollError_INVALID_DATE() throws PayrollException {
        JOptionPane.showMessageDialog(null, "Invalid Date", "Payroll Error", JOptionPane.ERROR_MESSAGE);
        throw new PayrollException("Invalid Payroll Date");
    }

    public static void throwError_NO_RECORD_FOUND() throws PayrollException {
        JOptionPane.showMessageDialog(null, "Record Not Found", "Payroll Error", JOptionPane.ERROR_MESSAGE);
        throw new PayrollException("Record Not Found");
    }

    public static void throwError_HAS_PAYROLL() throws PayrollException {
        JOptionPane.showMessageDialog(null, "Payroll Already Processed For This Period", "Payroll Error", JOptionPane.ERROR_MESSAGE);
        throw new PayrollException("Record Already Has Payroll");
    }

    public static void throwError_NO_PAYROLL_PROCESSED() throws PayrollException {
        JOptionPane.showMessageDialog(null, "No Payroll Processed For This Period", "Payroll Error", JOptionPane.ERROR_MESSAGE);
        throw new PayrollException("No Payroll Processed For This Period");
    }
}
