import frontend.ui.employee.EmployeeUI;
import service.FileDataService;
import users.actions.EmployeeViewHandler;
import users.roles.Employee;

public class EmployeeRUN {
    public static void main(String[] args) {
        Employee employee = new Employee(new FileDataService(), 1);
        EmployeeUI employeeUI = new EmployeeUI();
        new EmployeeViewHandler(employee, employeeUI);

        employeeUI.setVisible(true);

        employeeUI.getLogoutBtn().addActionListener(e -> {
            employeeUI.dispose();
            main(null);
        });
    }
}
