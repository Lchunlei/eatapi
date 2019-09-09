package com.chunlei.eat.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * @Created by lcl on 2019/9/9 0009
 */
public class DateTool {

    //当前时间加多少天
    public static Date addDay(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }


}
