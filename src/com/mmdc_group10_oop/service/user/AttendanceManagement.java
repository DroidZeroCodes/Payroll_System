package com.mmdc_group10_oop.service.user;

import javax.swing.*;

public interface AttendanceManagement {
    void clockIn();
    void clockOut();
    void viewAttendanceRecord(JTable table);
}
