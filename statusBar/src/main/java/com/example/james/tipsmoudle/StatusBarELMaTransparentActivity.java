package com.example.james.tipsmoudle;

import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class StatusBarELMaTransparentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//		饿了么这样的效果是只有5.0及以上系统才支持
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
//			注意两个Flag必须要结合在一起使用，表示会让应用的主体内容占用系统状态栏的空间，
//			最后再调用Window的setStatusBarColor()方法将状态栏设置成透明色就可以了。
            //SYSTEM_UI_FLAG_FULLSCREEN表示全屏的意思,不同SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            //小米8字体白色
            // decorView.setSystemUiVisibility(option);
            //这两个效果居然不一样
            //小米8字体黑色
            decorView.setSystemUiVisibility(option| decorView.getSystemUiVisibility());

            //大于21才能调用
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        boolean booleanExtra = getIntent().getBooleanExtra(LauncherActivity.INTENT_FLAG_CHANGE, false);
        if(booleanExtra){
            Log.e("TAG", "StatusBarELMaTransparentActivity onCreate   decorView.setFitsSystemWindows(true);:");
            //状态栏会变白，如果跟decorView.setSystemUiVisibility(option);，状态栏就看不到
            //  fitsSystemWindows , getWindow().setStatusBarColor(Color.White)与  getWindow
            //  ().setStatusBarColor(Color.TRANSPARENT)没区别
            setContentView(R.layout.activity_elma_fixwindow);
        }else{
            setContentView(R.layout.activity_elma);
        }
        //重要：<item name="android:windowLightStatusBar">true</item> 如果注释掉
        //StatusBar的字体颜色为白色
        //decorView.setSystemUiVisibility(option); decorView.setSystemUiVisibility(option|
        // decorView.getSystemUiVisibility()); 变成无差别了，估计<item
        // name="android:windowLightStatusBar">true</item>会影响decorView.getSystemUiVisibility()

    }
    

}
