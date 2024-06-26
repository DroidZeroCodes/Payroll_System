package calculator;

/**
 * Defines the interface payroll calculations.
 * Provides methods to calculate withholding tax, gross pay, and net pay.
 */
@SuppressWarnings("unused")
public interface Payroll {
    /**
     * Calculate the withholding tax.
     *
     * @return the withholding tax amount
     */
    double calculateWithholdingTax();

    /**
     * Calculate the gross pay.
     *
     * @return the gross pay calculated
     */
    double calculateGrossPay();

    /**
     * Calculate the net pay.
     *
     * @return the net pay calculated
     */
    double calculateNetPay();
}
