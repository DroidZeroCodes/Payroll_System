package records;

import java.time.LocalDateTime;

/**
 * Represents user credentials containing information such as employee ID, username, password, position, department, role, and last modification timestamp.
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
