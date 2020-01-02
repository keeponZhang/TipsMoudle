package com.example.james.tipsmoudle.ruanjianpan;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.james.tipsmoudle.LauncherActivity;
import com.example.james.tipsmoudle.R;
import com.example.james.tipsmoudle.other.util.StatusBarUtil;
import com.example.james.tipsmoudle.util.AndroidBug5497Workaround;

public class AdjustResizeActivity extends AppCompatActivity {

    // 有滚动控件，则会压缩滚动控件来保证输入框刚好输入；而没有滚动控件，会将底部所有的控件顶上去，留出位置给键盘，但整体布局不会上移；无论有没有滚动控件，都会压缩控件
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean booleanExtra = getIntent().getBooleanExtra(
                LauncherActivity.INTENT_FLAG_SCORLL, false);
        boolean isChange = getIntent().getBooleanExtra(
                LauncherActivity.INTENT_FLAG_CHANGE, false);
        boolean fixBug = getIntent().getBooleanExtra(
                LauncherActivity.IS_FIX_BUG, false);
        if(isChange){
            StatusBarUtil.setTransparentForWindow(this);
        }
        if (booleanExtra) {
            setContentView(R.layout.activity_adjust_pan_scroll);
        } else {
            setContentView(R.layout.activity_adjust_pan);
        }
        View viewById = findViewById(R.id.root_layout);

        if (fixBug){
            AndroidBug5497Workaround.assistActivity(this);
        }
    }



}
