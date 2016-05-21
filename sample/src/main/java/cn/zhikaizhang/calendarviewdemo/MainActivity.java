package cn.zhikaizhang.calendarviewdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cn.zhangzhikai.demo.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button demo0 = (Button)findViewById(R.id.button0);
        Button demo1 = (Button)findViewById(R.id.button1);
        demo0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Demo0.class);
                startActivity(intent);
            }
        });
        demo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Demo1.class);
                startActivity(intent);
            }
        });
    }

}
