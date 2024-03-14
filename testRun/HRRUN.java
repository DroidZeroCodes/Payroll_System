import ui.hr.HRAdminUI;
import service.FileDataService;
import users.actions.HRAdminViewHandler;
import users.roles.HRAdmin;

public class HRRUN {
    public static void main(String[] args) {
        HRAdmin hrAdmin = new HRAdmin(new FileDataService(), 1);
        HRAdminUI hrAdminUI = new HRAdminUI();
        new HRAdminViewHandler(hrAdmin, hrAdminUI);

        hrAdminUI.setVisible(true);

        hrAdminUI.getLogoutBtn().addActionListener(e -> {
            hrAdminUI.dispose();
            main(null);
        });
    }

}
