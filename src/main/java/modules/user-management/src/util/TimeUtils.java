package util;

import data.AttendanceRecord;
import interfaces.AttendanceDataService;
import service.FileDataService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Year;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class TimeUtils {
    private static final AttendanceDataService attendanceDataService = new FileDataService();
    private static final LocalDate startDate = LocalDate.of(2022, 3, 1).minusMonths(1).with(TemporalAdjusters.firstDayOfMonth());
    private static final LocalDate endDate = startDate.with(TemporalAdjusters.lastDayOfMonth());
    // Method to check if dates overlap
    public static LocalDate getCurrentPeriod_StartDate(){
        return startDate;
    }
    public static LocalDate getCurrentPeriod_EndDate(){
        return endDate;
    }

    public static Year getCurrentPeriod_Year(){
        return Year.from(startDate);
    }
    public static int getCurrentPeriod_Month(){
        return Month.from(startDate).getValue();
    }

    public static boolean datesOverlap(LocalDate startDate1, LocalDate endDate1, LocalDate startDate2, LocalDate endDate2) {
        return !endDate1.isBefore(startDate2) && !startDate1.isAfter(endDate2);
    }

    public static Double retrieveHoursTotalWorked(LocalDate startDate, LocalDate endDate) {
        List<AttendanceRecord> attendanceRecord = attendanceDataService.getAllAttendanceRecords();
        if (attendanceRecord == null || attendanceRecord.isEmpty()) {
            return 0.0;
        }

        List <String[]> filteredRecords = new ArrayList<>();

        for (AttendanceRecord record : attendanceRecord) {
            String[] row = (String[]) record.toArray();
            LocalDate recordDate = Convert.StringToLocalDate(row[1]);
            if ((recordDate.isEqual(startDate) || recordDate.isEqual(endDate))
                    || (recordDate.isAfter(startDate) && recordDate.isBefore(endDate))) {
                filteredRecords.add(row);
            }
        }

        double totalHoursWorked = 0.0;
        for (String[] row : filteredRecords) {
            LocalTime hoursWorked_temp = Convert.StringToLocalTime(row[7]);;
            totalHoursWorked += hoursWorked_temp.getHour() + (hoursWorked_temp.getMinute() / 60.0);
        }
        return totalHoursWorked;
    }

    public static Double retrieveOvertimeHours(LocalDate startDate, LocalDate endDate) {
        List<AttendanceRecord> attendanceRecord = attendanceDataService.getAllAttendanceRecords();
        if (attendanceRecord == null || attendanceRecord.isEmpty()) {
            return 0.0;
        }

        List <String[]> filteredRecords = new ArrayList<>();

        for (AttendanceRecord record: attendanceRecord) {
            String[] row = (String[]) record.toArray();
            LocalDate recordDate = Convert.StringToLocalDate(row[1]);
            if ((recordDate.isEqual(startDate) || recordDate.isEqual(endDate))
                    || (recordDate.isAfter(startDate) && recordDate.isBefore(endDate))) {
                filteredRecords.add(row);
            }
        }

        double overtimeHours = 0.0;
        for (String[] row : filteredRecords) {
            LocalTime overtimeHours_Temp = Convert.StringToLocalTime(row[8]);;
            overtimeHours += overtimeHours_Temp.getHour() + (overtimeHours_Temp.getMinute() / 60.0);
        }
        return overtimeHours;
    }
}
