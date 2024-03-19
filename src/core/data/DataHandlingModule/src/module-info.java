/**
 * Module for handling data.
 */
module DataHandlingModule {
    requires RecordsManagementModule;
    requires com.opencsv;

    exports data.handlers;
    exports data.service;
}