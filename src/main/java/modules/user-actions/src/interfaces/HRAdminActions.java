package interfaces;

import exceptions.EmployeeRecordsException;

public interface HRAdminActions {
    void displayEmployeeList() throws EmployeeRecordsException;
}
