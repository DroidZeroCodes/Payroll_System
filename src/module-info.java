/**
 * Main module for the Payroll System.
 */

module Payroll_System_OOP {
    requires AttendanceManagementModule;
    requires EmployeeManagementModule;
    requires LeaveManagementModule;
    requires ErrorHandlingModule;
    requires PayrollManagementModule;
    requires DataHandlingModule;
    requires RecordsManagementModule;
    requires ReportManagementModule;
    requires UserManagementModule;
    requires itextpdf;
    requires java.desktop;
    requires jcalendar;
    requires LoginAuthenticatorModule;
    requires java.logging;
    requires AbsoluteLayout.RELEASE180;


    exports start;
    exports ui.login;
    exports ui.employee;
    exports ui.hr;
    exports ui.payroll;
    exports ui.it;
    exports user.roles;
    exports user.actions;
}