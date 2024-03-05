package user;

import data.EmployeeRecord;
import data.UserCredentials;
import exceptions.UserRecordsException;
import interfaces.ITActions;
import interfaces.UserCredentialsDataService;
import service.FileDataService;

import java.util.List;

public class ITAdmin extends Employee implements ITActions {
    private List<UserCredentials> userRecords;
    private final UserCredentialsDataService userCredentialsDataService;

    public ITAdmin(FileDataService dataService, int employeeID) {
        super(dataService, employeeID);
        userCredentialsDataService = dataService;
        try {
            userRecords = userCredentialsDataService.getAllUserCredentials();
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

    @Override
    public void createUser(UserCredentials userCredentials) {
        System.out.println("Creating user: " + userCredentials);
        if (userRecords.contains(userCredentials)) {
            System.err.println("Already exist");
            return;
        }

        userCredentialsDataService.addUserCredentials(userCredentials);
        userRecords.add(userCredentials);
        System.out.println("User created");
    }

    //TODO: User data services for this
    @Override
    public void updateCredentials(UserCredentials userCredential) throws UserRecordsException {
        System.out.println("Updating username: " + userCredential);

        if (userRecords.contains(userCredential)) {
            UserRecordsException.throwError_NOTHING_TO_UPDATE();
            return;
        }

        try {
            //update display
            for (int i = 0; i < userRecords.size(); i++) {
                UserCredentials record = userRecords.get(i);
                if (record.employeeID() == userCredential.employeeID()) {
                    userRecords.set(i, userCredential);
                }
            }

            //update database
            userCredentialsDataService.updateUserCredentials(userCredential);

            System.out.println("User updated");
        } catch (Exception e) {
            UserRecordsException.throwError_NO_RECORD_FOUND();
        }
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

        if (userRecords.contains(userCredentials)) {
            //update database
            userCredentialsDataService.deleteUserCredentials_ByEmployeeID(String.valueOf(employeeID));
            //update display
            userRecords.remove(userCredentials);

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

