package interfaces;

import util.ErrorMessages;

public interface AttendanceManagement {
    void clockIn() throws ErrorMessages.AttendanceException;
    void clockOut();
}
