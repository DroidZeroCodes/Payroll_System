package testRun;

import actions.PayrollAdminHandler;
import roles.PayrollAdmin;
import service.FileDataService;
import ui.payroll.PayrollAdminUI;

public class PayrollRUN {
    public static void main(String[] args) {
        FileDataService dataService = new FileDataService();

        PayrollAdmin employee = new PayrollAdmin(dataService, 1);
        PayrollAdminUI employeeUI = new PayrollAdminUI();
        new PayrollAdminHandler(employee, employeeUI);

        employeeUI.setVisible(true);

        employeeUI.getLogoutBtn().addActionListener(e -> {
            employeeUI.dispose();
            main(null);
        });
    }
}
