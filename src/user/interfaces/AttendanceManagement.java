package user.interfaces;

import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;

public interface AttendanceManagement {
    void clockIn() throws CsvValidationException, IOException;
    void clockOut();
    void displayAttendanceRecord();
}