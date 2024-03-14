package users.roles;

import exceptions.UserRecordsException;
import interfaces.UserManagement;
import manager.EmployeeManager;
import manager.UserManager;
import records.EmployeeRecord;
import records.UserCredentials;
import service.FileDataService;

import java.util.List;

/**
 * Represents an IT Admin in the system, responsible for managing user credentials and employee records.
 * <p>
 * Available methods:
 * <ul>
 *     <li>{@link ITAdmin#getEmployeeIDList()} Retrieves a list of employee IDs.</li>
 *     <li>{@link ITAdmin#getUserCredentials(int)} Retrieves the user credentials for the specified employee.</li>
 *     <li>{@link ITAdmin#getAllUserRecords()} Retrieves a list of all user records.</li>
 *     <li>{@link ITAdmin#getEmployeeRecord(int)} Retrieves the employee record for the specified employee.</li>
 *     <li>{@link ITAdmin#createUser(UserCredentials)} Creates a new user with the given credentials.</li>
 *     <li>{@link ITAdmin#updateCredentials(UserCredentials)} Updates the credentials of an existing user.</li>
 *     <li>{@link ITAdmin#deleteUser(int)} Deletes a user's credentials based on the employee ID.</li>
 * </ul>
 */
public class ITAdmin extends Employee {
    private final UserManagement userManager;
    private final EmployeeManager employeeManager;

    /**
     * Constructs an ITAdmin object.
     *
     * @param dataService The data service used for data manipulation.
     * @param employeeID  The unique identifier of the IT Admin employee.
     */
    public ITAdmin(FileDataService dataService, int employeeID) {
        super(dataService, employeeID);

        this.userManager = new UserManager(dataService);
        this.employeeManager = new EmployeeManager(dataService);
    }

    // Getters

    /**
     * Retrieves a list of employee IDs.
     *
     * @return A list of employee IDs.
     */
    public List<Integer> getEmployeeIDList() {
        return employeeManager.getEmployeeIDList();
    }

    /**
     * Retrieves the user credentials for the specified employee.
     *
     * @param employeeID The ID of the employee.
     * @return The user credentials for the specified employee.
     */
    public UserCredentials getUserCredentials(int employeeID) {
        return userManager.getUserRecord(employeeID);
    }

    /**
     * Retrieves a list of all user records.
     *
     * @return A list of all user records.
     */
    public List<UserCredentials> getAllUserRecords() {
        return userManager.getAllUserRecords();
    }

    /**
     * Retrieves the employee record for the specified employee.
     *
     * @param employeeID The ID of the employee.
     * @return The employee record for the specified employee.
     */
    public EmployeeRecord getEmployeeRecord(int employeeID) {
        return employeeManager.getEmployeeRecord(employeeID);
    }

    // Methods

    /**
     * Creates a new user with the given credentials.
     *
     * @param userCredentials The credentials of the new user.
     */
    public void createUser(UserCredentials userCredentials) {
        userManager.createUser(userCredentials);
    }

    /**
     * Updates the credentials of an existing user.
     *
     * @param userCredential The updated credentials.
     * @throws UserRecordsException If an error occurs while updating the user credentials.
     */
    public void updateCredentials(UserCredentials userCredential) throws UserRecordsException {
        userManager.updateCredentials(userCredential);
    }

    /**
     * Deletes a user's credentials based on the employee ID.
     *
     * @param employeeID The ID of the employee whose credentials are to be deleted.
     * @throws UserRecordsException If an error occurs while deleting the user credentials.
     */
    public void deleteUser(int employeeID) throws UserRecordsException {
        userManager.deleteUser(employeeID);
    }
}
