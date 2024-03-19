/**
 * Module for managing attendance.
 */

module AttendanceManagementModule {
    requires DataHandlingModule;
    requires ErrorHandlingModule;
    requires RecordsManagementModule;

    exports attendance.manager;
}