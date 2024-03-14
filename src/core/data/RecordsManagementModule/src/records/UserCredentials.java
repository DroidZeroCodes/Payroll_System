package records;

import java.time.LocalDateTime;

/**
 * Represents a user credentials record.
 * This record contains information about a user's credentials, such as their employee ID, username, password, position, department, and role.
 * <p>
 * Available methods:
 * <ul>
 *     <li>{@link UserCredentials#toArray()}</li>
 * </ul>
 *
 * @author [Author Name]
 */

public record UserCredentials(
        int employeeID,
        String username,
        String password,
        String position,
        String department,
        String role,
        LocalDateTime lastModified
) {
    /**
     * Converts the UserCredentials to an array of strings.
     *
     * @return array of strings representing the object's attributes
     */
    @SuppressWarnings("unused")
    public String[] toArray() {
        return new String[]{
                String.valueOf(employeeID),
                username,
                password,
                position,
                department,
                role,
                lastModified.toString()
        };
    }
}
