package testRun;

import actions.EmployeeViewHandler;
import roles.Employee;
import service.FileDataService;
import ui.employee.EmployeeUI;

public class EmployeeRUN {
    public static void main(String[] args) {
        FileDataService dataService = new FileDataService();

        Employee employee = new Employee(dataService, 1);
        EmployeeUI employeeUI = new EmployeeUI();
        new EmployeeViewHandler(employee, employeeUI);

        employeeUI.setVisible(true);

        employeeUI.getLogoutBtn().addActionListener(e -> {
            employeeUI.dispose();
            main(null);
        });
    }
}
