package ui;

import ui.employee.AttendancePanel;
import ui.employee.LeavePanel;
import ui.employee.MyPayslipPanel;
import ui.employee.MyProfilePanel;

import javax.swing.*;

/**
 * Represents a collection of dynamic UI components.
 */
public interface DynamicComponents {

    /**
     * Retrieves the component for the My Profile page.
     *
     * @return The My Profile page component.
     */
    MyProfilePanel getMyProfilePage_Comp();

    /**
     * Retrieves the component for the Attendance page.
     *
     * @return The Attendance page component.
     */
    AttendancePanel getAttendancePage_Comp();

    /**
     * Retrieves the component for the My Payslip page.
     *
     * @return The My Payslip page component.
     */
    MyPayslipPanel getPayslipPage_Comp();

    /**
     * Retrieves the component for the Leave page.
     *
     * @return The Leave page component.
     */
    LeavePanel getLeavePage_Comp();

    /**
     * Retrieves the button component for accessing the Attendance page.
     *
     * @return The Attendance button component.
     */
    JButton getAttendanceBTN_Comp();

    /**
     * Retrieves the button component for accessing the Leave page.
     *
     * @return The Leave button component.
     */
    JButton getLeaveBTN_Comp();

    /**
     * Retrieves the button component for accessing the My Profile page.
     *
     * @return The My Profile button component.
     */
    JButton getMyProfileBTN_Comp();

    /**
     * Retrieves the button component for accessing the My Payslip page.
     *
     * @return The My Payslip button component.
     */
    JButton getPayslipBTN_Comp();
}
