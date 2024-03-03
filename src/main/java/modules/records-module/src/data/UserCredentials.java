package data;

public record UserCredentials(
        int employeeID,
        String username,
        String position,
        String role,
        String department,
        String password
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
