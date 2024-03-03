package util;

import javax.swing.*;
import java.awt.*;

public class ErrorMessages extends Component {
    public static void LoginError() {
        JOptionPane.showMessageDialog(null, "Invalid Username or Password", "Error", JOptionPane.ERROR_MESSAGE);
    }


    //Attendance Module
    public static void AttendanceModuleError_HAS_TIMED_IN(){
        JOptionPane.showMessageDialog(null, "You Have Already Timed In", "Error", JOptionPane.ERROR_MESSAGE);
    }


    //Leave Module
    public static void LeaveModuleError_INVALID_DATE() {
        JOptionPane.showMessageDialog(null, "Invalid Leave Date", "Error", JOptionPane.ERROR_MESSAGE);
    }
    public static void LeaveModuleError_INVALID_DATE_RANGE() {
        JOptionPane.showMessageDialog(null, "Start Date cannot be after End Date", "Error", JOptionPane.ERROR_MESSAGE);
    }
    public static void LeaveModuleError_CONFLICTING_DATES() {
        JOptionPane.showMessageDialog(null, "Conflicting Leave Request Found", "Error", JOptionPane.ERROR_MESSAGE);
    }
    public static void LeaveModuleError_INSUFFICIENT_BALANCE() {
        JOptionPane.showMessageDialog(null, "Insufficient Leave Balance", "Error", JOptionPane.ERROR_MESSAGE);
    }
    public static void PayrollModuleError_INVALID_DATE() {
        JOptionPane.showMessageDialog(null, "Invalid Payroll Date", "Error", JOptionPane.ERROR_MESSAGE);
    }


}