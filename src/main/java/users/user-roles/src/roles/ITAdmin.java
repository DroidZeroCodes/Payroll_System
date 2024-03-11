package roles;

import data.EmployeeRecord;
import data.UserCredentials;
import exceptions.UserRecordsException;
import interfaces.UserManagement;
import service.EmployeeManager;
import service.FileDataService;
import service.UserManager;

import java.util.List;

public class ITAdmin extends Employee {
    private UserManagement userManager;
    private EmployeeManager employeeManager;

    public ITAdmin(FileDataService dataService, int employeeID) {
        super(dataService, employeeID);

        this.userManager = new UserManager(dataService);
        this.employeeManager = new EmployeeManager(dataService);
    }

    // Getters
    public List<Integer> getEmployeeIDList() {
        return employeeManager.getEmployeeIDList();
    }

    public UserCredentials getUserCredentials(int employeeID) {
        return userManager.getUserRecord(employeeID);
    }

    public List<UserCredentials> getAllUserRecords() {
        return userManager.getAllUserRecords();
    }

    public EmployeeRecord getEmployeeRecord(int employeeID) {
        return employeeManager.getEmployeeRecord(employeeID);
    }

    // Methods
    public void createUser(UserCredentials userCredentials) {
        userManager.createUser(userCredentials);
    }

    public void updateCredentials(UserCredentials userCredential) throws UserRecordsException {
        userManager.updateCredentials(userCredential);
    }

    public void deleteUser(int employeeID) throws UserRecordsException {
        userManager.deleteUser(employeeID);
    }
}

