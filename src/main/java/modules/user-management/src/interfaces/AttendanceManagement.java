package interfaces;

import exceptions.AttendanceException;

public interface AttendanceManagement {
    void clockIn();
    void clockOut() throws AttendanceException;
}
