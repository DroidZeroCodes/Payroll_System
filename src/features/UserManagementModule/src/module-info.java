/**
 * Module for managing users.
 */

module UserManagementModule {
    requires DataHandlingModule;
    requires ErrorHandlingModule;
    requires RecordsManagementModule;

    exports user.manager;
}