package user;

import data.EmployeeRecord;
import data.UserCredentials;
import interfaces.ITActions;
import interfaces.UserCredentialsDataService;
import service.FileDataService;

import java.util.List;

public class ITAdmin extends Employee implements ITActions {
    private List<UserCredentials> userRecords;
    private List<EmployeeRecord> employees;
    private List<Integer> employeeIDList;
    private final UserCredentialsDataService userCredentialsDataService;

    public ITAdmin(FileDataService dataService, int employeeID) {
        super(dataService, employeeID);
        userCredentialsDataService = dataService;
        try {
            userRecords = userCredentialsDataService.getAllUserCredentials();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        try {
            employees = employeeDataService.getAll_Active_Employees();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        try {
            employeeIDList = List.of(employeeDataService.getEmployeeID_List());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public List<UserCredentials> getUserRecords() {
        return userRecords;
    }

    public UserCredentials getUserCredentials(int employeeID) {
        try {
            return userCredentialsDataService.getUserCredentials_ByEmployeeID(String.valueOf(employeeID));
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return null;
        }
    }

    public UserCredentials getUserCredentials(String username) {
        try {
            return userCredentialsDataService.getUserCredentials_ByUserName(username);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void createUser(UserCredentials userCredentials) {
        if (userRecords.contains(userCredentials)) {
            System.err.println("Already exist");
            return;
        }

        userCredentialsDataService.addUserCredentials(userCredentials);
    }

    //TODO: User data services for this
    @Override
    public void updateCredentials(UserCredentials userCredential) {
        System.out.println("Updating username: " + userCredential);

        //update database
        userCredentialsDataService.updateUserCredentials(userCredential);
        //update display
        if (userRecords.contains(userCredential)) {
            userRecords.set(userRecords.indexOf(userCredential), userCredential);
        } else {
            System.err.println("User not found");
        }
    }

    //TODO: User data services for this
    @Override
    public void deleteUser(int employeeID) {
        System.out.println("Deleting user: " + employeeID);

        if (userRecords.contains(getUserCredentials(employeeID))) {
            //update database
            userCredentialsDataService.deleteUserCredentials_ByEmployeeID(String.valueOf(employeeID));
            //update display
            userRecords.remove(getUserCredentials(employeeID));
        } else {
            System.err.println("User not found");
        }
    }

    public List<Integer> getEmployeeIDList() {
        return employeeIDList;
    }
}

