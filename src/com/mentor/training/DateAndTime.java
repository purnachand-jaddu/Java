package com.mentor.training;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAndTime {
    public static void getTimeNow()
    {
        Date date=new Date();
        SimpleDateFormat myFormat=new SimpleDateFormat("yyyy/MM/dd");
        System.out.println(myFormat.format(date));
    }
}
