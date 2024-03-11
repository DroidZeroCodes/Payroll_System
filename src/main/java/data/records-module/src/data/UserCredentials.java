package data;

import java.time.LocalDateTime;

public record UserCredentials(
        int employeeID,
        String username,
        String password,
        String position,
        String department,
        String role,
        LocalDateTime lastModified
) {
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
