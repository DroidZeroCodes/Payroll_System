package com.mmdc_group10_oop.service.actions.interfaces;

import javax.swing.*;

public interface AttendanceManagement {
    void clockIn();
    void clockOut();
    void displayAttendanceRecord(JTable table);
}
