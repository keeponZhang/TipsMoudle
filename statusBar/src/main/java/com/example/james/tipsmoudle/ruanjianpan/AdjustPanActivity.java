package com.example.james.tipsmoudle.ruanjianpan;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.james.tipsmoudle.LauncherActivity;
import com.example.james.tipsmoudle.R;
import com.example.james.tipsmoudle.other.util.StatusBarUtil;

public class AdjustPanActivity extends AppCompatActivity {

    // 如果输入框的高度高于键盘弹出的高度，不管有没有滚动控件，整体界面都会被顶上去，软键盘不会自动弹出，也不会压缩背景图
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean booleanExtra = getIntent().getBooleanExtra(
                LauncherActivity.INTENT_FLAG_SCORLL, false);
        boolean isChange = getIntent().getBooleanExtra(
                LauncherActivity.INTENT_FLAG_CHANGE, false);
        if(isChange){
            StatusBarUtil.setTransparentForWindow(this);
        }
        if (booleanExtra) {
            setContentView(R.layout.activity_adjust_pan_scroll);
        } else {
            setContentView(R.layout.activity_adjust_pan);
        }
    }


}
