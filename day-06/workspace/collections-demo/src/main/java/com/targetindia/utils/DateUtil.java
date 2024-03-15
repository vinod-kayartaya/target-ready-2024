package com.targetindia.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateUtil {

    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");

    private DateUtil() {
    }

    public static String toString(Date date) {
        // return date in yyyy-mm-dd
        return SDF.format(date);
    }

    public static Date toDate(String date) {
        try {
            return SDF.parse(date);
        } catch (Exception e) {
            return null;
        }
    }
}
