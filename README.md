[The related article in my blog](http://zhikaizhang.cn)
-------------------------------------------------------

Android-CalendarView
====================
![](http://github.com/laserwave/Android-CalendarView/raw/master/display/1.gif)
![](http://github.com/laserwave/Android-CalendarView/raw/master/display/2.gif)

There are two different modes as the pictures above show. 

The former is in the normal calendar mode. 

The latter is in the record mode, aiming to record the completion of your plans in the current month. 

Support `API LEVEL >= 7`.

Including In Your Project
-------------------------

#### Gradle
Add the following code in the build.gradle of your module.
``` 
dependencies {
    compile 'cn.zhikaizhang.calendar:library:1.0.0'
}
```
#### Download the source code
You can also download the source code of the project and import the library module into your project as a module so that you can modify the source code.

Usage
-----
*For a working implementation of this project see the `sample/` folder.*

1. Include one of the widgets in your xml. You can set the mode 0 for the normal calendar mode and 1 for the record mode. You can also the mode in your java code.

``` 
<cn.zhikaizhang.calendarview.CalendarView
        android:id="@+id/calendarView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:mode="0">
</cn.zhikaizhang.calendarview.CalendarView>
```

2. Refresh the CalendarView. You will use refresh0() for the normal calendar mode and refresh1() for the record mode.

``` 
calendarView.setMode(0);
//refresh the CalendarView with new values of year and month
calendarView.refresh0(year, month);

calendarView.setMode(1);
//simulate to get data
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
```

3. Set the appearance you like. You can set the language to English or Chinese. You can also modify the color and size of the text.

``` 
/**
 * modify the language of head of the calendar
 * legal values of style : 0 - 3
 * 0, 1, 2 : Chinese, 3 : English
 */
calendarView.setWeekTextStyle(style);

//set the text color of the head
calendarView.setWeekTextColor(Color.BLACK);

/**
 * set the scale of text size of the head
 * legal values : 0.0f - 1.0f
 */
calendarView.setWeekTextSizeScale(0.5f);

//set the text color of the calendar cell
calendarView.setCalendarTextColor(Color.BLACK);

/**
 * set the scale of text size of the calendar cell
 * legal values : 0.0f - 1.0f
 */
calendarView.setTextSizeScale(0.5f);
```

4. Implement the callback. Set the OnRefreshListener to do what you want after you refresh the calendar and set the OnItemClickListener to do what you want after you click a day.

``` 
calendarView.setOnRefreshListener(new ICalendarView.OnRefreshListener() {
	@Override
	public void onRefresh() {
		yearMonthTextView.setText(getYearMonthText(calendarView.getYear(), calendarView.getMonth()));
	}
});

calendarView.setOnItemClickListener(new ICalendarView.OnItemClickListener() {
	@Override
	public void onItemClick(int day) {
		int year = calendarView.getYear();
		int month = calendarView.getMonth();
		Toast.makeText(Demo0.this, year + "-" + month + "-" + day, Toast.LENGTH_SHORT).show();
	}
});
```

Developed By
============

 * ZhikaiZhang 
 * Email <zhangzhikai@seu.edu.cn>
 * Blog <http://zhangzhikai.cn>

License
=======

    Copyright 2016 ZhikaiZhang 

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

