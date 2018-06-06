package com.example.jeremysun.calendar2.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jeremysun.R;


/**
 * Created by jeremysun on 2018/5/31.
 */

public class MonthView extends ViewGroup {

    private static final int ROW = 6;
    private static final int COLUMN = 7;

    private Context mContext;

    public MonthView(Context context) {
        super(context);
        mContext = context;
        setBackgroundColor(Color.WHITE);
    }

    public MonthView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        setBackgroundColor(Color.WHITE);
    }

    public MonthView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        setBackgroundColor(Color.WHITE);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (getChildCount() == 0) {
            return;
        }

        View childView = getChildAt(0);
        int itemWidth = childView.getMeasuredWidth();
        int itemHeight = childView.getMeasuredHeight();
        //计算列间距
        int dx = (getMeasuredWidth() - itemWidth * COLUMN) / (COLUMN * 2);

        //当显示五行时扩大行间距
        int dy = 0;
        if (getChildCount() == 35) {
            dy = itemHeight / 5;
        }

        Log.d("sunwillfly", "MonthView onLayout getChildCount = " + getChildCount());

        for (int i = 0; i < getChildCount(); i++) {
            View view = getChildAt(i);

            int left = i % COLUMN * itemWidth + ((2 * (i % COLUMN) + 1)) * dx;
            int top = i / COLUMN * (itemHeight + dy);
            int right = left + itemWidth;
            int bottom = top + itemHeight;
            view.layout(left, top, right, bottom);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);

        Log.d("sunwillfly", "MonthView onMeasure widthSpecSize = " + widthSpecSize);
        Log.d("sunwillfly", "MonthView onMeasure heightSpecSize = " + heightSpecSize);


        int itemWidth = widthSpecSize / COLUMN;

        //计算日历的最大高度
        if (heightSpecSize > itemWidth * ROW) {
            heightSpecSize = itemWidth * ROW;
        }

        setMeasuredDimension(widthSpecSize, heightSpecSize);

        int itemHeight = heightSpecSize / ROW;

        int itemSize = Math.min(itemWidth, itemHeight);

        Log.d("sunwillfly", "MonthView onMeasure getChildCount = " + getChildCount());

        for (int i = 0; i < getChildCount(); i++) {
            View childView = getChildAt(i);
            childView.measure(MeasureSpec.makeMeasureSpec(itemSize, MeasureSpec.EXACTLY),
                    MeasureSpec.makeMeasureSpec(itemSize, MeasureSpec.EXACTLY));
        }
    }


    public void setDateList(int week, int monthDays) {
        if (getChildCount() > 0) {
            removeAllViews();
        }

        Log.d("sunwillfly","MonthView setDateList week = " + week + ", monthDays = " + monthDays);
        for (int i = 0; i < (monthDays + week); i++) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_month_2, null);
            TextView textView = view.findViewById(R.id.tv_day);
            if (i < week) {
                textView.setText("");
            } else {
                textView.setText((i - week + 1) + "");
            }
            addView(view, i);
        }
        requestLayout();
    }
}
