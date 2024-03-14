package interfaces;

import data.EmployeeRecord;

import java.util.List;

/**
 * Represents a service for handling employee data.
 */
@SuppressWarnings("unused")
public interface EmployeeDataService {

    /**
     * Retrieves an employee record by employee ID.
     *
     * @param employeeID The ID of the employee.
     * @return The employee record.
     */
    EmployeeRecord getEmployeeRecord_ByEmployeeID(int employeeID);

    /**
     * Retrieves a list of employee IDs.
     *
     * @return An array of employee IDs.
     */
    Integer[] getEmployeeID_List();

    /**
     * Retrieves a list of active employee IDs.
     *
     * @return An array of active employee IDs.
     */
    Integer[] getActive_EmployeesID_List();

    /**
     * Retrieves a list of employee records by position.
     *
     * @param position The position of the employees.
     * @return A list of employee records.
     */
    List<EmployeeRecord> getEmployeeList_ByPosition(String position);

    /**
     * Retrieves a list of employee records by department.
     *
     * @param department The department of the employees.
     * @return A list of employee records.
     */
    List<EmployeeRecord> getEmployee_ByDepartment(String department);

    /**
     * Retrieves a list of all active employees.
     *
     * @return A list of active employee records.
     */
    List<EmployeeRecord> getAll_Active_Employees();

    /**
     * Retrieves a list of all employees.
     *
     * @return A list of all employee records.
     */
    List<EmployeeRecord> getAll_Employees();

    /**
     * Add a new employee record.
     *
     * @param employeeRecord The employee record to add.
     */
    void addEmployeeRecord(EmployeeRecord employeeRecord);

    /**
     * Update an existing employee record.
     *
     * @param employeeRecord The employee record to update.
     */
    void updateEmployeeRecord(EmployeeRecord employeeRecord);

    /**
     * Delete an employee record.
     *
     * @param selectedEmployee The employee record to delete.
     */
    void deleteEmployeeRecord(EmployeeRecord selectedEmployee);

    /**
     * Add employee records from a CSV file.
     *
     * @param employeeCSVPath The path to the CSV file containing employee records.
     */
    void addEmployeeCSV(String employeeCSVPath);
}