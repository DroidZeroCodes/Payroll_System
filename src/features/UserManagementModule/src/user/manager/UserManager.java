package user.manager;

import exceptions.UserRecordsException;
import data.service.UserCredentialsDataService;
import records.UserCredentials;

import java.util.List;

/**
 * Manages user-related operations.
 * <p>
 * Available methods:
 * <ul>
 *     <li>{@link UserManager#createUser(UserCredentials)} Creates a new user record in the database.</li>
 *     <li>{@link UserManager#updateCredentials(UserCredentials)} Updates a user record in the database.</li>
 *     <li>{@link UserManager#deleteUser(int)} Deletes a user record from the database.</li>
 *     <li>{@link UserManager#getAllUserRecords()} Retrieves a list of all user records.</li>
 *     <li>{@link UserManager#getUserRecord(int)} Retrieves the user record for a specific employee ID.</li>
 * </ul>
 */
public class UserManager implements UserManagement {
    private final UserCredentialsDataService userCredentialsDataService;

    /**
     * Creates a new UserManager instance.
     *
     * @param userCredentialsDataService the UserCredentialsDataService
     */
    public UserManager(UserCredentialsDataService userCredentialsDataService) {
        this.userCredentialsDataService = userCredentialsDataService;
    }

    /**
     * Creates a new user record in the database.
     *
     * @param userCredentials the user credentials to be created
     */
    @Override
    public void createUser(UserCredentials userCredentials) {
        System.out.println("Creating service: " + userCredentials);
        if (getAllUserRecords().contains(userCredentials)) {
            System.err.println("Already exist");
            return;
        }

        userCredentialsDataService.addUserCredentials(userCredentials);
        System.out.println("User created");
    }

    /**
     * Updates a user record in the database.
     *
     * @param userCredential the user credentials to be updated
     * @throws UserRecordsException if an error occurs
     */
    @Override
    public void updateCredentials(UserCredentials userCredential) throws UserRecordsException {
        System.out.println("Updating username: " + userCredential);

        if (getAllUserRecords().contains(userCredential)) {
            UserRecordsException.throwError_NOTHING_TO_UPDATE();
            return;
        }

        //update database
        userCredentialsDataService.updateUserCredentials(userCredential);

        System.out.println("User updated");
    }

    /**
     * Deletes a user record from the database.
     *
     * @param employeeID the ID of the user to be deleted
     * @throws UserRecordsException if an error occurs
     */
    @Override
    public void deleteUser(int employeeID) throws UserRecordsException {
        System.out.println("Deleting service: " + employeeID);

        UserCredentials userRecord = getUserRecord(employeeID);
        if (userRecord == null) {
            UserRecordsException.throwError_NO_RECORD_FOUND();
            return;
        }

        if (getAllUserRecords().contains(userRecord)) {
            //update database
            userCredentialsDataService.deleteUserCredentials_ByEmployeeID(String.valueOf(employeeID));
            System.out.println("User deleted");
        } else {
            UserRecordsException.throwError_NO_RECORD_FOUND();
        }
    }

    /**
     * Retrieves a list of all user records.
     *
     * @return a list of all user records
     */
    @Override
    public List<UserCredentials> getAllUserRecords() {
        try {
            return userCredentialsDataService.getAllUserCredentials();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return null;
        }
    }

    /**
     * Retrieves the user record for a specific employee ID.
     *
     * @param employeeID the employee ID for which to retrieve the user record
     * @return the UserCredentials object corresponding to the employee ID, or null if an error occurs
     */
    @Override
    public UserCredentials getUserRecord(int employeeID) {
        try {
            return userCredentialsDataService.getUserCredentials_ByEmployeeID(String.valueOf(employeeID));
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return null;
        }
    }
}
