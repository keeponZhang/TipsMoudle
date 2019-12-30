package com.example.james.tipsmoudle.immersionbar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.example.james.tipsmoudle.R;
import com.gyf.immersionbar.ImmersionBar;

/**
 * createBy keepon
 */
public class Method1Activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_method1);

        ImmersionBar.with(this).init();
        final View topview = findViewById(R.id.top_view);
        topview.postDelayed(new Runnable() {
            @Override
            public void run() {
                ViewGroup.LayoutParams layoutParams = topview.getLayoutParams();
                Log.e("TAG", "Method1Activity run  layoutParams.height:" + layoutParams.height);
            }

        }, 2000);
    }
}
