package com.mmdc_group10_oop.dataHandlingModule.util;

import com.mmdc_group10_oop.dataHandlingModule.*;

public class Query {
    /**
     * Returns the file path for the corresponding class.
     *
     * @return the file path for the class
     */
    public String filePath() {
        // TODO: Create data for each file
        String database = "src/com/mmdc_group10_oop/dataHandlingModule/database/";
        if ( getClass() == EmployeeRecord.class) {
            return database + "EmployeeData.csv";
        } else if (getClass() == AttendanceRecord.class) {
            return database + "AttendanceData.csv";
        } else if (getClass() == LeaveRecord.class) {
            return database + "LeaveData.csv";
        } else if (getClass() == LeaveBalance.class) {
            return database + "LeaveBalance.csv";
        } else if (getClass() == PayrollRecords.class) {
            return database + "PayslipRecords.csv";
        } else if (getClass() == UserCredentials.class) {
            return database + "UserCredentials.csv";
        }
        throw new IllegalArgumentException("Invalid class: " + getClass().getName());
    }

    /**
     * Returns the primary key for the given class.
     *
     * @return the primary key
     */
    public String primaryKey() {
        if (getClass() == EmployeeRecord.class || getClass() == AttendanceRecord.class) {
            return "Employee No";
        } else if (getClass() == UserCredentials.class) {
            return "Username";
        } else if (getClass() == PayrollRecords.class) {
            return "EMPLOYEE ID";
        }
        throw new IllegalArgumentException("Invalid class: " + getClass().getName());
    }
}
