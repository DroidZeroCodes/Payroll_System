package interfaces;

import data.EmployeeRecord;

public interface EmployeeManagement {
    void addEmployee(EmployeeRecord newRecord);

    void updateEmployee(EmployeeRecord newRecord);
}
