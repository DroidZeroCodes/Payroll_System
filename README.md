# MotorPh Payroll System

## Description

This project is a payroll management system for made for MotorPh. 
It features user management, employee management, attendance and leave management, and payroll management.
This systems version includes various roles and permissions which include: 
- IT Admin, 
- HR Admin, 
- Payroll Admin, and
- Employee.

Note: MotorPh is a fictional company made for the purpose of learning for students in Mapua Malayan Digital College (MMDC).

## Documentation

Refer to the [documentation](https://github.com/DroidZeroCodes/Payroll_System/deployments/github-pages) for more technical information.

## Demo

[Link to Video Demo](https://www.youtube.com/watch?v=yourvideoid)
*Provide a link to a video demo of your application if available.*

## Installation

The application can run on the following platforms:
- Windows
- macOS
- Linux

The following steps are required to install the application:
- Download and install Java 17 LTS or late from [Oracle](https://www.oracle.com/java/technologies/downloads).
- Download the zip file from the [Latest Release](https://github.com/DroidZeroCodes/Payroll_System/releases/tag/v1.0.0).
- Extract the files.
- Open the `mph-payrollsys.jar` file.

## Usage

To use the application, simply run the `mph-payrollsys.jar` file. 

* You will thereby be prompted to login by entering your username and password.
  * Check the files at database/UserCredentials to see the dummy credentials that can be used to login. You can choose the user role you want to login as:
    * IT Admin, 
    * HR Admin, 
    * Payroll Admin, and 
    * Employee.
  * If you want to login as a new user, the _only option currently available_ is to request the IT admin to create an account. 
    * Check the IT Admin section on how to try logging in as an admin and creating you own account.
* Once logged in, the system will determine your role based on you registered account. 
  
### Regular Employee
Once you are logged in as a regular employee, you will be able to view your 
  * personal information, 
  * payslip,
  * attendance, and 
  * leave.

#### Attendance Management
* To view your attendance, you can navigate to the `Attendance` section by clicking the `Attendance button`, then you would be able to see an attendance table showing your historical attendance from newest to oldest.
  * The table supports filtering by searching using the calendar picker above the table.
  * You may also sort the table by clicking on the column headers.
* To clock in and out, you can use the `Clock In` and `Clock Out` buttons below the attendance table.
* Note: Currently, the system does not support editing personal information.

### Payslip
* To view your payslip, you can navigate to the `Payslip` section by clicking the `Payslip button`, then you would be able to see a payslip table showing your newest payslip.
  * You may also view payslips based on the period such as 
    * monthly,
    * weekly,
    * or semi-monthly.
  * You may also search for specific payslips (only for the current year) for specific months by using the dropdown menu at the top of the table.
* You may save your payslip in a `PDF` format by clicking the `Save PDF` button.
* Additionally, you may print your payslip by clicking the `Print` button.
* Note: Currently, the system does not support viewing history of payslips.

### Leave Management
* To view your leave, you can navigate to the `Leave` section by clicking the `Leave button`, then you would be able to see a leave table showing your leave history with their status.
* Meanwhile you would be able to see you current balance of leaves below the table.
  * The system currently has these leave types:
    * Sick,
    * Vacation,
    * Paternal, and
    * Bereavement.
* To submit a leave request, you can follow the following steps:
  * First you must identify the leave type, and ensure that you have sufficient leave balance. 
    * You can change the leave type on the drop-down menu.
  * Next, you must choose the start and end date of your leave by using the calendar.
    * The system would automatically calculate the number of days of your leave.
  * Optionally, you may also add a reason for your leave request.
  * After finalizing your leave request, you should use the `Submit Leave Request` button.

## Payroll Admin
When you login as a payroll administrator, you will be able to see additional buttons on the sidebar to access other features such as:
- Run Payroll, and
- Reports

However, when it comes to information and attendance management, payroll admin has the same permissions as regular employees.

### Payslip
* Similar to the regular employee, you can view your payslip by navigating to the `Payslip` section.
* As with the regular employee, you may also search for specific payslips (only for the current year) for specific months by using the dropdown menu at the top of the table.
* The only difference is that you will be able to view other employee's payslip by using the search bar.

## HR Admin
*

## IT Admin
## Author

This project was developed by:
- [Harvey Dela Flor](https://github.com/DroidZeroCodes) 
- [Ibrahim Desouky Harby](https://github.com/IbraDoesCode)
- [Irish Venice San Jose](https://github.com/irishvenicesj3)
- [Enrialyn Hermosura](https://github.com/EnrialynH)

And supervised by:
- [Armando Sta Cruz III](https://github.com/SirArmie-MMDC)