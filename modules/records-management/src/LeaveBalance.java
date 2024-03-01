import dataHandlingModule.util.DataHandler;

public class LeaveBalance extends Record {
    int employeeID;
    int sickBalance;
    int vacationBalance;
    int paternalBalance;
    int bereavementBalance;

    public LeaveBalance(int employeeID) {
        this.employeeID = employeeID;
        retrieveRecord();
    }

    public LeaveBalance(int employeeID, int sickBalance, int vacationBalance, int paternalBalance, int bereavementBalance) {
        this.employeeID = employeeID;
        this.sickBalance = sickBalance;
        this.vacationBalance = vacationBalance;
        this.paternalBalance = paternalBalance;
        this.bereavementBalance = bereavementBalance;
    }

    public int employeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int sickBalance() {
        return sickBalance;
    }

    public void setSickBalance(int sickBalance) {
        this.sickBalance = sickBalance;
    }

    public int vacationBalance() {
        return vacationBalance;
    }

    public void setVacationBalance(int vacationBalance) {
        this.vacationBalance = vacationBalance;
    }

    public int paternalBalance() {
        return paternalBalance;
    }

    public void setPaternalBalance(int paternalBalance) {
        this.paternalBalance = paternalBalance;
    }

    public int bereavementBalance() {
        return bereavementBalance;
    }

    public void setBereavementBalance(int bereavementBalance) {
        this.bereavementBalance = bereavementBalance;
    }

    public int getLeaveBalance(String leaveTypeBalanceField) {
        return switch (leaveTypeBalanceField) {
            case "SICK_BALANCE" -> sickBalance;
            case "VACATION_BALANCE" -> vacationBalance;
            case "PATERNITY_BALANCE" -> paternalBalance;
            case "BEREAVEMENT_BALANCE" -> bereavementBalance;
            default -> 0;
        };
    }

    @Override
    protected void retrieveRecord() {
        DataHandler dataHandler = new DataHandler(filePath());

        String[] record = dataHandler.retrieveRowData(employeeNo(), String.valueOf(employeeID));

        if (record == null) {
            System.out.println("Leave balance data not found for employee ID: " + employeeID);
        } else {
            setEmployeeID(Integer.parseInt(record[0]));
            setSickBalance(Integer.parseInt(record[1]));
            setVacationBalance(Integer.parseInt(record[2]));
            setPaternalBalance(Integer.parseInt(record[3]));
            setBereavementBalance(Integer.parseInt(record[4]));
        }
    }

    @Override
    public String toString() {
        return "Employee ID: " + employeeID +
                ", Sick Balance: " + sickBalance +
                ", Vacation Balance: " + vacationBalance +
                ", Paternal Balance: " + paternalBalance +
                ", Bereavement Balance: " + bereavementBalance;
    }

    public static void main(String[] args) {

        LeaveBalance leaveBalance = new LeaveBalance(15);
        System.out.println(leaveBalance);

    }
}
