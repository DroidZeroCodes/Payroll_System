/**
 * Module for managing employees.
 */
module EmployeeManagementModule {
    requires DataHandlingModule;
    requires ErrorHandlingModule;
    requires RecordsManagementModule;

    exports employee.manager;
}