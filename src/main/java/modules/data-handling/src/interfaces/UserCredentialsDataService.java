package interfaces;

import data.UserCredentials;

import java.util.List;

public interface UserCredentialsDataService {

    UserCredentials getUserCredentials_ByEmployeeID(String employeeID);

    UserCredentials getUserCredentials_ByUserName(String userName);

    List<UserCredentials> getUserCredentials_ByRole(String role);

    List<UserCredentials> getUserCredentials_ByPosition(String position);

    List<UserCredentials> getUserCredentials_ByDepartment(String department);

    List<UserCredentials> getAllUserCredentials();

    void addUserCredentials(UserCredentials userCredentials);
}
