/**
 * Module for managing payroll.
 */
module PayrollManagementModule {
    requires java.datatransfer;
    requires java.desktop;
    requires DataHandlingModule;
    requires ErrorHandlingModule;
    requires PayrollCalculatorModule;
    requires RecordsManagementModule;
    requires AttendanceManagementModule;
    requires EmployeeManagementModule;

    exports payroll.manager;
}