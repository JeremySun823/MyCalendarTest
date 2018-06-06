package com.example.jeremysun.calendar;

import android.text.TextUtils;
import android.util.Log;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by jeremysun on 2018/5/30.
 */

public class DateUtils {
    private static final String TAG = "DateUtils";

    /**
     * 把时间字符串转成date
     *
     * @param time
     * @return
     */
    public static Date stringToDate(String time) {
        Calendar instance = Calendar.getInstance();
        try {
            if (!TextUtils.isEmpty(time)) {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                ParsePosition pos = new ParsePosition(0);
                Date parse = formatter.parse(time, pos);
                instance.setTime(parse);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.d(TAG, "stringToDate exception : " + e);

        }
        return instance.getTime();
    }


    /**
     * 获取对应的月份天数
     *
     * @param date
     * @return
     */
    public static int getDaysByYearMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, 1);
        // roll，当月循环，跳转到当月最后一天
        calendar.roll(Calendar.DATE, -1);
        // 获取当月天数
        int maxDate = calendar.get(Calendar.DATE);
        return maxDate;
    }

    /**
     * 获取对应月份第1天的星期
     *
     * @param date
     * @return 0：周日，1：周一
     */
    public static int getWeekOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        // 设置日期为1号
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        // 获取星期几，0：周日
        int week = (calendar.get(Calendar.DAY_OF_WEEK) - 1);
        return week;
    }
}
