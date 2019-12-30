package com.example.james.tipsmoudle;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

public class StatusBarDrawsBarBackgroudActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elma);
        //21之后可以直接设置状态栏颜色，但是没法改变状态栏icon和字体颜色
        //23之后可以改变icon和字体颜色
        if (Build.VERSION.SDK_INT >= 21) {
            //这个flag不能实现沉浸式
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            //注意要清除 FLAG_TRANSLUCENT_STATUS flag
            // getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option| decorView.getSystemUiVisibility());
            //setStatusBarColor 不能设置FLAG_TRANSLUCENT_STATUS（会设置View
            // .SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN，View
            // .SYSTEM_UI_FLAG_LAYOUT_STABLE），所以换个思路就是用手动通过setSystemUiVisibility设置这两个标志位
            // getWindow().setStatusBarColor(getResources().getColor(android.R.color.holo_red_light));
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }


        // 从Android 5.0开始，Google 推出了全新的设计规范 Material Design,并且原生控件就可以实现一些炫酷的UI动效。
        // 从这个版本开始，google 加入了一个比较重要的方法setStatusBarColor (对应属性：android:statusBarColor),
        // 通过这个方法，可以很轻松地实现沉浸式状态栏
        // 注意看这个方法的注释，想要这个方法生效，必须还要配合一个Flag一起使用，
        // 必须设置FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS ,并且不能设置FLAG_TRANSLUCENT_STATUS(Android 4.4才用这个)
        //
        // 设置了FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS,表明会Window负责系统bar的background 绘制，
        // 绘制透明背景的系统bar（状态栏和导航栏），然后用getStatusBarColor()和getNavigationBarColor()的颜色填充相应的区域。
        // 这就是Android 5.0 以上实现沉浸式导航栏的原理。




    }


}
