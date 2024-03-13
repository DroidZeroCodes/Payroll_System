package data;

import util.Convert;

/**
 * Represents an employee record.
 */
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
        Double basicSalary,
        Double riceSubsidy,
        Double phoneAllowance,
        Double clothingAllowance,
        Double semiMonthlyRate,
        Double hourlyRate
) {
    /**
     * Converts the EmployeeRecord to an array of strings.
     *
     * @return an array of strings representing the EmployeeRecord
     */
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
                Convert.doubleToString(basicSalary),
                Convert.doubleToString(riceSubsidy),
                Convert.doubleToString(phoneAllowance),
                Convert.doubleToString(clothingAllowance),
                Convert.doubleToString(semiMonthlyRate),
                Convert.doubleToString(hourlyRate)
        };
    }
}
