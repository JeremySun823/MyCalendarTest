package com.example.jeremysun.calendar2.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;

import com.example.jeremysun.calendar2.adapter.CalendarRecyclerAdapter;

/**
 * Created by jeremysun on 2018/5/31.
 */

public class CalendarView extends RecyclerView {

    private CalendarRecyclerAdapter mAdapter;
    private Context mContext;

    // 选中的日期，2018-05-31
    private String chooseDate;

    // 机票 0、火车票 1
    private int type;


    public CalendarView(Context context) {
        super(context);
        mContext = context;
        initView();
    }

    public CalendarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView();
    }

    public CalendarView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
        initView();
    }

    private void initView() {
//        mAdapter = new CalendarRecyclerAdapter(chooseDate, type);

        mAdapter = new CalendarRecyclerAdapter(chooseDate, 0);
        setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        setAdapter(mAdapter);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);

        Log.d("sunwillfly","CalendarView onMeasure widthSpecSize = " + widthSpecSize);
        Log.d("sunwillfly","CalendarView onMeasure heightSpecSize = " + heightSpecSize);


//        int calendarHeight;
//        if (getAdapter() != null) {
//            MonthView view = (MonthView) getChildAt(0);
//            if (view != null) {
//                calendarHeight = view.getMeasuredHeight();
//                setMeasuredDimension(widthMeasureSpec, MeasureSpec.makeMeasureSpec(calendarHeight, MeasureSpec.EXACTLY));
//            }
//        }

    }
}
