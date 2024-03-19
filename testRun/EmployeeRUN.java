import data.service.FileDataService;
import ui.employee.EmployeeUI;
import user.actions.EmployeeViewHandler;
import user.roles.Employee;

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
