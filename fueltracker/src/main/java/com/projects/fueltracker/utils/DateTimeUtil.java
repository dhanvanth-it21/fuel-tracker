package com.projects.fueltracker.utils;
import java.util.Date;


public class DateTimeUtil {

    public static Date millisToIsoDate(long millis) {
        return new Date(millis);
    }

    public static long isoDateToMillis(Date date) {
        return date.getTime();
    }
}
