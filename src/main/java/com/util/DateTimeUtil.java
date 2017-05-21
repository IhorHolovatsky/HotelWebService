package com.util;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Ihor on 5/21/2017.
 */
public class DateTimeUtil {

    public static Date getTodayDate(){
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }

}
