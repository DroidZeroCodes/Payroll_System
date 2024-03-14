package manager;

import exceptions.EmployeeRecordsException;
import handlers.CSVHandler;
import interfaces.EmployeeDataService;
import interfaces.EmployeeManagement;
import records.EmployeeRecord;

import java.util.List;

/**
 * Manages employee-related operations.
 * This class provides methods for adding, updating, and terminating employee records,
 * retrieving employee records, and retrieving employee IDs and lists.
 * Utilizes interfaces {@link interfaces.EmployeeDataService} and {@link interfaces.EmployeeManagement} for data access and management.
 * <p>
 * Available methods:
 * <ul>
 *     <li>{@link EmployeeManager#addEmployee(EmployeeRecord)}</li>
 *     <li>{@link EmployeeManager#updateEmployee(EmployeeRecord)}</li>
 *     <li>{@link EmployeeManager#terminateEmployee(EmployeeRecord)}</li>
 *     <li>{@link EmployeeManager#getEmployeeRecord(int)}</li>
 *     <li>{@link EmployeeManager#getEmployeeList()}</li>
 *     <li>{@link EmployeeManager#getEmployeeIDList()}</li>
 *     <li>{@link EmployeeManager#getActiveEmployeeList()}</li>
 *     <li>{@link EmployeeManager#getAddedEmployeeNumber(String)}</li>
 *     <li>{@link EmployeeManager#addEmployee_CSV(String)}</li>
 * </ul>
 */

public class EmployeeManager implements EmployeeManagement {
    private final EmployeeDataService employeeDataService;

    /**
     * Constructs an EmployeeManager object with the specified EmployeeDataService.
     *
     * @param employeeDataService the data service for employee records
     */
    public EmployeeManager(EmployeeDataService employeeDataService) {
        this.employeeDataService = employeeDataService;
    }

    /**
     * Adds a new employee record.
     *
     * @param newRecord the new employee record to add
     * @throws EmployeeRecordsException if an error occurs while adding the employee record
     */
    @Override
    public void addEmployee(EmployeeRecord newRecord) throws EmployeeRecordsException {
        System.out.println("Adding employee: " + newRecord);

        if (getEmployeeList().contains(newRecord)) {
            EmployeeRecordsException.throwError_DUPLICATE_RECORD();
            return;
        }

        employeeDataService.addEmployeeRecord(newRecord);

        System.out.println("Employee added successfully");
    }

    /**
     * Updates an existing employee record.
     *
     * @param updatedRecord the updated employee record
     * @throws EmployeeRecordsException if an error occurs while updating the employee record
     */
    @Override
    public void updateEmployee(EmployeeRecord updatedRecord) throws EmployeeRecordsException {
        System.out.println("Updating employee: " + updatedRecord);

        if (getActiveEmployeeList().contains(updatedRecord)) {
            EmployeeRecordsException.throwError_NO_CHANGE();
            return;
        }

        try {
            //update database
            employeeDataService.updateEmployeeRecord(updatedRecord);
        } catch (Exception e) {
            EmployeeRecordsException.throwError_NO_RECORD_FOUND();
        }

        System.out.println("Employee details updated successfully");
    }

    /**
     * Terminates an employee.
     *
     * @param selectedEmployee the employee record to terminate
     * @throws EmployeeRecordsException if an error occurs while terminating the employee
     */
    @Override
    public void terminateEmployee(EmployeeRecord selectedEmployee) throws EmployeeRecordsException {
        System.out.println("Terminating employee: " + selectedEmployee);

        if (!getActiveEmployeeList().contains(selectedEmployee)) {
            EmployeeRecordsException.throwError_NO_RECORD_FOUND();
            return;
        }

        //Terminate on database
        employeeDataService.deleteEmployeeRecord(selectedEmployee);

        System.out.println("Employee terminated successfully");
    }

    /**
     * Retrieves an employee record by its ID.
     *
     * @param employeeID the ID of the employee
     * @return the employee record
     */
    @Override
    public EmployeeRecord getEmployeeRecord(int employeeID) {
        try {
            return employeeDataService.getEmployeeRecord_ByEmployeeID(employeeID);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return null;
        }
    }

    /**
     * Retrieves a list of all employee records.
     *
     * @return a list of employee records
     */
    @Override
    public List<EmployeeRecord> getEmployeeList() {
        try {
            return employeeDataService.getAll_Active_Employees();
        } catch (Exception e) {
            System.err.println("Employee record not found" + e);
            return null;
        }
    }

    /**
     * Retrieves a list of employee IDs.
     *
     * @return a list of employee IDs
     */
    @Override
    public List<Integer> getEmployeeIDList() {
        try {
            return List.of(employeeDataService.getEmployeeID_List());
        } catch (Exception e) {
            System.err.println("Employee ID list not found");
            return null;
        }
    }

    /**
     * Retrieves a list of active employee records.
     *
     * @return a list of active employee records
     */
    @Override
    public List<EmployeeRecord> getActiveEmployeeList() {
        try {
            return employeeDataService.getAll_Active_Employees();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return null;
        }
    }

    /**
     * Retrieves the number of added employees from a CSV file.
     *
     * @param filePath the path to the CSV file
     * @return the number of added employees
     */
    @Override
    public int getAddedEmployeeNumber(String filePath) {
        try {
            CSVHandler CSVHandler = new CSVHandler(filePath);
            return CSVHandler.getCsvSize();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return 0;
    }

    /**
     * Adds employees from a CSV file.
     *
     * @param employeeCSVPath the path to the CSV file containing employee data
     */
    @Override
    public void addEmployee_CSV(String employeeCSVPath) {
        try {
            employeeDataService.addEmployeeCSV(employeeCSVPath);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
