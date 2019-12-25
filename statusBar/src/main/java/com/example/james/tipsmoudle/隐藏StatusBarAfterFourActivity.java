package com.example.james.tipsmoudle;

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
public class 隐藏StatusBarAfterFourActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yincang_status_bar);

        Intent intent = getIntent();
        if (intent != null) {
            boolean booleanExtra =
                    intent.getBooleanExtra(LauncherActivity.INTENT_FLAG_CHANGE, false);
            if (booleanExtra) {
                hideStatusBar4_0After();
            }
        }

    }

    //4.0以上
    public void hideStatusBar4_0After() {
        if (Build.VERSION.SDK_INT >= 16) {
            Log.e("TAG", "隐藏StatusBarBelowFourActivity hideStatusBar4_0After:");
            //使用setSystemUiVisibility()设置UI flag比使用WindowManager的flag拥有更多的控制选项。
//		一旦UI Flag被清除（比如跳转到另外的activity），你需要重新设置UI flag来隐藏system bar。
//		界面的切换会导致setSystemUiVisibility()的设置被清空
            View decorView = getWindow().getDecorView();
            // Hide the status bar.
            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
            // Remember that you should never show the action bar if the
            // status bar is hidden, so hide that too if necessary.
            ActionBar actionBar = getSupportActionBar();
            if(actionBar!=null){
                actionBar.hide();
            }

        }
    }

    // 以下是使用setSystemUiVisibility()方法时需要注意的地方：
    // 在不同的地方设置Ui flag是有区别的，
    // 如果你是在onCreate中设置UI flag隐藏systembar，当用户点击home键，system bar将重新出现，用户重新回到这个activity的时候，onCreate是不会被调用的，
    // 所以system bar仍然是可见的。因此如果你想在activity切换回来的时候仍然保持system bar的状态，
    // 最好是在onResume()或者onWindowFocusChanged()方法中设置UI flag。
    //
    // 只有当调用setSystemUiVisibility()的view是可见的setSystemUiVisibility()才会起作用。
    //         .
    // 界面的切换会导致setSystemUiVisibility()的设置被清空

}
