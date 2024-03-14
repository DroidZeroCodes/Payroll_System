package service;

import data.LeaveBalanceRecord;
import data.LeaveRecord;
import exceptions.LeaveException;
import interfaces.LeaveBalanceDataService;
import interfaces.LeaveDataService;
import interfaces.LeaveManagement;

import java.util.List;

/**
 * Manages leave-related operations.
 * This class provides methods for approving, rejecting, and retrieving leave records,
 * as well as managing leave balances.
 * Utilizes interfaces {@link interfaces.LeaveDataService}, and {@link interfaces.LeaveManagement} for data access and management.
 * <p>
 * Available methods:
 * <ul>
 *     <li>{@link LeaveManager#approveLeave(String)}</li>
 *     <li>{@link LeaveManager#rejectLeave(String, int, String, int)}</li>
 *     <li>{@link LeaveManager#getLeaveRecord(String)}</li>
 *     <li>{@link LeaveManager#getLeaveRecord_List(int)}</li>
 *     <li>{@link LeaveManager#getLeaveRecord_List()}</li>
 *     <li>{@link LeaveManager#getAllLeaveRecords()}</li>
 *     <li>{@link LeaveManager#addLeaveRecord(LeaveRecord, LeaveBalanceRecord)}</li>
 *     <li>{@link LeaveManager#getLeaveBalanceRecord(int)}</li>
 *     <li>{@link LeaveManager#getLeaveBalance_OfType(int, String)}</li>
 *     <li>{@link LeaveManager#getLeaveBalance_OfType(LeaveBalanceRecord, String)}</li>
 *     <li>{@link LeaveManager#updateLeaveBalance(LeaveBalanceRecord, String, int)}</li>
 * </ul>
 */

public class LeaveManager implements LeaveManagement {
    private final LeaveDataService leaveDataService;
    private final LeaveBalanceDataService leaveBalanceDataService;

    /**
     * Constructs a LeaveManager object with the specified LeaveDataService and LeaveBalanceDataService.
     *
     * @param leaveDataService        the data service for leave records
     * @param leaveBalanceDataService the data service for leave balance records
     */
    public LeaveManager(LeaveDataService leaveDataService, LeaveBalanceDataService leaveBalanceDataService) {
        this.leaveDataService = leaveDataService;
        this.leaveBalanceDataService = leaveBalanceDataService;
    }

    //Leave Request

    /**
     * Approves leave with the specified leave ID.
     *
     * @param leaveID the ID of the leave to approve
     */
    @Override
    public void approveLeave(String leaveID) {
        LeaveRecord leaveRecord = getLeaveRecord(leaveID).withStatus(LeaveRecord.LEAVE_STATUS.APPROVED);
        try {
            leaveDataService.updateLeaveRecord(leaveRecord);
        } catch (Exception e) {
            System.err.println("Error updating leave record: " + e);
        }
    }

    /**
     * Rejects leave with the specified leave ID, employee ID, leave type, and duration.
     *
     * @param leaveID    the ID of the leave to reject
     * @param employeeID the ID of the employee associated with the leave
     * @param leaveType  the type of leave to reject
     * @param duration   the duration of the leave to reject
     */
    @Override
    public void rejectLeave(String leaveID, int employeeID, String leaveType, int duration) {
        LeaveRecord leaveRecord = getLeaveRecord(leaveID);

        leaveRecord = leaveRecord.withStatus(LeaveRecord.LEAVE_STATUS.REJECTED);
        LeaveBalanceRecord leaveBalanceRecord = getLeaveBalanceRecord(employeeID);

        try {
            leaveDataService.updateLeaveRecord(leaveRecord);
        } catch (Exception e) {
            System.err.println("Error updating leave record: " + e);
            return;
        }
        addLeaveBalance(leaveBalanceRecord, leaveType, duration);
    }

    /**
     * Retrieves the leave record with the specified leave ID.
     *
     * @param leaveID the ID of the leave record to retrieve
     * @return the leave record
     */
    @Override
    public LeaveRecord getLeaveRecord(String leaveID) {
        try {
            return leaveDataService.getLeaveByLeaveID(leaveID);
        } catch (Exception e) {
            System.err.println("Error getting leave record: " + e);
            return null;
        }
    }

    /**
     * Retrieves a list of leave records associated with the specified employee ID.
     *
     * @param employeeID the ID of the employee
     * @return a list of leave records
     */
    @Override
    public List<LeaveRecord> getLeaveRecord_List(int employeeID) {
        try {
            return leaveDataService.getLeaveRecords_ByEmployeeID(employeeID);
        } catch (IllegalArgumentException e) {
            System.err.println("No leave records found" + e);
            return null;
        }
    }

    /**
     * Retrieves a list of all leave records.
     *
     * @return a list of all leave records
     */
    @Override
    public List<LeaveRecord> getLeaveRecord_List() {
        try {
            return leaveDataService.getAllLeaveRecords();
        } catch (IllegalArgumentException e) {
            System.err.println("No leave records found" + e);
            return null;
        }
    }

    /**
     * Retrieves a list of all leave records.
     *
     * @return a list of all leave records
     */
    @Override
    public List<LeaveRecord> getAllLeaveRecords() {
        try {
            return leaveDataService.getAllLeaveRecords();
        } catch (Exception e) {
            System.err.println("Leave record not found" + e);
            return null;
        }
    }

