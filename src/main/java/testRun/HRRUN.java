package testRun;

import service.FileDataService;
import actions.HRAdminHandler;
import ui.hr.HRAdminUI;
import user.HRAdmin;

public class HRRUN {
    public static void main(String[] args) {
        FileDataService dataService = new FileDataService();

        HRAdmin hrAdmin = new HRAdmin(dataService,1);
        HRAdminUI hrAdminUI = new HRAdminUI();
        new HRAdminHandler(hrAdmin,hrAdminUI);

        hrAdminUI.setVisible(true);

        hrAdminUI.getLogoutBtn().addActionListener(e -> {
            hrAdminUI.dispose();
            main(null);
        });
    }

}
