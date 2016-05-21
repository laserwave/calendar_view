package cn.zhikaizhang.calendarviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Calendar;

import cn.zhangzhikai.demo.R;
import cn.zhikaizhang.calendarview.CalendarView;
import cn.zhikaizhang.calendarview.ICalendarView;

public class Demo1 extends Activity{

    private CalendarView calendarView;
    private RelativeLayout runThisMonthRelativeLayout;
    private TextView runThisMonthTextView;
    private ImageView runThisMonthImageView;
    private View separator;

    private boolean calendarViewFold = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mode1);
        calendarView = (CalendarView)findViewById(R.id.calendarView);
        runThisMonthRelativeLayout = (RelativeLayout)findViewById(R.id.run_this_month);
        runThisMonthTextView = (TextView)findViewById(R.id.run_this_month_num);
        runThisMonthImageView = (ImageView)findViewById(R.id.run_this_month_img);
        separator = findViewById(R.id.separator);

        runThisMonthRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendarViewFold = !calendarViewFold;
                if(calendarViewFold){
                    calendarView.setVisibility(View.GONE);
                    separator.setVisibility(View.GONE);
                    runThisMonthImageView.setImageResource(R.drawable.right);
                }else{
                    calendarView.setVisibility(View.VISIBLE);
                    separator.setVisibility(View.VISIBLE);
                    runThisMonthImageView.setImageResource(R.drawable.down);
                }
            }
        });

        calendarView.setOnRefreshListener(new ICalendarView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                runThisMonthTextView.setText(calendarView.daysCompleteTheTask() + " days");
            }
        });

        /**
         * simulate the process of getting data
         * ..
         */
        int days = calendarView.daysOfCurrentMonth();
        boolean data[] = new boolean[days+1];
        int today = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        for(int i = 1; i <= days; i++){
            if(i <= today){
                data[i] = (Math.random() > 0.5);
            }else{
                data[i] = false;
            }
        }
        calendarView.refresh1(data);


    }
}
