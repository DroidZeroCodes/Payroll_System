package records;

/**
 * Represents a leave balance record for an employee.
 * This record contains information about an employee's leave balances, including sick balance,
 * vacation balance, paternal balance, and bereavement balance.
 * <p>
 * Available methods:
 * <ul>
 *     <li>{@link LeaveBalanceRecord#withSickBalance(int)}</li>
 *     <li>{@link LeaveBalanceRecord#withVacationBalance(int)}</li>
 *     <li>{@link LeaveBalanceRecord#withPaternalBalance(int)}</li>
 *     <li>{@link LeaveBalanceRecord#withBereavementBalance(int)}</li>
 *     <li>{@link LeaveBalanceRecord#toArray()}</li>
 * </ul>
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
    @SuppressWarnings("unused")
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
    @SuppressWarnings("unused")
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
    @SuppressWarnings("unused")
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
    @SuppressWarnings("unused")
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
    @SuppressWarnings("unused")
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
