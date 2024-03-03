package data;

public record LeaveBalanceRecord(
        int employeeID,
        int sickBalance,
        int vacationBalance,
        int paternalBalance,
        int bereavementBalance
) {
    public LeaveBalanceRecord withSickBalance(int sickBalance) {
        return new LeaveBalanceRecord(employeeID, sickBalance, vacationBalance, paternalBalance, bereavementBalance);
    }
    public LeaveBalanceRecord withVacationBalance(int vacationBalance) {
        return new LeaveBalanceRecord(employeeID, sickBalance, vacationBalance, paternalBalance, bereavementBalance);
    }

    public LeaveBalanceRecord withPaternalBalance(int paternalBalance) {
        return new LeaveBalanceRecord(employeeID, sickBalance, vacationBalance, paternalBalance, bereavementBalance);
    }

    public LeaveBalanceRecord withBereavementBalance(int bereavementBalance) {
        return new LeaveBalanceRecord(employeeID, sickBalance, vacationBalance, paternalBalance, bereavementBalance);
    }
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
