package cn.zhikaizhang.calendarview;

import android.graphics.Color;

import cn.zhikaizhang.library.R;

public class Constant {


    public static final int[] WEEK_TEXT = {R.array.calendarview__weektext_0, R.array.calendarview__weektext_1, R.array.calendarview__weektext_2, R.array.calendarview__weektext_3};

    public static final int TEXT_COLOR = Color.BLACK;

    public static final int BACKGROUND_COLOR = Color.WHITE;

    public static final int DAYS_OF_MONTH[][] = new int[][]{{-1, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}, {-1, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}};

    public static final int MODE_CALENDAR = 0;

    public static final int MODE_SHOW_DATA_OF_THIS_MONTH = 1;

}
