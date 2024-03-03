package util;

public class ErrorMessages {
    public static void throwLoginError_INCORRECT_USERNAME_OR_PASSWORD() throws SystemLoginException {
        throw new SystemLoginException("Invalid Username or Password");
    }

    public static void throwLoginError_MISSING_USERNAME_OR_PASSWORD() throws SystemLoginException {
        throw new SystemLoginException("Enter Username and Password");
    }

    public static void throwAttendanceError_ALREADY_CLOCKED_IN() throws AttendanceException {
        throw new AttendanceException("You Have Already Timed In");
    }

    public static void throwLeaveError_INVALID_DATE() throws LeaveException {
        throw new LeaveException("Invalid Leave Date");
    }

    public static void throwLeaveError_INVALID_DATE_RANGE() throws LeaveException {
        throw new LeaveException("Start Date cannot be after End Date");
    }

    public static void throwLeaveError_CONFLICTING_DATES() throws LeaveException {
        throw new LeaveException("Conflicting Leave Request Found");
    }

    public static void throwLeaveError_INSUFFICIENT_BALANCE() throws LeaveException {
        throw new LeaveException("Insufficient Leave Balance");
    }

    public static void throwPayrollError_INVALID_DATE() throws PayrollException {
        throw new PayrollException("Invalid Payroll Date");
    }

    public static class SystemLoginException extends Exception {
        public SystemLoginException(String message) {
            super(message);
        }
    }

    public static class AttendanceException extends Exception {
        public AttendanceException(String message) {
            super(message);
        }
    }

    public static class LeaveException extends Exception {
        public LeaveException(String message) {
            super(message);
        }
    }

    public static class PayrollException extends Exception {
        public PayrollException(String message) {
            super(message);
        }
    }
}

