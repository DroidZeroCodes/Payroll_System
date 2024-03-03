package exceptions;

import javax.swing.*;

public class EmployeeRecordsException extends Exception{

    public EmployeeRecordsException(String message) {
        super(message);
    }

    public static void throwError_NO_RECORD_FOUND() throws EmployeeRecordsException {
        JOptionPane.showMessageDialog(null, "Record Not Found", "Employee Record Error", JOptionPane.ERROR_MESSAGE);
        throw new EmployeeRecordsException("Record Not Found");
    }
}
