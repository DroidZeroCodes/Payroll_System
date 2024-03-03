package exceptions;

import javax.swing.*;

public class LeaveException extends Exception {
    public LeaveException(String message) {
        super(message);
    }

    public static void throwLeaveError_INVALID_DATE() throws LeaveException {
        JOptionPane.showMessageDialog(null, "Invalid Date", "Leave Error", JOptionPane.ERROR_MESSAGE);
        throw new LeaveException("Invalid Leave Date");
    }

    public static void throwLeaveError_INVALID_DATE_RANGE() throws LeaveException {
        JOptionPane.showMessageDialog(null, "Invalid Date Range", "Leave Error", JOptionPane.ERROR_MESSAGE);
        throw new LeaveException("Start Date cannot be after End Date");
    }

    public static void throwLeaveError_CONFLICTING_DATES() throws LeaveException {
        JOptionPane.showMessageDialog(null, "Conflicting Dates", "Leave Error", JOptionPane.ERROR_MESSAGE);
        throw new LeaveException("Conflicting Leave Request Found");
    }

    public static void throwLeaveError_INSUFFICIENT_BALANCE() throws LeaveException {
        JOptionPane.showMessageDialog(null, "Insufficient Leave Balance", "Leave Error", JOptionPane.ERROR_MESSAGE);
        throw new LeaveException("Insufficient Leave Balance");
    }
}
