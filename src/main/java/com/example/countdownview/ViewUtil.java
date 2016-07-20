package com.example.countdownview;

import android.content.Context;

/**
 * Created by stew on 16/7/19.
 * mail: stewforani@gmail.com
 */
public class ViewUtil {
    /**
     * dp转px
     * @param context
     * @param dpValue
     * @return
     */
    public static int dp2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
