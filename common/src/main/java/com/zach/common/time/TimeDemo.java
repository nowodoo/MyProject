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

        //string to Date
        DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        DateTime dateTime1 = DateTime.parse("2012-12-21 23:22:45", format);
        System.out.println(dateTime1);


        //Date to string or some other form
        Date date = new Date();
        DateTime dateTime2 = new DateTime(date);
        String dateTime2String = dateTime2.toString("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateTime2String);


        //calendar to datetime
        Calendar calendar = Calendar.getInstance();
        DateTime dateTime3 = new DateTime(calendar);


        //dateTime to calendar
        DateTime dateTime4 = new DateTime();
        dateTime4.toCalendar(Locale.CHINA);


        //Date to string JDK
        SimpleDateFormat formatDateToStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = formatDateToStr.format(date);
    }
}
