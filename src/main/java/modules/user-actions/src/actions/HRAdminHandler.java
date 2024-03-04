package actions;

import data.AttendanceRecord;
import data.EmployeeRecord;
import data.LeaveRecord;
import exceptions.AttendanceException;
import exceptions.EmployeeRecordsException;
import exceptions.LeaveException;
import ui.hr.HRAdminUI;
import ui.hr.ManageEmpPanel;
import ui.hr.ProfileManagementPanel;
import user.HRAdmin;
import util.Convert;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;


public class HRAdminHandler extends EmployeeHandler {
    private final HRAdmin hrAdmin;
    private final HRAdminUI hrAdminUI;
    protected ManageEmpPanel manageEmpPage;
    protected JButton manageEmpBTN;
    protected ProfileManagementPanel profileMngPage;
    boolean isEmployeeListsColumnsRemoved = false;

    public HRAdminHandler(HRAdmin hrAdmin, HRAdminUI hrAdminUI) {
        super(hrAdmin, null);
        this.hrAdmin = hrAdmin;
        this.hrAdminUI = hrAdminUI;
        this.generalComponents = hrAdminUI;
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
    }

    @Override
    protected void initActions() {
        super.initActions();
        manageEmpBTN.addActionListener(e -> showManageEmpPage());

        //Manage Employee Panel
        manageEmpPage.getAddEmpBTN().addActionListener(e -> {
            clearProfileFields();
            showAddNewProfile();
        });

        manageEmpPage.getUpdateEmpBTN().addActionListener(e -> {
            showUpdateProfile();
        });

        manageEmpPage.getTerminateEmpBTN().addActionListener(e -> {
            try {
                hrAdmin.terminateEmployee(getSelectedEmployee());
            } catch (EmployeeRecordsException ex) {
                System.err.println("Error: " + ex.getMessage());
            }

            JOptionPane.showMessageDialog(null, "Employee Terminated Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            showManageEmpPage();
        });

        manageEmpPage.getSearchBTN().addActionListener(e -> showFilteredEmployeeTable());

        //Profile Management Panel
        profileMngPage.saveBTN().addActionListener(e -> {
            if (profileMngPage.saveBTN().getText().equals("Save")) {
                try {
                    hrAdmin.addEmployee(getEmployeeRecord());

                    JOptionPane.showMessageDialog(null, "Employee Added Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);

                } catch (EmployeeRecordsException ex) {
                    System.err.println("Error: " + ex.getMessage());
                }
            } else if (profileMngPage.saveBTN().getText().equals("Update")) {
                try {
                    hrAdmin.updateEmployee(getEmployeeRecord());

                    JOptionPane.showMessageDialog(null, "Employee Added Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                } catch (EmployeeRecordsException ex) {
                    System.err.println("Error: " + ex.getMessage());
                }
            }
        });

        tableListener();
    }

    @Override
    protected void resetPanelVisibility() {
        super.resetPanelVisibility();
        manageEmpPage.setVisible(false);
        profileMngPage.setVisible(false);
    }

    /**
     *
     */
    @Override
    public void displayAttendanceRecord() throws AttendanceException {
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
    }

    @Override
    public void displayLeaveHistory() throws LeaveException {
        List<LeaveRecord> allLeaveHistory = hrAdmin.getAllLeaveHistory();

        // Clear existing rows from the table model
        leavePage.leaveHistoryModel().setRowCount(0);

        if (allLeaveHistory.isEmpty()) {
            LeaveException.throwError_NO_RECORD_FOUND();
            return;
        }

        for (LeaveRecord record : allLeaveHistory) {
            String[] recordArray = record.toArray();
            leavePage.leaveHistoryModel().addRow(recordArray);
        }

        attendancePage.getAttendanceTable().getColumnModel().getColumn(2).setCellRenderer(dateRenderer);
        attendancePage.getAttendanceTable().getColumnModel().getColumn(4).setCellRenderer(dateRenderer);
        attendancePage.getAttendanceTable().getColumnModel().getColumn(5).setCellRenderer(dateRenderer);

    }

    private void showManageEmpPage() {
        resetPanelVisibility();
        manageEmpPage.setVisible(true);
        try {
            displayEmployeeList();
        } catch (EmployeeRecordsException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private void clearProfileFields() {
        profileMngPage.empIDTxtField().setText("");
        profileMngPage.lastNameTxtField().setText("");
        profileMngPage.firstNameTxtField().setText("");
        profileMngPage.birthdayTxtField().setText("");
        profileMngPage.addressTxtArea().setText("");
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

    private void showAddNewProfile() {
        profileMngPage.saveBTN().setText("Save");
        profileMngPage.empIDTxtField().setEditable(false);
        profileMngPage.empIDTxtField().setText(hrAdmin.getNewEmployeeID());
        resetPanelVisibility();
        profileMngPage.setVisible(true);
    }

    private void showUpdateProfile() {
        profileMngPage.saveBTN().setText("Update");
        manageEmpPage.setVisible(false);
        profileMngPage.setVisible(true);
        manageEmpPage.getUpdateEmpBTN().setEnabled(false);
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

    private void showFilteredEmployeeTable() {
        String empID = manageEmpPage.getSearchField().getText();
        if (empID.isEmpty()) {
            manageEmpPage.getEmployeeTableSorter().setRowFilter(null);
        } else {
            try {
                manageEmpPage.getEmployeeTableSorter().setRowFilter(RowFilter.regexFilter(empID, 0));
                // Check if any records match the filter
                if (attendancePage.getAttendanceTable().getRowCount() == 0) {
                    // Show message indicating no records found
                    EmployeeRecordsException.throwError_NO_RECORD_FOUND();
                }
            } catch (IllegalArgumentException | EmployeeRecordsException ex) {
                // If the entered empID is invalid or the regex filter fails, just ignore and clear the filter
                manageEmpPage.getEmployeeTableSorter().setRowFilter(null);
            }
        }
    }

    private EmployeeRecord getEmployeeRecord() {
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

        return new EmployeeRecord(
                Integer.parseInt(employeeID),
                lastName,
                firstName,
                birthday,
                phoneNum,
                address,
                sssNum,
                philHealthNum,
                pagibigNum,
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

    public void tableListener() {
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

    public void displayEmployeeList() throws EmployeeRecordsException {
        List<EmployeeRecord> allEmployees = hrAdmin.getEmployeeList();

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
        profileMngPage.addressTxtArea().setText(String.valueOf(model.getValueAt(selectedRow, 4)));
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
}
