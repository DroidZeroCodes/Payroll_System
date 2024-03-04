package exceptions;

import javax.swing.*;

public class AttendanceException extends Exception {
    public AttendanceException(String message) {
        super(message);
    }
    public static void throwError_ALREADY_CLOCKED_IN() throws AttendanceException {
        JOptionPane.showMessageDialog(null, "You Have Already Clocked In", "Attendance Error", JOptionPane.ERROR_MESSAGE);
        throw new AttendanceException("Already Clocked In");
    }

    public static void throwError_NOT_CLOCKEDIN() throws AttendanceException {
        JOptionPane.showMessageDialog(null, "You Have Not Clocked In. Please Clock In First", "Attendance Error", JOptionPane.ERROR_MESSAGE);
        throw new AttendanceException("Not Clocked In");
    }

    public static void throwError_ALREADY_CLOCKED_OUT() throws AttendanceException {
        JOptionPane.showMessageDialog(null, "You Have Already Clocked Out", "Attendance Error", JOptionPane.ERROR_MESSAGE);
        throw new AttendanceException("Already Clocked Out");
    }

    public static void throwError_NO_RECORD_FOUND() throws AttendanceException {
        JOptionPane.showMessageDialog(null, "No Record Found", "Attendance Error", JOptionPane.ERROR_MESSAGE);
        throw new AttendanceException("Record Not Found");
    }
}
