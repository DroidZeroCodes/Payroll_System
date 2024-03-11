package interfaces;

import data.EmployeeRecord;
import exceptions.EmployeeRecordsException;

import java.util.List;

public interface EmployeeManagement {
    void addEmployee(EmployeeRecord newRecord) throws EmployeeRecordsException;

    void updateEmployee(EmployeeRecord updatedRecord) throws EmployeeRecordsException;

    void terminateEmployee(EmployeeRecord selectedEmployee) throws EmployeeRecordsException;

    EmployeeRecord getEmployeeRecord(int employeeID);

    List<EmployeeRecord> getEmployeeList();

    List<Integer> getEmployeeIDList();

    List<EmployeeRecord> getActiveEmployeeList();
}
