package interfaces;

import exceptions.AttendanceException;

public interface AttendanceManagement {
    void clockIn() throws AttendanceException;
    void clockOut() throws AttendanceException;
}
