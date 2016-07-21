package com.example.countdownview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final CountDownView countDownView1 = (CountDownView) findViewById(R.id.count_down_time_1);
        final CountDownView countDownView2 = (CountDownView) findViewById(R.id.count_down_time_2);
        final CountDownView countDownView3 = (CountDownView) findViewById(R.id.count_down_time_3);
        final CountDownView countDownView4 = (CountDownView) findViewById(R.id.count_down_time_4);

        setCountDownViewListener(countDownView1);
        //setCountDownViewListener(countDownView2);
        //setCountDownViewListener(countDownView3);
        //setCountDownViewListener(countDownView4);


        countDownView1.setTime(5, 0);
        countDownView1.setBackgroundResource(R.drawable.count_down_bg);
        countDownView1.setAnimationStyle(CountDownView.FROM_TOP);


        countDownView2.setTime(5, 0);
        countDownView2.setBackgroundResource(R.drawable.count_down_bg);
        countDownView2.setAnimationStyle(CountDownView.FROM_BOTTOM);


        countDownView3.setTime(5, 0);
        countDownView3.setBackgroundResource(R.drawable.count_down_bg);
        countDownView3.setAnimationStyle(CountDownView.FROM_LEFT);


        countDownView4.setTime(5, 0);
        countDownView4.setBackgroundResource(R.drawable.count_down_bg);
        countDownView4.setAnimationStyle(CountDownView.FROM_RIGHT);

        countDownView1.postDelayed(new Runnable() {
            @Override
            public void run() {
                countDownView1.startCountDown();
                countDownView2.startCountDown();
                countDownView3.startCountDown();
                countDownView4.startCountDown();
            }
        }, 2000);


    }

    private void setCountDownViewListener(CountDownView view) {

        view.setOnTimeListener(new CountDownView.OnTimeListener() {
            @Override
            public void onTimeStart() {
               Toast.makeText(MainActivity.this,"count down start",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTimeEnd() {
                Toast.makeText(MainActivity.this,"count down end",Toast.LENGTH_SHORT).show();
            }
        });


    }
}
