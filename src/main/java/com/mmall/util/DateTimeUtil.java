package com.mmall.util;


import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;


import java.util.Date;

public class DateTimeUtil {

    private static final String STANDAND_FORMAT = "yyyy-MM-dd HH:mm:ss";
    //joda-time

    //Str-->Date
    //Date-->Str
    public static Date strToDate(String dateTimeStr, String formatStr) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(formatStr);
        DateTime dateTime = dateTimeFormatter.parseDateTime(dateTimeStr);
        return dateTime.toDate();
    }

    public static String dateToString(Date date,String formatStr){
        if(date == null){
            return StringUtils.EMPTY;
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(formatStr);
    }

    public static Date strToDate(String dateTimeStr) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(STANDAND_FORMAT);
        DateTime dateTime = dateTimeFormatter.parseDateTime(dateTimeStr);
        return dateTime.toDate();
    }

    public static String dateToString(Date date){
        if(date == null){
            return StringUtils.EMPTY;
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(STANDAND_FORMAT);
    }
}
