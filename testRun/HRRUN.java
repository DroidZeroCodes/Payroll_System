package testRun;

import actions.HRAdminViewHandler;
import roles.HRAdmin;
import service.FileDataService;
import ui.hr.HRAdminUI;

public class HRRUN {
    public static void main(String[] args) {
        FileDataService dataService = new FileDataService();

        HRAdmin hrAdmin = new HRAdmin(dataService, 1);
        HRAdminUI hrAdminUI = new HRAdminUI();
        new HRAdminViewHandler(hrAdmin, hrAdminUI);

        hrAdminUI.setVisible(true);

        hrAdminUI.getLogoutBtn().addActionListener(e -> {
            hrAdminUI.dispose();
            main(null);
        });
    }

}