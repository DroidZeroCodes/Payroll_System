package interfaces;

import data.EmployeeRecord;

import java.util.List;

@SuppressWarnings("unused")
public interface EmployeeDataService {

    EmployeeRecord getEmployeeRecord_ByEmployeeID(int employeeID);

    Integer[] getEmployeeID_List();

    Integer[] getActive_EmployeesID_List();

    List<EmployeeRecord> getEmployeeList_ByPosition(String position);

    List<EmployeeRecord> getEmployee_ByDepartment(String department);

    List<EmployeeRecord> getAll_Active_Employees();

    List<EmployeeRecord> getAll_Employees();

    void addEmployeeRecord(EmployeeRecord employeeRecord);

    void updateEmployeeRecord(EmployeeRecord employeeRecord);

    void deleteEmployeeRecord(EmployeeRecord selectedEmployee);

    void addEmployeeCSV(String employeeCSVPath);
}

