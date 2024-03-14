package interfaces;

/**
 * Defines the interface calculating salary adjustments.
 * Provides methods to calculate overtime pay and total salary.
 */

@SuppressWarnings("unused")
public interface SalaryAdjustment {
    /**
     * Calculate the overtime pay.
     *
     * @return the calculated overtime pay
     */
    double overtimePay();

    /**
     * Calculate the total salary.
     *
     * @return the total salary calculated
     */
    double salary();
}
