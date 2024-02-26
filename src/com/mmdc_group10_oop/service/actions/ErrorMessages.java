package com.mmdc_group10_oop.service.actions;

import javax.swing.*;
import java.awt.*;

public class ErrorMessages extends Component {
    public static void LoginError() {
        JOptionPane.showMessageDialog(null, "Invalid Username or Password", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void LeaveModuleError_EMPTY_DATE() {
        JOptionPane.showMessageDialog(null, "Start Date and End Date cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
    }
    public static void LeaveModuleError_INVALID_DATE() {
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