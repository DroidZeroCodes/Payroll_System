import data.service.FileDataService;
import ui.it.ITAdminUI;
import user.actions.ITAdminViewHandler;
import user.roles.ITAdmin;

public class ITRUN {
    public static void main(String[] args) {
        FileDataService dataService = new FileDataService();

        ITAdmin employee = new ITAdmin(dataService, 5);
        ITAdminUI employeeUI = new ITAdminUI();
        new ITAdminViewHandler(employee, employeeUI);

        employeeUI.setVisible(true);

        employeeUI.getLogoutBtn().addActionListener(e -> {
            employeeUI.dispose();
            main(null);
        });
    }
}
