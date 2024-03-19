/**
 * Module for managing leaves.
 */
module LeaveManagementModule {
    requires DataHandlingModule;
    requires ErrorHandlingModule;
    requires RecordsManagementModule;

    exports leave.manager;
}