package com.example.james.tipsmoudle;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.james.tipsmoudle.util.StatusBarUtils;

public class StatusBarELMaWhiteActivity extends AppCompatActivity {

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
            getWindow().setStatusBarColor(Color.WHITE);
        }
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        boolean booleanExtra = getIntent().getBooleanExtra(LauncherActivity.INTENT_FLAG_CHANGE, false);
        boolean lightMode = getIntent().getBooleanExtra(LauncherActivity.INTENT_FLAG_SET_Light_Mode,
                false);
        if(lightMode){
            StatusBarUtils.setStatusBarLightMode(this,true);
            Log.e("TAG", "StatusBarELMaWhiteActivity onCreate setStatusBarLightMode:");
        }
        if(booleanExtra){
            Log.e("TAG", "StatusBarELMaWhiteActivity onCreate   decorView.setFitsSystemWindows(true);:");
            //状态栏会变白，如果跟decorView.setSystemUiVisibility(option);，状态栏的字体就看不到
            setContentView(R.layout.activity_elma_fixwindow);
        }else{
            setContentView(R.layout.activity_elma);
        }

    }

}
