package testRun;

import actions.EmployeeHandler;
import service.FileDataService;
import ui.employee.EmployeeUI;
import user.Employee;

public class EmployeeRUN {
    public static void main(String[] args) {
        FileDataService dataService = new FileDataService();

        Employee employee = new Employee(dataService,1);
        EmployeeUI employeeUI = new EmployeeUI();
        new EmployeeHandler(employee, employeeUI);

        employeeUI.setVisible(true);

        employeeUI.getLogoutBtn().addActionListener(e -> {
            employeeUI.dispose();
            main(null);
        });
    }
}
