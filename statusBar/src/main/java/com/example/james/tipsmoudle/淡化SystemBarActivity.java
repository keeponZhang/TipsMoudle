package com.example.james.tipsmoudle;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

/**
 * createBy keepon
 */
public class 淡化SystemBarActivity extends AppCompatActivity {
    //模拟器会实现淡化
    //xiaomi8无变化
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhua_sysytem_bar);

        Intent intent = getIntent();
        if(intent!=null){
            boolean booleanExtra = intent.getBooleanExtra(LauncherActivity.INTENT_FLAG_CHANGE, false);
            if(booleanExtra){
                Log.e("TAG", "淡化SystemBarActivity onCreate:");
                system_ui_flag_low_profile();
            }

        }

    }
    public void system_ui_flag_low_profile() {
        View decorView = getWindow().getDecorView();
//		使用SYSTEM_UI_FLAG_LOW_PROFILE 标志来使 status bar和navigation bar变暗
//		一旦用户这这个时候触摸了status bar和navigation bar 的所在区域， 系统便清除掉了SYSTEM_UI_FLAG_LOW_PROFILE，status bar和navigation bar淡化效果将消失，如果你想再次淡化status bar和navigation bar，需要再次如上设置。
        int uiOptions = View.SYSTEM_UI_FLAG_LOW_PROFILE;
        decorView.setSystemUiVisibility(uiOptions);

        //手动清除
//		View decorView = getActivity().getWindow().getDecorView();
//		// Calling setSystemUiVisibility() with a value of 0 clears
//		// all flags.
//		decorView.setSystemUiVisibility(0);
    }
}
