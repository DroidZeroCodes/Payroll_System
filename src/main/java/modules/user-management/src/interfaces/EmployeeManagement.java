package interfaces;

import data.EmployeeRecord;
import exceptions.EmployeeRecordsException;

public interface EmployeeManagement {
    void addEmployee(EmployeeRecord newRecord) throws EmployeeRecordsException;

    void updateEmployee(EmployeeRecord newRecord) throws EmployeeRecordsException;
}
