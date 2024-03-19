/**
 * Module for managing records.
 */

module RecordsManagementModule {
    requires java.datatransfer;
    requires java.desktop;
    requires itextpdf;

    exports records;
    exports records.util;
}