package data;

public record UserCredentials(
        int employeeID,
        String username,
        String password,
        String position,
        String department,
        String role
) {
    public String[] toArray() {
        return new String[]{
                String.valueOf(employeeID),
                username,
                position,
                role,
                department,
                password,
        };
    }
}
