package com.bigkoo.pickerview;

import android.content.Context;
import android.view.View;

import com.bigkoo.pickerview.view.WheelTime;

import java.util.Calendar;

public class MyTimePickerView extends TimePickerView {


    public MyTimePickerView(Context context) {
        super(context, Type.YEAR_MONTH);
    }

    @Override
    public int getContentViewId() {
        return R.layout.my_time_picker_view;
    }

    @Override
    public void initialWheelTime() {
        final View timepickerview = findViewById(R.id.timepicker);
        wheelTime = new WheelTime(timepickerview, type);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        setRange(1, year + 1000);
        wheelTime.setEndMonthDay(month + 1, 0);
        wheelTime.setPicker(year, month, 0);
    }



}
