## SimpleCountDownView

A simple countdown view with translation animation (not highly accurate).

If you have any questions,let me know    : )     stewforani@gmail.com

## Results show

![image](https://github.com/stewForAni/SimpleCountDownView/blob/master/gif%20or%20pic/countdown.gif)   

## Usage

You can just copy my java code   **CountDownView**   into your project.

#### Add this to your xml file :

```
 <com.example.countdownview.CountDownView
       android:id="@+id/count_down_time"
       android:layout_width="@dimen/count_down_w"
       android:layout_height="@dimen/count_down_h"
       android:layout_centerHorizontal="true"/>
```



#### Just call fowlling methods to set countdownview :

1) set the time when to start and end.

```
countDownView.setTime(NumFrom, NumTo);
```

2) add listener to CountDownView.

```
 countDownView.setOnTimeListener(new CountDownView.OnTimeListener() {
            @Override
            public void onTimeStart() {
               //count down start
            }

            @Override
            public void onTimeEnd() {
                //count down end
            }
        });
```

3) you can choose four different direction.

```
countDownView.setAnimationStyle(CountDownView.FROM_TOP);

countDownView.setAnimationStyle(CountDownView.FROM_BOTTOM);

countDownView.setAnimationStyle(CountDownView.FROM_LEFT);

countDownView.setAnimationStyle(CountDownView.FROM_RIGHT);
```

4) you can also  change other attribute by yourself , for example :

```
//View Size : the height of view must be as same as the tranlation offset. 

android:layout_height="@dimen/count_down_h"

offset = getResources().getDimension(R.dimen.count_down_h);
```

```
//keep TIME_TRANS+TIME_STAY = 1000
private static int TIME_TRANS = 300; //number scroll duration
private static int TIME_STAY = 700;  //number stay duration
```
