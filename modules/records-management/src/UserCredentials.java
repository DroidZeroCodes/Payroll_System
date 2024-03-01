import dataHandlingModule.util.DataHandler;

public class UserCredentials extends Record {
    String username, position, role, department, password;
    int employeeID;
    
    public UserCredentials(){
    
    }

    public UserCredentials(int employeeID, String username, String password, String position, String department, String role){
        this.employeeID = employeeID;
        this.username = username;
        this.password = password;
        this.position = position;
        this.department = department;
        this.role = role;
    }
    
    public UserCredentials(String username) {
        this.username = username;
        retrieveRecord();
    }

    public String username() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String position() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String role() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String department() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String password() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int employeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    @Override
    protected void retrieveRecord() {
            DataHandler dataHandler = new DataHandler(filePath());
            String[] record = dataHandler.retrieveRowData(primaryKey(), username);

            if (record == null) {
                System.out.println("Record not found");
            } else {
                
                setEmployeeID(Integer.parseInt(record[0]));
                setUsername(record[1]);
                setPassword(record[2]);
                setPosition(record[3]);
                setDepartment(record[4]);
                setRole(record[5]);
            }

    }

    @Override
    public String toString() {
        return "UserCredentials{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", employeeID=" + employeeID +
                "}";
    }
}