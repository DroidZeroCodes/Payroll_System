package interfaces.payroll;

public interface TaxAndDeductions {

    double calculateSSS();

    double calculatePhilhealth();

    double calculatePagIbig();

    double calculatePartialDeduction();

    double calculateTotalDeduction();
}
