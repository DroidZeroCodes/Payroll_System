package actions;

import data.AttendanceRecord;
import data.EmployeeRecord;
import data.LeaveRecord;
import exceptions.AttendanceException;
import exceptions.EmployeeRecordsException;
import exceptions.LeaveException;
import roles.HRAdmin;
import ui.hr.*;
import util.Convert;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Comparator;
import java.util.List;

/**
 * Handles the actions and UI interactions for the HR Admin role.
 */

@SuppressWarnings({"unused", "FieldCanBeLocal", "unchecked"})

public class HRAdminViewHandler extends EmployeeViewHandler {
    private final HRAdmin hrAdmin;
    private final HRAdminUI hrAdminUI;
    private ManageEmpPanel manageEmpPage;
    private JButton manageEmpBTN;
    private ProfileManagementPanel profileMngPage;
    private AttendanceReportPanel attendanceReportPage;
    private LeaveInfoFrame leaveInfoFrame;
    private boolean isEmployeeListsColumnsRemoved = false;

    /**
     * Constructs an HRAdminViewHandler instance.
     *
     * @param hrAdmin   The HR Admin object.
     * @param hrAdminUI The HRAdminUI instance.
     */
    public HRAdminViewHandler(HRAdmin hrAdmin, HRAdminUI hrAdminUI) {
        super(hrAdmin, null);
        this.hrAdmin = hrAdmin;
        this.hrAdminUI = hrAdminUI;
        this.dynamicComponents = hrAdminUI;
        initComponents();
        initActions();
        showMyProfilePage();
    }

    @Override
    protected void initComponents() {
        super.initComponents();
        manageEmpPage = hrAdminUI.getEmployeeManagementPanel();
        manageEmpBTN = hrAdminUI.getMngEmpBTN();
        profileMngPage = hrAdminUI.getProfileManagementPanel();
        leaveInfoFrame = hrAdminUI.getLeaveInfoFrame();
        attendanceReportPage = hrAdminUI.getAttendanceReportPanel();
    }

