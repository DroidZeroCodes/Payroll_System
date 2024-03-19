package calculator;

/**
 * Defines the interface calculating taxes and deductions.
 * Provides methods to calculate SSS, PhilHealth, PagIbig contributions,
 * partial deduction, and total deduction.
 */

@SuppressWarnings("unused")
public interface TaxAndDeductions {
    /**
     * Calculate the Social Security contribution.
     *
     * @return the Social Security contribution amount
     */
    double calculateSSS();

    /**
     * Calculate the PhilHealth contribution.
     *
     * @return the calculated PhilHealth contribution
     */
    double calculatePhilHealth();

    /**
     * Calculate the PagIbig contribution.
     *
     * @return the calculated PagIbig contribution
     */
    double calculatePagIbig();

    /**
     * Calculate the partial deduction.
     *
     * @return the total partial deduction
     */
    double calculatePartialDeduction();

    /**
     * Calculate the total deduction.
     *
     * @return the total deduction amount
     */
    double calculateTotalDeduction();
}

