package user;

import data.EmployeeRecord;
import data.UserCredentials;
import exceptions.UserRecordsException;
import interfaces.ITActions;
import interfaces.UserCredentialsDataService;
import service.FileDataService;

import java.util.List;

public class ITAdmin extends Employee implements ITActions {
    private final UserCredentialsDataService userCredentialsDataService;

    public ITAdmin(FileDataService dataService, int employeeID) {
        super(dataService, employeeID);
        userCredentialsDataService = dataService;
    }

    public List<UserCredentials> getUserRecords() {
        try {
            return userCredentialsDataService.getAllUserCredentials();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return null;
        }
    }

    public UserCredentials getUserCredentials(int employeeID) {
        try {
            return userCredentialsDataService.getUserCredentials_ByEmployeeID(String.valueOf(employeeID));
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void createUser(UserCredentials userCredentials) {
        System.out.println("Creating user: " + userCredentials);
        if (getUserRecords().contains(userCredentials)) {
            System.err.println("Already exist");
            return;
        }

        userCredentialsDataService.addUserCredentials(userCredentials);
        System.out.println("User created");
    }

    //TODO: User data services for this
    @Override
    public void updateCredentials(UserCredentials userCredential) throws UserRecordsException {
        System.out.println("Updating username: " + userCredential);

        if (getUserRecords().contains(userCredential)) {
            UserRecordsException.throwError_NOTHING_TO_UPDATE();
            return;
        }

        //update database
        userCredentialsDataService.updateUserCredentials(userCredential);

        System.out.println("User updated");
    }

    //TODO: User data services for this
    @Override
    public void deleteUser(int employeeID) throws UserRecordsException {
        System.out.println("Deleting user: " + employeeID);

        UserCredentials userCredentials = getUserCredentials(employeeID);
        if (userCredentials == null) {
            UserRecordsException.throwError_NO_RECORD_FOUND();
            return;
        }

        if (getUserRecords().contains(userCredentials)) {
            //update database
            userCredentialsDataService.deleteUserCredentials_ByEmployeeID(String.valueOf(employeeID));
            System.out.println("User deleted");
        } else {
            UserRecordsException.throwError_NO_RECORD_FOUND();
        }
    }

    public List<Integer> getEmployeeIDList() {
        try {
            return List.of(employeeDataService.getEmployeeID_List());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return null;
        }
    }

    public List<EmployeeRecord> getActiveEmployeeList() {
        try {
            return employeeDataService.getAll_Active_Employees();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return null;
        }
    }
}

