package com.company.utils;

import java.util.Date;

public class DateUtils {
    public static long timeDifferenceInHours(Date date1, Date date2){
        return (date1.getTime() -date2.getTime())/3600000;
    }
}
