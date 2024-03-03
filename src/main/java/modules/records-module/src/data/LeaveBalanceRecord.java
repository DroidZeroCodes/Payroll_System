package data;

public record LeaveBalanceRecord(
        int employeeID,
        int sickBalance,
        int vacationBalance,
        int paternalBalance,
        int bereavementBalance
) {
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
