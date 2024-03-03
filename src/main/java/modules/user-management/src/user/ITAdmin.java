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
    private Integer[] employeeIDList;
    private UserCredentialsDataService userCredentialsDataService;
    public ITAdmin(FileDataService dataService, int employeeID) {
        super(dataService,employeeID);
        userCredentialsDataService = dataService;
        userRecords = userCredentialsDataService.getAllUserCredentials();
        employees = employeeDataService.getAllEmployees();
        employeeIDList = employeeDataService.getEmployeeIDList();
    }
    public List<UserCredentials> getUserRecords() {
        return userRecords;
    }

    @Override
    public void createUser(UserCredentials userCredentials) {
        if (userRecords.contains(userCredentials)){
            System.out.println("Already exist");
            return;
        }

        userCredentialsDataService.addUserCredentials(userCredentials);
    }

    @Override
    public void updateUsername(String oldUsername, String newUsername) {

    }

    @Override
    public void updatePassword(String username, String newPassword) {

    }

    @Override
    public void deleteUser(String username) {

    }
}

