package interfaces;

import data.EmployeeRecord;

import java.util.List;

public interface EmployeeDataService {

    EmployeeRecord getEmployeeRecord_ByEmployeeID(int employeeID);
    Integer[] getEmployeeIDList();

    Integer[] getActiveEmployeesIDList();

    List<EmployeeRecord> getEmployeeListByPosition(String position);

    List<EmployeeRecord> getEmployeeByDepartment(String department);

    List<EmployeeRecord> getAllActiveEmployees();

    List<EmployeeRecord> getAllEmployees();

    void addEmployeeRecord(EmployeeRecord employeeRecord);

    void updateEmployeeRecord(EmployeeRecord employeeRecord);

    void deleteEmployeeRecord(EmployeeRecord selectedEmployee);
}

