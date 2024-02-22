package com.mmdc_group10_oop.service.actions.interfaces;

import com.opencsv.exceptions.CsvValidationException;

import javax.swing.*;
import java.io.IOException;

public interface AttendanceManagement {
    void clockIn() throws CsvValidationException, IOException;
    void clockOut();
    void displayAttendanceRecord();
}
