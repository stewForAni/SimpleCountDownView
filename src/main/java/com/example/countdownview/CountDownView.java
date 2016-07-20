package com.example.countdownview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by stew on 16/7/19.
 * mail: stewforani@gmail.com
 */
public class CountDownView extends FrameLayout {

    public static final String FROM_TOP = "from_top";
    public static final String FROM_BOTTOM = "from_bottom";
    public static final String FROM_LEFT = "from_left";
    public static final String FROM_RIGHT = "from_right";

    private ObjectAnimator objectAnimator1, objectAnimator2;
    private AnimatorListenerAdapter adapter1, adapter2;
    private OnTimeListener onTimeListener;

    private TextView countDownTv1, countDownTv2;
    private String ANIMATION_STYLE;

    private static int TIME_TRANS = 300;
    private static int TIME_STAY = 700;
    private int startTime = 0;
    private int endTime = 0;
    private float offset = 0f;

    public CountDownView(Context context) {
        super(context);
        init();
    }

    public CountDownView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CountDownView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CountDownView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.count_down_layout, this, true);
        countDownTv1 = (TextView) findViewById(R.id.count_down_tv_1);
        countDownTv2 = (TextView) findViewById(R.id.count_down_tv_2);
    }

    private void setCountDown() {

        countDownTv1.setText("" + startTime);

        objectAnimator1 = ObjectAnimator.ofFloat(countDownTv1, ANIMATION_STYLE, -offset, 0);
        objectAnimator1.setDuration(TIME_TRANS);
        adapter1 = new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                if (startTime > endTime) {
                    countDownTv1.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startTime = startTime - 1;
                            countDownTv2.setText("" + startTime);
                            objectAnimator1 = ObjectAnimator.ofFloat(countDownTv1, ANIMATION_STYLE, 0, offset);
                            objectAnimator1.setDuration(TIME_TRANS);
                            objectAnimator2 = ObjectAnimator.ofFloat(countDownTv2, ANIMATION_STYLE, -offset, 0);
                            objectAnimator2.setDuration(TIME_TRANS);
                            objectAnimator2.addListener(adapter2);

                            objectAnimator1.start();
                            objectAnimator2.start();

                        }

                    }, TIME_STAY);
                } else {

                    if (onTimeListener != null) {
                        onTimeListener.onTimeEnd();
                    }
                }
            }
        };


        adapter2 = new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);

                if (startTime > endTime) {
                    countDownTv1.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startTime = startTime - 1;
                            countDownTv1.setText("" + startTime);
                            objectAnimator1 = ObjectAnimator.ofFloat(countDownTv1, ANIMATION_STYLE, -offset, 0);
                            objectAnimator1.setDuration(TIME_TRANS);
                            objectAnimator1.addListener(adapter1);

                            objectAnimator2 = ObjectAnimator.ofFloat(countDownTv2, ANIMATION_STYLE, 0, offset);
                            objectAnimator2.setDuration(TIME_TRANS);

                            objectAnimator1.start();
                            objectAnimator2.start();

                        }
                    }, TIME_STAY);
                } else {

                    if (onTimeListener != null) {
                        onTimeListener.onTimeEnd();
                    }
                }
            }
        };

        objectAnimator1.addListener(adapter1);
        objectAnimator1.start();
    }

    public void setTime(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;

    }

    public void startCountDown() {

        if (startTime <= endTime || ANIMATION_STYLE == null || offset == 0) {
            return;
        }
        if (onTimeListener != null) {
            onTimeListener.onTimeStart();
        }
        setCountDown();
    }

    public void setAnimationStyle(String type) {

        switch (type) {
            case FROM_TOP:
                ANIMATION_STYLE = "translationY";
                offset = getResources().getDimension(R.dimen.count_down_h);
                break;
            case FROM_BOTTOM:
                ANIMATION_STYLE = "translationY";
                offset = -getResources().getDimension(R.dimen.count_down_h);
                break;
            case FROM_LEFT:
                ANIMATION_STYLE = "translationX";
                offset = getResources().getDimension(R.dimen.count_down_h);
                break;
            case FROM_RIGHT:
                ANIMATION_STYLE = "translationX";
                offset = -getResources().getDimension(R.dimen.count_down_h);
                break;

        }
    }


    public void setOnTimeListener(OnTimeListener listener) {
        this.onTimeListener = listener;
    }

    public interface OnTimeListener {
        void onTimeStart();
        void onTimeEnd();
    }
}
