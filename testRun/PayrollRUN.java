package testRun;

import actions.PayrollAdminViewHandler;
import roles.PayrollAdmin;
import service.FileDataService;
import ui.payroll.PayrollAdminUI;

public class PayrollRUN {
    public static void main(String[] args) {
        FileDataService dataService = new FileDataService();

        PayrollAdmin employee = new PayrollAdmin(dataService, 1);
        PayrollAdminUI employeeUI = new PayrollAdminUI();
        new PayrollAdminViewHandler(employee, employeeUI);

        employeeUI.setVisible(true);

        employeeUI.getLogoutBtn().addActionListener(e -> {
            employeeUI.dispose();
            main(null);
        });
    }
}