    @Override
    protected void initActions() {
        super.initActions();
        manageEmpBTN.addActionListener(e -> showManageEmpPage());

        hrAdminUI.getAttendanceReportBTN().addActionListener(e -> showAttendanceReportPage());


        //Leave
        showLeaveInfo();

        leaveInfoFrame.getBackBTN().addActionListener(e -> showLeavePage());

        leaveInfoFrame.getApproveBTN().addActionListener(e -> {
            String leaveID = leaveInfoFrame.getLeaveIDTxtField().getText();
            String status = leaveInfoFrame.getStatusTxtField().getText();

            if (status.equals("REJECTED")) {
                JOptionPane.showMessageDialog(null, "Leave already rejected", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (status.equals("APPROVED")) {
                JOptionPane.showMessageDialog(null, "Leave already approved", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            hrAdmin.approveLeave(leaveID);

            JOptionPane.showMessageDialog(null, "Leave approved successfully", "Success", JOptionPane.INFORMATION_MESSAGE);

            showLeavePage();
        });

        leaveInfoFrame.getRejectBTN().addActionListener(e -> {
            String status = leaveInfoFrame.getStatusTxtField().getText();

            if (status.equals("REJECTED")) {
                JOptionPane.showMessageDialog(null, "Leave already rejected", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (status.equals("APPROVED")) {
                JOptionPane.showMessageDialog(null, "Leave already approved", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String leaveID = leaveInfoFrame.getLeaveIDTxtField().getText();
            String leaveType = leaveInfoFrame.getTypeTxtField().getText();
            int duration = Integer.parseInt(leaveInfoFrame.getDurationTxtField().getText());
            int empID = Integer.parseInt(leaveInfoFrame.getEmpIDTxtField().getText());

            hrAdmin.rejectLeave(leaveID, empID, leaveType, duration);

            JOptionPane.showMessageDialog(null, "Leave rejected successfully", "Success", JOptionPane.INFORMATION_MESSAGE);

            showLeavePage();
        });

        //Manage Employee Panel
        manageEmpPage.getAddEmpBTN().addActionListener(e -> {
            clearProfileFields();
            showAddNewProfile();
        });

        manageEmpPage.getUpdateEmpBTN().addActionListener(e -> showUpdateProfile());

        manageEmpPage.getTerminateEmpBTN().addActionListener(e -> {
            try {
                hrAdmin.terminateEmployee(getSelectedEmployee());
            } catch (EmployeeRecordsException ex) {
                System.err.println("Error: " + ex.getMessage());
            }

            JOptionPane.showMessageDialog(null, "Employee Terminated Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            showManageEmpPage();
        });

        manageEmpPage.getSearchBTN().addActionListener(e -> {
            try {
                showFilteredEmployeeTable();
            } catch (EmployeeRecordsException ex) {
                System.err.println("Error: " + ex.getMessage());
            }
        });

        //Profile Management Panel
        profileMngPage.getSaveBTN().addActionListener(e -> {
            if (profileMngPage.getSaveBTN().getText().equals("Save")) {
                try {
                    if (hrAdmin.getEmployeeCSVPath() != null) {
                        hrAdmin.addEmployee();

                        profileMngPage.getAddedEmployeesNumberLabel().setText("Count : 0");
                    } else {
                        hrAdmin.addEmployee(getEmployeeRecord(Action.ADD));
                    }

                    JOptionPane.showMessageDialog(null, "Employee Added Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);

                    showManageEmpPage();
                } catch (EmployeeRecordsException ex) {
                    System.err.println("Error: " + ex.getMessage());
                }
            } else if (profileMngPage.getSaveBTN().getText().equals("Update")) {
                try {
                    hrAdmin.updateEmployee(getEmployeeRecord(Action.UPDATE));

                    JOptionPane.showMessageDialog(null, "Employee Details Updated Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);

                    showManageEmpPage();
                } catch (EmployeeRecordsException ex) {
                    System.err.println("Error: " + ex.getMessage());
                }
            }
        });

        profileMngPage.getCancelBTN().addActionListener(e -> showManageEmpPage());

        profileMngPage.getCsvAddBTN().addActionListener(e -> showEmployeeCSV_FileChooser());

        //Attendance Report
        attendanceReportPage.getGenerateBTN().addActionListener(e -> {
            try {
                String periodType = (String) attendanceReportPage.getPeriodType().getSelectedItem();
                List<String[]> generatedReport = hrAdmin.generateAttendanceReport(periodType);

                showGeneratedAttendanceReport(generatedReport);

            } catch (AttendanceException ex) {
                System.err.println("Error: " + ex.getMessage());
            }
        });

        attendanceReportPage.getSearchBTN().addActionListener(e -> {
            try {
                showFilteredReportTable();
            } catch (EmployeeRecordsException ex) {
                System.err.println("Error: " + ex.getMessage());
            }
        });

        tableListener();
    }

    private void showEmployeeCSV_FileChooser() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("CSV Files", "csv"));

        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String filePath = selectedFile.getAbsolutePath();
            hrAdmin.setEmployeeCSV_File(filePath);
            profileMngPage.getAddedEmployeesNumberLabel().setText("Count : " + hrAdmin.getAddedEmployeeCount());
        }
    }

    private void showAttendanceReportPage() {
        resetPanelVisibility();
        attendanceReportPage.setVisible(true);
    }

    private void showGeneratedAttendanceReport(List<String[]> generatedReport) {
        if (generatedReport != null) {
            for (String[] row : generatedReport) {
                attendanceReportPage.getAttendanceReportTableModel().addRow(row);
            }
        }
    }

    private void showLeaveInfo() {
        leavePage.getLeaveHistoryTable().addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int selectedRow = leavePage.getLeaveHistoryTable().getSelectedRow();
                    if (selectedRow != -1) {
                        // retrieve leave info from table
                        String leaveID = leavePage.getLeaveHistoryTable().getValueAt(selectedRow, 0).toString();

                        LeaveRecord leaveRecord;
                        leaveRecord = hrAdmin.getEmployeeLeaveRecord(leaveID);

                        String employeeID = String.valueOf(leaveRecord.employeeID());

                        EmployeeRecord employeeRecord;
                        employeeRecord = hrAdmin.getEmployeeRecord(Integer.parseInt(employeeID));

                        String requestDate = leaveRecord.requestDate().toString();
                        String startDate = leaveRecord.startDate().toString();
                        String endDate = leaveRecord.endDate().toString();
                        String status = leaveRecord.status();
                        String type = leaveRecord.leaveType();
                        String name = employeeRecord.lastName() + ", " + employeeRecord.firstName();
                        String supervisor = employeeRecord.supervisor();
                        String department = employeeRecord.department();
                        String duration = String.valueOf(leaveRecord.totalDays());
                        String reason = leaveRecord.leaveReason();

                        leaveInfoFrame.getEmpNameTxtField().setText(name);
                        leaveInfoFrame.getSupervisorTxtField().setText(supervisor);
                        leaveInfoFrame.getDepartmentTxtField().setText(department);
                        leaveInfoFrame.getDurationTxtField().setText(duration);
                        leaveInfoFrame.getReasonTxtArea().setText(reason);
                        leaveInfoFrame.getEmpIDTxtField().setText(employeeID);
                        leaveInfoFrame.getLeaveIDTxtField().setText(leaveID);
                        leaveInfoFrame.getRequestDateTxtField().setText(requestDate);
                        leaveInfoFrame.getStartDateTxtField().setText(startDate);
                        leaveInfoFrame.getEndDateTxtField().setText(endDate);
                        leaveInfoFrame.getStatusTxtField().setText(status);
                        leaveInfoFrame.getTypeTxtField().setText(type);
                        leaveInfoFrame.setVisible(true);
                    }
                }
            }
        });
    }

    private void showManageEmpPage() {
        resetPanelVisibility();
        manageEmpPage.setVisible(true);

        manageEmpPage.getUpdateEmpBTN().setEnabled(false);
        manageEmpPage.getTerminateEmpBTN().setEnabled(false);
        try {
            displayEmployeeList();
        } catch (EmployeeRecordsException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private void showAddNewProfile() {
        profileMngPage.getSaveBTN().setText("Save");
        profileMngPage.empIDTxtField().setEditable(false);
        profileMngPage.empIDTxtField().setText(hrAdmin.getNewEmployeeID());
        profileMngPage.getCsvAddBTN().setVisible(true);
        profileMngPage.getAddedEmployeesNumberLabel().setVisible(true);
        resetPanelVisibility();
        profileMngPage.setVisible(true);
    }

    private void showUpdateProfile() {
        profileMngPage.getSaveBTN().setText("Update");
        manageEmpPage.setVisible(false);
        profileMngPage.getCsvAddBTN().setVisible(false);
        manageEmpPage.getUpdateEmpBTN().setEnabled(false);
        profileMngPage.getAddedEmployeesNumberLabel().setVisible(false);
        resetPanelVisibility();
        profileMngPage.setVisible(true);
    }

    /**
     * Filters the employee table based on the employee ID entered the search field.
     * If the entered employee ID is not found or invalid, appropriate error messages are displayed.
     * If no employee ID is entered or the entered ID is 0, the table filter is cleared.
     *
     * @throws EmployeeRecordsException if there is an error in the employee records
     */
    private void showFilteredEmployeeTable() throws EmployeeRecordsException {
        TableRowSorter<DefaultTableModel> employeeTableSorter = manageEmpPage.getEmployeeTableSorter();

        // Check if employeeTableSorter is null
        if (employeeTableSorter == null) {
            // Handle the situation where employeeTableSorter is null (for example, throw an exception or log an error)
            System.out.println("Employee Table sorter is null");
            return;
        }

        int empID;

        try {
            // Get the employee ID from the search field
            empID = Integer.parseInt(manageEmpPage.getSearchField().getText());
        } catch (NumberFormatException e) {
            // If the entered employee ID is not a number, throw error
            employeeTableSorter.setRowFilter(null);
            EmployeeRecordsException.throwError_INVALID_SEARCH_FIELD();
            return;
        }

        if (empID <= 0) {
            // Clear the table filter if no employee ID is entered or the entered ID is 0
            employeeTableSorter.setRowFilter(null);
            return;
        }

        if (!hrAdmin.getEmployeeIDList().contains(empID)) {
            // If the entered employee ID is not found in the records, throw error and clear the filter
            employeeTableSorter.setRowFilter(null);
            EmployeeRecordsException.throwError_NO_RECORD_FOUND();
            return;
        }

        employeeTableSorter.setRowFilter(RowFilter.regexFilter("^" + empID + "$", 0));

        // Check if any records match the filter
        if (manageEmpPage.getEmployeeTable().getRowCount() == 0) {
            // If no records match the filter, throw error and clear the filter
            employeeTableSorter.setRowFilter(null);
            EmployeeRecordsException.throwError_NO_RECORD_FOUND();
        }
    }

    private void showFilteredReportTable() throws EmployeeRecordsException {
        TableRowSorter<DefaultTableModel> reportTableSorter = attendanceReportPage.getReportTableSorter();

        // Check if reportTableSorter is null
        if (reportTableSorter == null) {
            // Handle the situation where reportTableSorter is null (for example, throw an exception or log an error)
            System.out.println("reportTableSorter is null");
            return;
        }

        int empID;

        try {
            // Get the employee ID from the search field
            empID = Integer.parseInt(attendanceReportPage.getSearchField().getText());
            reportTableSorter.setRowFilter(null);
        } catch (NumberFormatException e) {
            // If the entered employee ID is not a number, throw error
            reportTableSorter.setRowFilter(null);
            EmployeeRecordsException.throwError_INVALID_SEARCH_FIELD();
            return;
        }

        if (empID <= 0) {
            // Clear the table filter if no employee ID is entered or the entered ID is 0
            reportTableSorter.setRowFilter(null);
            return;
        }

        if (!hrAdmin.getEmployeeIDList().contains(empID)) {
            // If the entered employee ID is not found in the records, throw error and clear the filter
            reportTableSorter.setRowFilter(null);
            EmployeeRecordsException.throwError_NO_RECORD_FOUND();
            return;
        }

        reportTableSorter.setRowFilter(RowFilter.regexFilter("^" + empID + "$", 0));

        // Check if any records match the filter
        if (attendanceReportPage.getAttendanceReportTable().getRowCount() == 0) {
            // If no records match the filter, throw error and clear the filter
            reportTableSorter.setRowFilter(null);
            EmployeeRecordsException.throwError_NO_RECORD_FOUND();
        }
    }

    /**
     *
     */


    @Override
    protected void displayAttendanceRecord() throws AttendanceException {
        List<AttendanceRecord> allAttendanceRecords = hrAdmin.getAllAttendanceRecords();

        if (allAttendanceRecords.isEmpty()) {
            AttendanceException.throwError_NO_RECORD_FOUND();
            return;
        }

        // Clear existing rows from the table model
        attendancePage.getAttendanceTableModel().setRowCount(0);

        for (AttendanceRecord record : allAttendanceRecords) {
            String[] recordArray = record.toArray();
            attendancePage.getAttendanceTableModel().addRow(recordArray);
        }

        attendancePage.getAttendanceTable().getColumnModel().getColumn(1).setCellRenderer(dateRenderer);

        DefaultTableModel model = (DefaultTableModel) attendancePage.getAttendanceTable().getModel();
        TableRowSorter<DefaultTableModel> sorter = (TableRowSorter<DefaultTableModel>) attendancePage.getAttendanceTable().getRowSorter();
        sorter.setComparator(0, Comparator.naturalOrder());
        sorter.setSortKeys(List.of(new RowSorter.SortKey(0, SortOrder.DESCENDING)));
        attendancePage.getAttendanceTable().setRowSorter(sorter);

        attendancePage.getAttendanceTable().setModel(model);
    }

    @Override
    protected void displayLeaveHistory() throws LeaveException {
        List<LeaveRecord> allLeaveHistory = hrAdmin.getAllLeaveRecords();

        // Clear existing rows from the table model
        leavePage.getLeaveHistoryModel().setRowCount(0);

        if (allLeaveHistory.isEmpty()) {
            LeaveException.throwError_NO_RECORD_FOUND();
            return;
        }

        for (LeaveRecord record : allLeaveHistory) {
            String[] recordArray = record.toArray();
            leavePage.getLeaveHistoryModel().addRow(recordArray);
        }

        leavePage.getLeaveHistoryTable().getColumnModel().getColumn(2).setCellRenderer(dateRenderer);
        leavePage.getLeaveHistoryTable().getColumnModel().getColumn(4).setCellRenderer(dateRenderer);
        leavePage.getLeaveHistoryTable().getColumnModel().getColumn(5).setCellRenderer(dateRenderer);


        DefaultTableModel model = (DefaultTableModel) leavePage.getLeaveHistoryTable().getModel();
        TableRowSorter<DefaultTableModel> sorter = (TableRowSorter<DefaultTableModel>) leavePage.getLeaveHistoryTable().getRowSorter();
        sorter.setComparator(0, Comparator.naturalOrder());
        sorter.setSortKeys(List.of(new RowSorter.SortKey(0, SortOrder.DESCENDING)));
        leavePage.getLeaveHistoryTable().setRowSorter(sorter);

        leavePage.getLeaveHistoryTable().setModel(model);
    }

    private void displayEmployeeList() throws EmployeeRecordsException {
        List<EmployeeRecord> allEmployees = hrAdmin.getActiveEmployeeList();

        // Clear existing rows from the table model
        manageEmpPage.getEmployeeTableModel().setRowCount(0);

        if (allEmployees.isEmpty()) {
            EmployeeRecordsException.throwError_NO_RECORD_FOUND();
            return;
        }


        if (!isEmployeeListsColumnsRemoved) {
            //Hide employee Number
            var empListTable = manageEmpPage.getEmployeeTable();
            var birthdayColumn = empListTable.getColumnModel().getColumn(3);
            var addressColumn = empListTable.getColumnModel().getColumn(4);
            var phoneNumColumn = empListTable.getColumnModel().getColumn(5);
            var sssColumn = empListTable.getColumnModel().getColumn(6);
            var philHealthColumn = empListTable.getColumnModel().getColumn(7);
            var pagIbigColumn = empListTable.getColumnModel().getColumn(8);
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
            empListTable.removeColumn(pagIbigColumn);
            empListTable.removeColumn(tinNumColumn);
            empListTable.removeColumn(basicSalaryColumn);
            empListTable.removeColumn(riceSubsidyColumn);
            empListTable.removeColumn(phoneAllowanceColumn);
            empListTable.removeColumn(clothingAllowanceColumn);
            empListTable.removeColumn(gSMRColumn);
            empListTable.removeColumn(hourlyRateColumn);

            isEmployeeListsColumnsRemoved = true; // Update the flag to indicate that columns have been removed
        }


        for (EmployeeRecord record : allEmployees) {
            String[] recordArray = record.toArray();
            manageEmpPage.getEmployeeTableModel().addRow(recordArray);
        }
    }


    private void updateProfileFields(int selectedRow) {
        final DefaultTableModel model = (DefaultTableModel) manageEmpPage.getEmployeeTable().getModel();

        profileMngPage.empIDTxtField().setText(String.valueOf(model.getValueAt(selectedRow, 0)));
        profileMngPage.lastNameTxtField().setText(String.valueOf(model.getValueAt(selectedRow, 1)));
        profileMngPage.firstNameTxtField().setText(String.valueOf(model.getValueAt(selectedRow, 2)));
        profileMngPage.birthdayTxtField().setText(String.valueOf(model.getValueAt(selectedRow, 3)));
        profileMngPage.addressTxtField().setText(String.valueOf(model.getValueAt(selectedRow, 4)));
        profileMngPage.phoneNoTxtField().setText(String.valueOf(model.getValueAt(selectedRow, 5)));

        profileMngPage.sssNoTextField().setText(String.valueOf(model.getValueAt(selectedRow, 6)));
        profileMngPage.philHealthNoTxtField().setText(String.valueOf(model.getValueAt(selectedRow, 7)));
        profileMngPage.pagibigNoTxtArea().setText(String.valueOf(model.getValueAt(selectedRow, 8)));
        profileMngPage.tinNoTxtField().setText(String.valueOf(model.getValueAt(selectedRow, 9)));

        profileMngPage.departmentTxtField().setText(String.valueOf(model.getValueAt(selectedRow, 10)));
        profileMngPage.positionTxtField().setText(String.valueOf(model.getValueAt(selectedRow, 11)));
        profileMngPage.supervisorTxtField().setText(String.valueOf(model.getValueAt(selectedRow, 12)));
        profileMngPage.statusTxtField().setText(String.valueOf(model.getValueAt(selectedRow, 13)));

        profileMngPage.basicSalaryTxtField().setText(String.valueOf(model.getValueAt(selectedRow, 14)));
        profileMngPage.riceSubsidyTxtField().setText(String.valueOf(model.getValueAt(selectedRow, 15)));
        profileMngPage.phoneAllowanceTxtField().setText(String.valueOf(model.getValueAt(selectedRow, 16)));
        profileMngPage.clothingAllowanceTxtField().setText(String.valueOf(model.getValueAt(selectedRow, 17)));
        profileMngPage.semiMonthlyTxtField().setText(String.valueOf(model.getValueAt(selectedRow, 18)));
        profileMngPage.hourlyRateTxtField().setText(String.valueOf(model.getValueAt(selectedRow, 19)));
    }

    private void clearProfileFields() {
        profileMngPage.empIDTxtField().setText("");
        profileMngPage.lastNameTxtField().setText("");
        profileMngPage.firstNameTxtField().setText("");
        profileMngPage.birthdayTxtField().setText("");
        profileMngPage.addressTxtField().setText("");
        profileMngPage.phoneNoTxtField().setText("");
        profileMngPage.sssNoTextField().setText("");
        profileMngPage.philHealthNoTxtField().setText("");
        profileMngPage.pagibigNoTxtArea().setText("");
        profileMngPage.tinNoTxtField().setText("");
        profileMngPage.departmentTxtField().setText("");
        profileMngPage.positionTxtField().setText("");
        profileMngPage.supervisorTxtField().setText("");
        profileMngPage.statusTxtField().setText("");
        profileMngPage.basicSalaryTxtField().setText("");
        profileMngPage.riceSubsidyTxtField().setText("");
        profileMngPage.phoneAllowanceTxtField().setText("");
        profileMngPage.clothingAllowanceTxtField().setText("");
        profileMngPage.semiMonthlyTxtField().setText("");
        profileMngPage.hourlyRateTxtField().setText("");
    }

    private void tableListener() {
        manageEmpPage.getEmployeeTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = manageEmpPage.getEmployeeTable().getSelectedRow();

                if (selectedRow == -1) {
                    return;
                }

                updateProfileFields(selectedRow);

                manageEmpPage.getUpdateEmpBTN().setEnabled(true);
                manageEmpPage.getTerminateEmpBTN().setEnabled(true);
            }
        });
    }

    private EmployeeRecord getSelectedEmployee() throws EmployeeRecordsException {
        JTable table = manageEmpPage.getEmployeeTable();
        int selectedRow = table.getSelectedRow();

        if (selectedRow == -1) {
            return null;
        }

        List<EmployeeRecord> employeeList = hrAdmin.getEmployeeList();

        if (employeeList.isEmpty()) {
            EmployeeRecordsException.throwError_NO_RECORD_FOUND();
            return null;
        }

        for (EmployeeRecord employeeRecord : employeeList) {
            if (employeeRecord.employeeID() == Integer.parseInt(table.getValueAt(selectedRow, 0).toString())) {
                return employeeRecord;
            }
        }

        return null;
    }

    private EmployeeRecord getEmployeeRecord(Action action) throws EmployeeRecordsException {
        String employeeID = profileMngPage.empIDTxtField().getText();
        String lastName = profileMngPage.lastNameTxtField().getText();
        String firstName = profileMngPage.firstNameTxtField().getText();
        String birthday = profileMngPage.birthdayTxtField().getText();
        String phoneNum = profileMngPage.phoneNoTxtField().getText();
        String address = profileMngPage.addressTxtField().getText();
        String department = profileMngPage.departmentTxtField().getText();
        String position = profileMngPage.positionTxtField().getText();
        String supervisor = profileMngPage.supervisorTxtField().getText();
        String status = profileMngPage.statusTxtField().getText();
        String sssNum = profileMngPage.sssNoTextField().getText();
        String philHealthNum = profileMngPage.philHealthNoTxtField().getText();
        String pagIbigNum = profileMngPage.pagibigNoTxtArea().getText();
        String tinNum = profileMngPage.tinNoTxtField().getText();
        String basicSalary = profileMngPage.basicSalaryTxtField().getText();
        String riceSubsidy = profileMngPage.riceSubsidyTxtField().getText();
        String phoneAllowance = profileMngPage.phoneAllowanceTxtField().getText();
        String clothingAllowance = profileMngPage.clothingAllowanceTxtField().getText();
        String gSMR = profileMngPage.semiMonthlyTxtField().getText();
        String hourlyRate = profileMngPage.hourlyRateTxtField().getText();

        if (employeeID.isEmpty() || lastName.isEmpty() || firstName.isEmpty() || birthday.isEmpty() || phoneNum.isEmpty()
                || address.isEmpty() || department.isEmpty() || position.isEmpty() || supervisor.isEmpty()
                || status.isEmpty() || sssNum.isEmpty() || philHealthNum.isEmpty() || pagIbigNum.isEmpty()
                || tinNum.isEmpty() || basicSalary.isEmpty() || riceSubsidy.isEmpty() || phoneAllowance.isEmpty()
                || clothingAllowance.isEmpty() || gSMR.isEmpty() || hourlyRate.isEmpty()) {
            EmployeeRecordsException.throwError_EMPTY_FIELD();
            return null;
        }

        if (Action.ADD == action) {
            if (hrAdmin.getEmployeeIDList().contains(Integer.parseInt(employeeID))) {
                EmployeeRecordsException.throwError_DUPLICATE_RECORD();
                return null;
            }
        }

        if (Action.UPDATE == action) {
            if (!hrAdmin.getEmployeeIDList().contains(Integer.parseInt(employeeID))) {
                EmployeeRecordsException.throwError_NO_RECORD_FOUND();
                return null;
            }
        }


        return new EmployeeRecord(
                Integer.parseInt(employeeID),
                lastName,
                firstName,
                birthday,
                phoneNum,
                address,
                sssNum,
                philHealthNum,
                pagIbigNum,
                tinNum,
                department,
                position,
                supervisor,
                status,
                Convert.StringToDouble(riceSubsidy),
                Convert.StringToDouble(phoneAllowance),
                Convert.StringToDouble(clothingAllowance),
                Convert.StringToDouble(basicSalary),
                Convert.StringToDouble(gSMR),
                Convert.StringToDouble(hourlyRate));
    }

    @Override
    protected void resetPanelVisibility() {
        super.resetPanelVisibility();
        manageEmpPage.setVisible(false);
        profileMngPage.setVisible(false);
        leaveInfoFrame.setVisible(false);
        attendanceReportPage.setVisible(false);
    }
}
