package ui;

import ui.employee.AttendancePanel;
import ui.employee.LeavePanel;
import ui.employee.MyPayslipPanel;
import ui.employee.MyProfilePanel;

import javax.swing.*;

public interface DynamicComponents {
    MyProfilePanel getMyProfilePage_Comp();

    AttendancePanel getAttendancePage_Comp();

    MyPayslipPanel getPayslipPage_Comp();

    LeavePanel getLeavePage_Comp();

    JButton getAttedanceBTN_Comp();

    JButton getLeaveBTN_Comp();

    JButton getMyProfileBTN_Comp();

    JButton getPayslipBTN_Comp();
}
