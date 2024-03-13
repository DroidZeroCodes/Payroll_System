package data;

/**
 * Represents a leave balance record for an employee.
 */
public record LeaveBalanceRecord(
        int employeeID,
        int sickBalance,
        int vacationBalance,
        int paternalBalance,
        int bereavementBalance
) {
    /**
     * Returns a new LeaveBalanceRecord with the specified sick balance.
     *
     * @param sickBalance the sick balance
     * @return a new LeaveBalanceRecord with the specified sick balance
     */
    public LeaveBalanceRecord withSickBalance(int sickBalance) {
        return new LeaveBalanceRecord(
                employeeID,
                sickBalance,
                vacationBalance,
                paternalBalance,
                bereavementBalance);
    }

    /**
     * Returns a new LeaveBalanceRecord with the specified vacation balance.
     *
     * @param vacationBalance the vacation balance
     * @return a new LeaveBalanceRecord with the specified vacation balance
     */
    public LeaveBalanceRecord withVacationBalance(int vacationBalance) {
        return new LeaveBalanceRecord(
                employeeID,
                sickBalance,
                vacationBalance,
                paternalBalance,
                bereavementBalance);
    }

    /**
     * Returns a new LeaveBalanceRecord with the specified paternal balance.
     *
     * @param paternalBalance the paternal balance
     * @return a new LeaveBalanceRecord with the specified paternal balance
     */
    public LeaveBalanceRecord withPaternalBalance(int paternalBalance) {
        return new LeaveBalanceRecord(
                employeeID,
                sickBalance,
                vacationBalance,
                paternalBalance,
                bereavementBalance);
    }

    /**
     * Returns a new LeaveBalanceRecord with the specified bereavement balance.
     *
     * @param bereavementBalance the bereavement balance
     * @return a new LeaveBalanceRecord with the specified bereavement balance
     */
    public LeaveBalanceRecord withBereavementBalance(int bereavementBalance) {
        return new LeaveBalanceRecord(
                employeeID,
                sickBalance,
                vacationBalance,
                paternalBalance,
                bereavementBalance);
    }

    /**
     * Converts the LeaveBalanceRecord to an array of strings.
     *
     * @return an array of strings representing the LeaveBalanceRecord
     */
    public String[] toArray() {
        return new String[]{
                String.valueOf(employeeID),
                String.valueOf(sickBalance),
                String.valueOf(vacationBalance),
                String.valueOf(paternalBalance),
                String.valueOf(bereavementBalance)
        };
    }
}
