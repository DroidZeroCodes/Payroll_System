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

}
