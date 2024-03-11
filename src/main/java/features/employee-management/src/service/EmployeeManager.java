package service;

import data.EmployeeRecord;
import exceptions.EmployeeRecordsException;
import interfaces.EmployeeDataService;
import interfaces.EmployeeManagement;

import java.util.List;

public class EmployeeManager implements EmployeeManagement {
    private final EmployeeDataService employeeDataService;

    // Constructor
    public EmployeeManager(EmployeeDataService employeeDataService) {
        this.employeeDataService = employeeDataService;
    }

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

    @Override
    public void updateEmployee(EmployeeRecord updatedRecord) throws EmployeeRecordsException {
        System.out.println("Updating employee: " + updatedRecord);

        if (getEmployeeList().contains(updatedRecord)) {
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

    @Override
    public void terminateEmployee(EmployeeRecord selectedEmployee) throws EmployeeRecordsException {
        System.out.println("Terminating employee: " + selectedEmployee);

        if (!getEmployeeList().contains(selectedEmployee)) {
            EmployeeRecordsException.throwError_NO_RECORD_FOUND();
            return;
        }

        //Terminate on database
        employeeDataService.deleteEmployeeRecord(selectedEmployee);

        System.out.println("Employee terminated successfully");
    }

    @Override
    public EmployeeRecord getEmployeeRecord(int employeeID) {
        try {
            return employeeDataService.getEmployeeRecord_ByEmployeeID(employeeID);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<EmployeeRecord> getEmployeeList() {
        try {
            return employeeDataService.getAll_Active_Employees();
        } catch (Exception e) {
            System.err.println("Employee record not found" + e);
            return null;
        }
    }

    @Override
    public List<Integer> getEmployeeIDList() {
        try {
            return List.of(employeeDataService.getEmployeeID_List());
        } catch (Exception e) {
            System.err.println("Employee ID list not found");
            return null;
        }
    }

    @Override
    public List<EmployeeRecord> getActiveEmployeeList() {
        try {
            return employeeDataService.getAll_Active_Employees();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return null;
        }
    }
}
