package data.service;

import records.UserCredentials;

import java.util.List;

/**
 * Represents a service for managing user credentials data.
 */
@SuppressWarnings("unused")
public interface UserCredentialsDataService {

    /**
     * Retrieves user credentials by employee ID.
     *
     * @param employeeID The ID of the employee.
     * @return The user credentials associated with the specified employee ID.
     */
    UserCredentials getUserCredentials_ByEmployeeID(String employeeID);

    /**
     * Retrieves user credentials by username.
     *
     * @param userName The username.
     * @return The user credentials associated with the specified username.
     */
    UserCredentials getUserCredentials_ByUserName(String userName);

    /**
     * Retrieves user credentials by role.
     *
     * @param role The role of the user.
     * @return A list of user credentials associated with the specified role.
     */
    List<UserCredentials> getUserCredentials_ByRole(String role);

    /**
     * Retrieves user credentials by position.
     *
     * @param position The position of the user.
     * @return A list of user credentials associated with the specified position.
     */
    List<UserCredentials> getUserCredentials_ByPosition(String position);

    /**
     * Retrieves user credentials by department.
     *
     * @param department The department of the user.
     * @return A list of user credentials associated with the specified department.
     */
    List<UserCredentials> getUserCredentials_ByDepartment(String department);

    /**
     * Retrieves all user credentials.
     *
     * @return A list of all user credentials.
     */
    List<UserCredentials> getAllUserCredentials();

    /**
     * Updates user credentials.
     *
     * @param userCredential The user credentials to be updated.
     */
    void updateUserCredentials(UserCredentials userCredential);

    /**
     * Adds user credentials.
     *
     * @param userCredentials The user credentials to be added.
     */
    void addUserCredentials(UserCredentials userCredentials);

    /**
     * Deletes user credentials by employee ID.
     *
     * @param employeeID The ID of the employee whose credentials are to be deleted.
     */
    void deleteUserCredentials_ByEmployeeID(String employeeID);
}
