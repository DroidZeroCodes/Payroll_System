package exceptions;

import javax.swing.*;

public class AttendanceException extends Exception {
    public AttendanceException(String message) {
        super(message);
    }
    public static void throwError_AlreadyClocked_IN() throws AttendanceException {
        JOptionPane.showMessageDialog(null, "You Have Already Clocked In", "Attendance Error", JOptionPane.ERROR_MESSAGE);
        throw new AttendanceException("Already Clocked In");
    }

    public static void throwAttendanceError_HasNotClocked_IN() throws AttendanceException {
        JOptionPane.showMessageDialog(null, "You Have Not Clocked In. Please Clock In First", "Attendance Error", JOptionPane.ERROR_MESSAGE);
        throw new AttendanceException("Not Clocked In");
    }

    public static void throwAttendanceError_AlreadyClocked_OUT() throws AttendanceException {
        JOptionPane.showMessageDialog(null, "You Have Already Clocked Out", "Attendance Error", JOptionPane.ERROR_MESSAGE);
        throw new AttendanceException("Already Clocked Out");
    }

    public static void throwAttendanceError_No_Record_Found() throws AttendanceException {
        JOptionPane.showMessageDialog(null, "No Record Found", "Attendance Error", JOptionPane.ERROR_MESSAGE);
        throw new AttendanceException("No Record Found");
    }
}
