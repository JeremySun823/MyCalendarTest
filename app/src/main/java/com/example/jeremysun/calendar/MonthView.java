package com.example.jeremysun.calendar;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jeremysun.R;

import java.util.Date;

/**
 * Created by jeremysun on 2018/5/30.
 */

public class MonthView extends LinearLayout implements View.OnClickListener {

    private Context mContext;
    private TextView mTvMonth;
    private GridLayout mGridLayoutMonth;

    public MonthView(Context context) {
        super(context);
    }

    public MonthView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        LayoutInflater.from(context).inflate(R.layout.item_month, this);
        initView();
    }

    public MonthView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initView() {
        mTvMonth = findViewById(R.id.tv_month);
        mGridLayoutMonth = findViewById(R.id.gridLayout_month);

        mGridLayoutMonth.setOnClickListener(this);
    }

    /**
     * @param dateString 2018-05-31
     */
    public void setDate(String dateString) {
        // 转换成date
        Date date = DateUtils.stringToDate(dateString);

        mTvMonth.setText(dateString);

        int week = DateUtils.getWeekOfMonth(date);
        int days = DateUtils.getDaysByYearMonth(date);


        int day = 1;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                TextView textView = new TextView(mContext);
                int count = i * 7 + j;

                if (count >= week) {
                    textView.setText(day + "");
                    day++;
                } else {
                    textView.setText("");
                }

                if (count < (days + week)) {
                    GridLayout.LayoutParams mLayoutParams = new GridLayout.LayoutParams();
                    mLayoutParams.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1, 1.0f);
                    mLayoutParams.rowSpec = GridLayout.spec(GridLayout.UNDEFINED, 1, 1.0f);
                    mLayoutParams.setGravity(Gravity.CENTER);

                    mGridLayoutMonth.addView(textView, mLayoutParams);
                }
            }
        }

    }

    @Override
    public void onClick(View view) {
        TextView textView = (TextView) view;
        GridLayout.LayoutParams params = (GridLayout.LayoutParams)textView.getLayoutParams();
        GridLayout.Spec spec = params.rowSpec;


    }
}
