package com.example.james.tipsmoudle;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

/**
 * createBy keepon
 */
public class 隐藏StatusBarBelowFourActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yincang_status_bar);
        Intent intent = getIntent();
        if (intent != null) {
            boolean booleanExtra =
                    intent.getBooleanExtra(LauncherActivity.INTENT_FLAG_CHANGE, false);
            if (booleanExtra) {
                hideStatusBar4_0Before();
            }
        }

    }

    //4.0以下(4.0以上该方法也适用)
    public void hideStatusBar4_0Before() {
        //设置主题 简单不易出错。
        //.UI切换更流畅。因为系统在实例化activity之前已经获得了渲染UI所需要的信息。
//		android:theme="@android:style/Theme.Holo.NoActionBar.Fullscreen"

//		当你设置了WindowManager的flag，将一直保持该flag的效果，除非你重置了flag。之所以强调这点是因为下面要讲的内容中会出现设置了某个状态但是不一定一直该保持状态。
        Log.e("TAG", "隐藏StatusBarBelowFourActivity hideStatusBar4_0Before:");
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }


}
