/**
 * Module for managing reports.
 */
module ReportManagementModule {
    requires java.datatransfer;
    requires java.desktop;
    requires DataHandlingModule;
    requires ErrorHandlingModule;
    requires RecordsManagementModule;

    exports reports.service;
}