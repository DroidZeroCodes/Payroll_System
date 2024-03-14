package interfaces;


import exceptions.UserRecordsException;
import records.UserCredentials;

import java.util.List;

/**
 * Defines the interface for managing user records.
 * <p>
 * Available methods:
 * <ul>
 *     <li>{@link UserManagement#createUser(UserCredentials)}</li>
 *     <li>{@link UserManagement#updateCredentials(UserCredentials)}</li>
 *     <li>{@link UserManagement#deleteUser(int)}</li>
 *     <li>{@link UserManagement#getAllUserRecords()}</li>
 *     <li>{@link UserManagement#getUserRecord(int)}</li>
 * </ul>
 */
public interface UserManagement {
    /**
     * Creates a new user record on the database.
     *
     * @param userCredentials the user credentials to be created
     */
    void createUser(UserCredentials userCredentials);

    /**
     * Updates an existing user record on the database.
     *
     * @param userCredential the user credentials to be updated
     * @throws UserRecordsException if the user record does not exist
     */
    void updateCredentials(UserCredentials userCredential) throws UserRecordsException;


    /**
     * Deletes a user record from the database.
     *
     * @param employeeID the ID of the user to be deleted
     * @throws UserRecordsException if the user record does not exist
     */
    void deleteUser(int employeeID) throws UserRecordsException;


    /**
     * Retrieves all user records from the database.
     *
     * @return a list of all user records
     */
    List<UserCredentials> getAllUserRecords();

    /**
     * Retrieves a user record from the database.
     *
     * @param employeeID the ID of the user
     * @return the user record
     */
    UserCredentials getUserRecord(int employeeID);
}
