import dataHandlingModule.util.DataHandler;

import java.time.LocalDate;
import java.util.List;

public class LeaveRecord extends Record {

    private String leaveID;
    private int employeeID;
    private String leaveType;
    private LocalDate requestDate, startDate, endDate;
    private String leaveReason;
    private int totalDays;
    private String status;

    public LeaveRecord(){

    }

    public LeaveRecord(String leaveID, int employeeID, LocalDate requestDate, String leaveType, LocalDate startDate, LocalDate endDate, int totalDays, String leaveReason) {
        this.leaveID = leaveID;
        this.employeeID = employeeID;
        this.leaveType = leaveType;
        this.requestDate = requestDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalDays = totalDays;
        this.leaveReason = leaveReason;
        this.status = "PENDING";
    }
    public LeaveRecord(int employeeID) {
        this.employeeID = employeeID;
        retrieveRecord();
    }

    public String leaveID() {
        return leaveID;
    }

    public void setLeaveID(String leaveID) {
        this.leaveID = leaveID;
    }

    public int employeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String leaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public LocalDate requestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate startDate() {
        return startDate;
    }

    public LocalDate endDate() {
        return endDate;
    }

    public String leaveReason() {
        return leaveReason;
    }

    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason;
    }

    public int totalDays() {
        return totalDays;
    }

    public void setTotalDays(int totalDays) {
        this.totalDays = totalDays;
    }

    public String status() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    protected void retrieveRecord() {

    }
    // Method to check if dates overlap
    public static boolean datesOverlap(LocalDate startDate1, LocalDate endDate1, LocalDate startDate2, LocalDate endDate2) {
        return !endDate1.isBefore(startDate2) && !startDate1.isAfter(endDate2);
    }

    public List<String[]> retrieveAllPersonalRecord() {
        DataHandler dataHandler = new DataHandler(filePath());

        List<String[]> csv = dataHandler.retrieveMultipleData(employeeNo(), String.valueOf(employeeID));

        if (csv == null || csv.isEmpty()) {
            System.out.println("No leave record found for employee ID: " + employeeID);
        } else {
            return csv;
        }
        return csv;
    }

    @Override
    public String toString() {
        return "LeaveRecord{" +
                "leaveID='" + leaveID + '\'' +
                ", employeeID=" + employeeID +
                ", leaveType='" + leaveType + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status='" + status + '\'' +
                '}';
    }

    public static void main(String[] args) {
        LeaveRecord leaveRecord = new LeaveRecord(1);
        var leaveRecordList = leaveRecord.retrieveAllPersonalRecord();

        for (String[] record : leaveRecordList) {
            for (String field : record) {
                System.out.print(field + " ");
            }
            System.out.println();
        }
    }
}
