package com.example.jeremysun.calendar2.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jeremysun.R;
import com.example.jeremysun.calendar2.DateUtils;
import com.example.jeremysun.calendar2.view.MonthView;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by jeremysun on 2018/5/31.
 */

public class CalendarRecyclerAdapter extends RecyclerView.Adapter<CalendarRecyclerAdapter.CalendarViewHolder> {

    // 选中的日期，2018-05-31
    private String mChooseDate;

    private int startYear;
    private int startMonth;

    private int endYear;
    private int endMonth;

    private int months;


    public CalendarRecyclerAdapter(String chooseDate, int type) {
        mChooseDate = chooseDate;

        Date today = new Date();
        startYear = DateUtils.getYear(today);
        startMonth = DateUtils.getMonth(today);

        Log.d("sunwillfly", "CalendarRecyclerAdapter startYear =  " + startYear + ", startMonth = " + startMonth);


        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        // 机票+12个月
        if (type == 0) {
            calendar.add(Calendar.MONTH, 12);
        }
        // 火车票+30天
        else if (type == 1) {
            calendar.add(Calendar.DAY_OF_MONTH, 30);
        }

        endYear = calendar.get(Calendar.YEAR);
        endMonth = calendar.get(Calendar.MONTH) + 1;

        Log.d("sunwillfly", "CalendarRecyclerAdapter endYear =  " + endYear + ", endMonth = " + endMonth);


        // 同年
        if (startYear == endYear) {
            months = (endMonth - startMonth + 1);
        }
        // 跨年
        else if ((startYear + 1) == endYear) {
            months = (endMonth + 12 - startMonth);
        }

        Log.d("sunwillfly", "CalendarRecyclerAdapter months =  " + months);
    }

    @Override
    public CalendarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d("sunwillfly","onCreateViewHolder");

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_week_and_month, parent, false);
        CalendarViewHolder holder = new CalendarViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(CalendarViewHolder holder, int position) {
        Log.d("sunwillfly","onBindViewHolder position = " + position);
        int month = startMonth + position;
        int year = startYear;
        if (month > 12) {
            month = month % 12;
            year++;
        }

        int week = DateUtils.getFirstWeekOfMonth(year, month);
        int days = DateUtils.getMonthDays(year, month);

        Log.d("sunwillfly","onBindViewHolder week = " + week + ", days = " + days);

        holder.monthView.setDateList(week, days);
        holder.mTvWeek.setText(year + "-" + month);
    }

    @Override
    public int getItemCount() {
        // Todo, type train 1~3, flight 12
        return months;
    }

    public static class CalendarViewHolder extends RecyclerView.ViewHolder {
        private TextView mTvWeek;
        private MonthView monthView;

        public CalendarViewHolder(View itemView) {
            super(itemView);
            mTvWeek = itemView.findViewById(R.id.tv_week);
            monthView = itemView.findViewById(R.id.monthView);
        }
    }
}
