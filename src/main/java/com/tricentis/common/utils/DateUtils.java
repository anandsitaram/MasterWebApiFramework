package com.tricentis.common.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public final class DateUtils {

    private DateUtils() {

    }

    public static String getDefaultDateTime() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss a");

        return formatter.format(dateTime);
    }

    public static String getDateTime() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy hh:mm:ss a");

        return formatter.format(dateTime);
    }

    public static String getFormattedDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss a");

        return formatter.format(date);
    }

    public static String getCurrentDatePlusOneMonth() {
        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Add one month to the current date
        LocalDate nextMonthDate = currentDate.plusMonths(1).plusDays(4);

        // Format the date (optional)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        return nextMonthDate.format(formatter);
    }
}
