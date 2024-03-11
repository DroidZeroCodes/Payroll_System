package testRun;

import actions.HRAdminHandler;
import service.FileDataService;
import ui.hr.HRAdminUI;
import users.HRAdmin;

public class HRRUN {
    public static void main(String[] args) {
        FileDataService dataService = new FileDataService();

        HRAdmin hrAdmin = new HRAdmin(dataService, 1);
        HRAdminUI hrAdminUI = new HRAdminUI();
        new HRAdminHandler(hrAdmin, hrAdminUI);

        hrAdminUI.setVisible(true);

        hrAdminUI.getLogoutBtn().addActionListener(e -> {
            hrAdminUI.dispose();
            main(null);
        });
    }

}
