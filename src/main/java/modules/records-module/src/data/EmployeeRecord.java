package data;

public record EmployeeRecord(
        int employeeID,
        String lastName,
        String firstName,
        String dob,
        String address,
        String phoneNum,
        String sssNo,
        String philHealthNo,
        String pagIbigNo,
        String tinNo,
        String department,
        String position,
        String supervisor,
        String status,
        Double riceSubsidy,
        Double phoneAllowance,
        Double clothingAllowance,
        Double basicSalary,
        Double semiMonthlyRate,
        Double hourlyRate
) {
    public String[] toArray() {
        return new String[]{
                String.valueOf(employeeID),
                lastName,
                firstName,
                dob,
                address,
                phoneNum,
                sssNo,
                philHealthNo,
                pagIbigNo,
                tinNo,
                department,
                position,
                supervisor,
                status,
                String.valueOf(riceSubsidy),
                String.valueOf(phoneAllowance),
                String.valueOf(clothingAllowance),
                String.valueOf(basicSalary),
                String.valueOf(semiMonthlyRate),
                String.valueOf(hourlyRate)
        };
    }
}
