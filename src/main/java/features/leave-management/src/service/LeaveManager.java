package service;

import data.LeaveBalanceRecord;
import data.LeaveRecord;
import exceptions.LeaveException;
import interfaces.LeaveBalanceDataService;
import interfaces.LeaveDataService;
import interfaces.LeaveManagement;

import java.util.List;

public class LeaveManager implements LeaveManagement {
    private final LeaveDataService leaveDataService;
    private final LeaveBalanceDataService leaveBalanceDataService;

    // Constructor
    public LeaveManager(LeaveDataService leaveDataService, LeaveBalanceDataService leaveBalanceDataService) {
        this.leaveDataService = leaveDataService;
        this.leaveBalanceDataService = leaveBalanceDataService;
    }

    //Leave Request

    @Override
    public void approveLeave(String leaveID) {
        LeaveRecord leaveRecord = getLeaveRecord(leaveID).withStatus(LeaveRecord.LEAVE_STATUS.APPROVED);
        try {
            leaveDataService.updateLeaveRecord(leaveRecord);
        } catch (Exception e) {
            System.err.println("Error updating leave record: " + e);
        }
    }

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

    @Override
    public LeaveRecord getLeaveRecord(String leaveID) {
        try {
            return leaveDataService.getLeaveByLeaveID(leaveID);
        } catch (Exception e) {
            System.err.println("Error getting leave record: " + e);
            return null;
        }
    }

    @Override
    public List<LeaveRecord> getLeaveRecord_List(int employeeID) {
        try {
            return leaveDataService.getLeaveRecords_ByEmployeeID(employeeID);
        } catch (IllegalArgumentException e) {
            System.err.println("No leave records found" + e);
            return null;
        }
    }

    @Override
    public List<LeaveRecord> getLeaveRecord_List() {
        try {
            return leaveDataService.getAllLeaveRecords();
        } catch (IllegalArgumentException e) {
            System.err.println("No leave records found" + e);
            return null;
        }
    }

    @Override
    public List<LeaveRecord> getAllLeaveRecords() {
        try {
            return leaveDataService.getAllLeaveRecords();
        } catch (Exception e) {
            System.err.println("Leave record not found" + e);
            return null;
        }
    }

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
    @Override
    public LeaveBalanceRecord getLeaveBalanceRecord(int employeeID) {
        try {
            return leaveBalanceDataService.getLeaveBalance_ByEmployeeID(employeeID);
        } catch (Exception e) {
            System.err.println("Error while getting leave balance: " + e.getMessage());
            return null;
        }
    }

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
