package ui;

import ui.employee.AttendancePanel;
import ui.employee.LeavePanel;
import ui.employee.MyPayslipPanel;
import ui.employee.MyProfilePanel;

import javax.swing.*;

public interface GeneralComponents {
    MyProfilePanel getMyProfilePage();
    AttendancePanel getAttendancePage();
    MyPayslipPanel getPayslipPage();
    LeavePanel getLeavePage();

    JButton getAttedanceBTN();

    JButton getLeaveBTN();

    JButton getMyProfileBTN();

    JButton getPayslipBTN();
}
