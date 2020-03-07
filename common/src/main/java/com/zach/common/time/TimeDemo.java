package com.zach.common.time;


import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TimeDemo {
    public static void main(String[] args) {
        String s = longToStr(1573918840000L);
        System.out.println(s);
    }

    public static DateTime strToDateCommon(Date date) {
        //string to Date
        DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        DateTime dateTime1 = DateTime.parse("2012-12-21 23:22:45", format);
        System.out.println(dateTime1);

        return dateTime1;
    }


    public static String dateToStr(Date date) {
        //Date to string or some other form
        DateTime dateTime2 = new DateTime(date);
        String dateTime2String = dateTime2.toString("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateTime2String);

        return dateTime2String;
    }


    public static DateTime calendarToDate(Date date) {
        //calendar to datetime
        Calendar calendar = Calendar.getInstance();
        DateTime dateTime3 = new DateTime(calendar);

        return dateTime3;
    }


    public static Calendar ToCalendar(Date date) {
        //dateTime to calendar
        DateTime dateTime4 = new DateTime();
        Calendar calendar = dateTime4.toCalendar(Locale.CHINA);

        return calendar;
    }

    public static String ToStrJDK(Date date) {
        //Date to string JDK
        SimpleDateFormat formatDateToStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = formatDateToStr.format(date);

        return str;
    }


    public static String longToStr(Long l) {
        Date date = new Date(l);
        String dateStr = new DateTime(date).toString("yyyy-MM-dd HH:mm:ss");

        return dateStr;
    }
}
