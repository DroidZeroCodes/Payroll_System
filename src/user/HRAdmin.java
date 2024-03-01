package user;

import service.actions.AttendanceRecord;
import service.actions.EmployeeRecord;
import service.actions.LeaveRecord;
import ui.hrAdminUI.HRAdminUI;
import ui.hrAdminUI.ManageEmpPanel;
import ui.hrAdminUI.ProfileManagementPanel;

import java.util.List;

public class HRAdmin extends Employee {
    List <String[]> allEmployees;
    List <String[]> allLeaveHistory;
    List <String[]> allAttendanceRecords;
    ManageEmpPanel mngEmpPage;
    ProfileManagementPanel profileMngPage;
    HRAdminUI ui;
    boolean isEmployeeListsColumnsRemoved = false;
    public HRAdmin(int employeeID, HRAdminUI ui) {
        super(employeeID, null);
        this.ui = ui;
        initComponents();
    }
    @Override
    protected void initComponents() {
        myProfilePage = ui.empProfilePanel();
        attendancePage = ui.empAttendancePanel();
        payslipPage = ui.empPayslipPanel();
        leavePage = ui.empLeavePanel();
        mngEmpPage = ui.manageEmpPanel();
        profileMngPage = ui.profileManagementPanel();
    }



    /**
     *
     */
    @Override
    public void displayAttendanceRecord() {
        allAttendanceRecords =  new AttendanceRecord(employeeID).retrieveAllRecords();

        // Clear existing rows from the table model
        attendancePage.attendanceTableModel().setRowCount(0);

        allAttendanceRecords =  new AttendanceRecord(employeeID).retrieveAllRecords();

        for (String[] record : allAttendanceRecords){
            attendancePage.attendanceTableModel().addRow(record);
        }}
    @Override
    public void displayLeaveHistory() {
        allLeaveHistory = new LeaveRecord().retrieveAllRecords();

        // Clear existing rows from the table model
        leavePage.leaveHistoryModel().setRowCount(0);

        for (String[] record : allLeaveHistory){
            leavePage.leaveHistoryModel().addRow(record);
        }
    }

    public void displayEmployeeList(){
        allEmployees = new EmployeeRecord().retrieveAllRecords();

        // Clear existing rows from the table model
        mngEmpPage.empRecordTableModel().setRowCount(0);

        if (!isEmployeeListsColumnsRemoved) {
            //Hide employee Number
            var empListTable = mngEmpPage.empRecordTable();
            var birthdayColumn = empListTable.getColumnModel().getColumn(3);
            var addressColumn = empListTable.getColumnModel().getColumn(4);
            var phoneNumColumn = empListTable.getColumnModel().getColumn(5);
            var sssColumn = empListTable.getColumnModel().getColumn(6);
            var philHealthColumn = empListTable.getColumnModel().getColumn(7);
            var pagibigColumn = empListTable.getColumnModel().getColumn(8);
            var tinNumColumn = empListTable.getColumnModel().getColumn(9);
            var basicSalaryColumn = empListTable.getColumnModel().getColumn(14);
            var riceSubsidyColumn = empListTable.getColumnModel().getColumn(15);
            var phoneAllowanceColumn = empListTable.getColumnModel().getColumn(16);
            var clothingAllowanceColumn = empListTable.getColumnModel().getColumn(17);
            var gSMRColumn = empListTable.getColumnModel().getColumn(18);
            var hourlyRateColumn = empListTable.getColumnModel().getColumn(19);

            empListTable.removeColumn(birthdayColumn);
            empListTable.removeColumn(addressColumn);
            empListTable.removeColumn(phoneNumColumn);
            empListTable.removeColumn(sssColumn);
            empListTable.removeColumn(philHealthColumn);
            empListTable.removeColumn(pagibigColumn);
            empListTable.removeColumn(tinNumColumn);
            empListTable.removeColumn(basicSalaryColumn);
            empListTable.removeColumn(riceSubsidyColumn);
            empListTable.removeColumn(phoneAllowanceColumn);
            empListTable.removeColumn(clothingAllowanceColumn);
            empListTable.removeColumn(gSMRColumn);
            empListTable.removeColumn(hourlyRateColumn);

            isEmployeeListsColumnsRemoved = true; // Update the flag to indicate that columns have been removed
        }


        for (String[] record : allEmployees){
            mngEmpPage.empRecordTableModel().addRow(record);
        }
    }

    public void addEmployee(){
        String employeeID = profileMngPage.empIDTxtField().getText();
        String lastName = profileMngPage.lastNameTxtField().getText();
        String firstName = profileMngPage.firstNameTxtField().getText();
        String birthday = profileMngPage.birthdayTxtField().getText();
        String phoneNum = profileMngPage.phoneNoTxtField().getText();
        String address = profileMngPage.addressTxtArea().getText();
        String department = profileMngPage.departmentTxtField().getText();
        String position = profileMngPage.positionTxtField().getText();
        String supervisor = profileMngPage.supervisorTxtField().getText();
        String status = profileMngPage.statusTxtField().getText();
        String sssNum = profileMngPage.sssNoTextField().getText();
        String philHealthNum = profileMngPage.philHealthNoTxtField().getText();
        String pagibigNum = profileMngPage.pagibigNoTxtArea().getText();
        String tinNum = profileMngPage.tinNoTxtField().getText();
        String basicSalary = profileMngPage.basicSalaryTxtField().getText();
        String riceSubsidy = profileMngPage.riceSubsidyTxtField().getText();
        String phoneAllowance = profileMngPage.phoneAllowanceTxtField().getText();
        String clothingAllowance = profileMngPage.clothingAllowanceTxtField().getText();
        String gSMR = profileMngPage.semiMonthlyTxtField().getText();
        String hourlyRate = profileMngPage.hourlyRateTxtField().getText();

        EmployeeRecord newRecord = new EmployeeRecord();
        newRecord.addRecord(new String[]{
                employeeID,
                lastName,
                firstName,
                birthday,
                address,
                phoneNum,
                sssNum,
                philHealthNum,
                pagibigNum,
                tinNum,
                department,
                position,
                supervisor,
                status,
                basicSalary,
                riceSubsidy,
                phoneAllowance,
                clothingAllowance,
                gSMR,
                hourlyRate
        }, true);
        allEmployees = new EmployeeRecord().retrieveAllRecords();
        displayEmployeeList();
    }

    public void updateEmployee() {
    }
}
