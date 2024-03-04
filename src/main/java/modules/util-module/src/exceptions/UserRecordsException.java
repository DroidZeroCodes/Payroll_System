package exceptions;

import javax.swing.*;

public class UserRecordsException extends Exception{
    public UserRecordsException(String message) {
        super(message);
    }


    public static void throwError_NO_RECORD_FOUND() throws UserRecordsException {
        JOptionPane.showMessageDialog(null,"No records found!","User Records Error",JOptionPane.ERROR_MESSAGE);
        throw new UserRecordsException("No records found!");
    }
}
