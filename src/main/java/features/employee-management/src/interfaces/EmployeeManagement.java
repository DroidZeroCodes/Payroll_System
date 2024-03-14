package interfaces;

import data.EmployeeRecord;
import exceptions.EmployeeRecordsException;

import java.util.List;

/**
 * Defines the interface for managing employee records.
 * <p>
 * Available methods:
 * <ul>
 *     <li>{@link EmployeeManagement#addEmployee(EmployeeRecord)}</li>
 *     <li>{@link EmployeeManagement#updateEmployee(EmployeeRecord)}</li>
 *     <li>{@link EmployeeManagement#terminateEmployee(EmployeeRecord)}</li>
 *     <li>{@link EmployeeManagement#getEmployeeRecord(int)}</li>
 *     <li>{@link EmployeeManagement#getEmployeeList()}</li>
 *     <li>{@link EmployeeManagement#getEmployeeIDList()}</li>
 *     <li>{@link EmployeeManagement#getActiveEmployeeList()}</li>
 *     <li>{@link EmployeeManagement#getAddedEmployeeNumber(String)}</li>
 *     <li>{@link EmployeeManagement#addEmployee_CSV(String)}</li>
 * </ul>
 */

@SuppressWarnings("unused")
public interface EmployeeManagement {
    /**
     * Adds a new employee record.
     *
     * @param newRecord the new employee record to add
     * @throws EmployeeRecordsException if an error occurs while adding the employee record
     */
    void addEmployee(EmployeeRecord newRecord) throws EmployeeRecordsException;

    /**
     * Updates an existing employee record.
     *
     * @param updatedRecord the updated employee record
     * @throws EmployeeRecordsException if an error occurs while updating the employee record
     */
    void updateEmployee(EmployeeRecord updatedRecord) throws EmployeeRecordsException;

    /**
     * Terminates an employee.
     *
     * @param selectedEmployee the employee record to terminate
     * @throws EmployeeRecordsException if an error occurs while terminating the employee
     */
    void terminateEmployee(EmployeeRecord selectedEmployee) throws EmployeeRecordsException;

    /**
     * Retrieves an employee record by its ID.
     *
     * @param employeeID the ID of the employee
     * @return the employee record
     */
    EmployeeRecord getEmployeeRecord(int employeeID);

    /**
     * Retrieves a list of all employee records.
     *
     * @return a list of employee records
     */
    List<EmployeeRecord> getEmployeeList();

    /**
     * Retrieves a list of employee IDs.
     *
     * @return a list of employee IDs
     */
    List<Integer> getEmployeeIDList();

    /**
     * Retrieves a list of active employee records.
     *
     * @return a list of active employee records
     */
    List<EmployeeRecord> getActiveEmployeeList();

    /**
     * Retrieves the number of added employees from a CSV file.
     *
     * @param filePath the path to the CSV file
     * @return the number of added employees
     */
    int getAddedEmployeeNumber(String filePath);

    /**
     * Adds employees from a CSV file.
     *
     * @param employeeCSVPath the path to the CSV file containing employee data
     */
    void addEmployee_CSV(String employeeCSVPath);
}
