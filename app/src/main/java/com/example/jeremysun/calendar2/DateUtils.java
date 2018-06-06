package com.example.jeremysun.calendar2;

import android.util.Log;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by jeremysun on 2018/5/31.
 */

public class DateUtils {


    /**
     * 根据时间字符串，获取年
     *
     * @param date 2018-05-31
     * @return
     */
    public static int getYear(String date) {
        String[] array = date.split("-");
        int year = 0;
        try {
            year = Integer.parseInt(array[0]);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return year;
    }

    /**
     * 根据时间，获取年
     *
     * @param date
     * @return
     */
    public static int getYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 根据时间字符串，获取月
     *
     * @param date 2018-05-31
     * @return
     */
    public static int getMonth(String date) {
        String[] array = date.split("-");
        int month = 0;
        try {
            month = Integer.parseInt(array[0]);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return month;
    }

    /**
     * 根据时间，获取月
     *
     * @param date
     * @return
     */
    public static int getMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }


    /**
     * 根据时间字符串，获取日
     *
     * @param date 2018-05-31
     * @return
     */
    public static int getDay(String date) {
        String[] array = date.split("-");
        int day = 0;
        try {
            day = Integer.parseInt(array[0]);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return day;
    }

    /**
     * 根据时间，获取日
     *
     * @param date
     * @return
     */
    public static int getDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }


    /**
     * 计算指定月份的天数
     *
     * @param year
     * @param month
     * @return
     */
    public static int getMonthDays(int year, int month) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                return -1;
        }
    }


    /**
     * 计算当月1号是周几
     *
     * @param year
     * @param month
     * @return
     */
    public static int getFirstWeekOfMonth(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        //注意,Calendar对象默认一月为0,因此将month-1
        calendar.set(year, month - 1, 1);
        return calendar.get(Calendar.DAY_OF_WEEK) - 1;
    }
}
