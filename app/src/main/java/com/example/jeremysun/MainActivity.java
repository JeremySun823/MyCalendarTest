package com.example.jeremysun;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;

import com.example.jeremysun.calendar.MonthView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private List<String> mDatas;
    private TempAdapter mAdapter;


    private GridLayout mGridLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recyclerView);


        initData();


        //设置布局管理器
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new TempAdapter();
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));


//        mGridLayout = findViewById(R.id.gridLayout);
//        int count = 1;
//        for (int i = 0; i < 6; i++) {
//            for (int j = 0; j < 7; j++) {
//                TextView textView = new TextView(this);
//                if (count < 10) {
//                    textView.setText("");
//                } else {
//                    textView.setText(count + "");
//                }
//                count++;
//
//                GridLayout.LayoutParams mLayoutParams = new GridLayout.LayoutParams();
//                mLayoutParams.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1, 1.0f);
//                mLayoutParams.rowSpec = GridLayout.spec(GridLayout.UNDEFINED, 1, 1.0f);
//                mLayoutParams.setGravity(Gravity.CENTER);
//
//                mGridLayout.addView(textView, mLayoutParams);
//            }
//        }

        MonthView monthView = findViewById(R.id.monthView);
        monthView.setDate("2018-02");

    }

    private void initData() {
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++) {
            mDatas.add("" + (char) i);
        }
    }


    class TempAdapter extends RecyclerView.Adapter<TempAdapter.MyViewHolder> {

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                    MainActivity.this).inflate(R.layout.item_temp, parent,
                    false));
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.tv.setText(mDatas.get(position));

        }

        @Override
        public int getItemCount() {
            return mDatas.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {

            TextView tv;

            public MyViewHolder(View view) {
                super(view);
                tv = (TextView) view.findViewById(R.id.tv_temp);
            }
        }
    }
}
