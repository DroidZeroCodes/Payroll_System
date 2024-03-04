package exceptions;

import javax.swing.*;

public class UserRecordsException extends Exception{
    public UserRecordsException(String message) {
        super(message);
    }

    public static void throwError_NO_RECORD_FOUND() throws UserRecordsException {
        JOptionPane.showMessageDialog(null,"Record Not Found","User Records Error",JOptionPane.ERROR_MESSAGE);
        throw new UserRecordsException("Record Not Found");
    }
}
