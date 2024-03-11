package testRun;

import actions.ITAdminHandler;
import service.FileDataService;
import ui.it.ITAdminUI;
import users.ITAdmin;

public class ITRUN {
    public static void main(String[] args) {
        FileDataService dataService = new FileDataService();

        ITAdmin employee = new ITAdmin(dataService, 1);
        ITAdminUI employeeUI = new ITAdminUI();
        new ITAdminHandler(employee, employeeUI);

        employeeUI.setVisible(true);

        employeeUI.getLogoutBtn().addActionListener(e -> {
            employeeUI.dispose();
            main(null);
        });
    }
}
