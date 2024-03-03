package exceptions;

import javax.swing.*;

public class EmployeeRecordsException extends Exception{

    public EmployeeRecordsException(String message) {
        super(message);
    }

    public static void throwEmployeeRecordsError_RECORD_NOT_FOUND() throws EmployeeRecordsException {
        JOptionPane.showMessageDialog(null, "Record Not Found", "Employee Record Error", JOptionPane.ERROR_MESSAGE);
        throw new EmployeeRecordsException("Record Not Found");
    }
}
