import data.service.FileDataService;
import ui.hr.HRAdminUI;
import user.actions.HRAdminViewHandler;
import user.roles.HRAdmin;


public class HRRUN {
    public static void main(String[] args) {
        HRAdmin hrAdmin = new HRAdmin(new FileDataService(), 6);
        HRAdminUI hrAdminUI = new HRAdminUI();
        new HRAdminViewHandler(hrAdmin, hrAdminUI);

        hrAdminUI.setVisible(true);

        hrAdminUI.getLogoutBtn().addActionListener(e -> {
            hrAdminUI.dispose();
            main(null);
        });
    }

}