    /**
     * Adds a new leave record and updates the leave balance.
     *
     * @param newLeaveRecord     the new leave record to add
     * @param leaveBalanceRecord the leave balance record to update
     * @throws LeaveException if an error occurs while adding the leave record
     */
    @Override
    public void addLeaveRecord(LeaveRecord newLeaveRecord, LeaveBalanceRecord leaveBalanceRecord) throws LeaveException {
        System.out.println("Adding leave record: " + newLeaveRecord);

        if (getLeaveRecord_List().contains(newLeaveRecord)) {
            LeaveException.throwError_CONFLICTING_DATES();
            return;
        }

        //add on database
        leaveDataService.addLeaveRecord(newLeaveRecord);

        //deduct leave balance and update leave balance depending on leave type
        deductLeaveBalance(leaveBalanceRecord, newLeaveRecord.leaveType(), newLeaveRecord.totalDays());
    }

    //Leave Balance

    /**
     * Retrieves the leave balance record associated with the specified employee ID.
     *
     * @param employeeID the ID of the employee
     * @return the leave balance record
     */
    @Override
    public LeaveBalanceRecord getLeaveBalanceRecord(int employeeID) {
        try {
            return leaveBalanceDataService.getLeaveBalance_ByEmployeeID(employeeID);
        } catch (Exception e) {
            System.err.println("Error while getting leave balance: " + e.getMessage());
            return null;
        }
    }

    /**
     * Retrieves the leave balance of the specified leave type for the employee with the given ID.
     *
     * @param employeeID the ID of the employee
     * @param leaveType  the type of leave
     * @return the leave balance of the specified leave type
     */
    @Override
    public int getLeaveBalance_OfType(int employeeID, String leaveType) {
        try {
            LeaveBalanceRecord leaveBalance = getLeaveBalanceRecord(employeeID);

            return switch (leaveType) {
                case "SICK" -> leaveBalance.sickBalance();
                case "VACATION" -> leaveBalance.vacationBalance();
                case "PATERNAL" -> leaveBalance.paternalBalance();
                case "BEREAVEMENT" -> leaveBalance.bereavementBalance();
                default -> throw new IllegalArgumentException("Invalid leave type: " + leaveType);
            };
        } catch (Exception e) {
            System.err.println("Error while getting leave balance: " + e.getMessage());
            return 0;
        }
    }

    /**
     * Retrieves the leave balance of the specified leave type from the provided LeaveBalanceRecord.
     *
     * @param leaveBalance the LeaveBalanceRecord containing leave balances
     * @param leaveType    the type of leave
     * @return the leave balance of the specified leave type
     */
    @Override
    public int getLeaveBalance_OfType(LeaveBalanceRecord leaveBalance, String leaveType) {
        try {
            return switch (leaveType) {
                case "SICK" -> leaveBalance.sickBalance();
                case "VACATION" -> leaveBalance.vacationBalance();
                case "PATERNAL" -> leaveBalance.paternalBalance();
                case "BEREAVEMENT" -> leaveBalance.bereavementBalance();
                default -> throw new IllegalArgumentException("Invalid leave type: " + leaveType);
            };
        } catch (Exception e) {
            System.err.println("Error while getting leave balance: " + e.getMessage());
            return 0;
        }
    }

    private void addLeaveBalance(LeaveBalanceRecord leaveBalanceRecord, String leaveType, int days) {
        int newBalance = getLeaveBalance_OfType(leaveBalanceRecord, leaveType) + days;
        updateLeaveBalance(leaveBalanceRecord, leaveType, newBalance);
    }

    private void deductLeaveBalance(LeaveBalanceRecord leaveBalanceRecord, String leaveType, int days) throws LeaveException {
        int leaveBalanceValue = getLeaveBalance_OfType(leaveBalanceRecord, leaveType);

        if (leaveBalanceValue < days) {
            LeaveException.throwError_INSUFFICIENT_BALANCE();
            return;
        }

        updateLeaveBalance(leaveBalanceRecord, leaveType, leaveBalanceValue - days);
    }

    /**
     * Updates the leave balance record with the new balance for the specified leave type.
     *
     * @param leaveBalanceRecord the leave balance record to update
     * @param leaveType          the type of leave
     * @param newBalance         the new balance for the specified leave type
     */
    @Override
    public void updateLeaveBalance(LeaveBalanceRecord leaveBalanceRecord, String leaveType, int newBalance) {
        switch (leaveType) {
            case "SICK" -> {
                leaveBalanceRecord = leaveBalanceRecord.withSickBalance(newBalance);
                leaveBalanceDataService.updateLeaveBalance(leaveBalanceRecord);
            }
            case "VACATION" -> {
                leaveBalanceRecord = leaveBalanceRecord.withVacationBalance(newBalance);
                leaveBalanceDataService.updateLeaveBalance(leaveBalanceRecord);
            }
            case "PATERNAL" -> {
                leaveBalanceRecord = leaveBalanceRecord.withPaternalBalance(newBalance);
                leaveBalanceDataService.updateLeaveBalance(leaveBalanceRecord);
            }
            case "BEREAVEMENT" -> {
                leaveBalanceRecord = leaveBalanceRecord.withBereavementBalance(newBalance);
                leaveBalanceDataService.updateLeaveBalance(leaveBalanceRecord);
            }
        }
    }
}
