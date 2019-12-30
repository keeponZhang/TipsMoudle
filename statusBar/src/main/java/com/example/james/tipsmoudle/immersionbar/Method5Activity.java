package com.example.james.tipsmoudle.immersionbar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.james.tipsmoudle.R;
import com.gyf.immersionbar.ImmersionBar;

/**
 * createBy keepon
 */
public class Method5Activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_method5);
        ImmersionBar.with(this)
                .titleBar(findViewById(R.id.status_view))
                .init();
    }
}
