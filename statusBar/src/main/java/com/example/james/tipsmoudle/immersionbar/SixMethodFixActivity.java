package com.example.james.tipsmoudle.immersionbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.james.tipsmoudle.LauncherActivity;
import com.example.james.tipsmoudle.R;

public class SixMethodFixActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_six_method);
        findViewById(R.id.method1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launcher(Method1Activity.class);
            }
        });
        findViewById(R.id.method2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launcher(Method2Activity.class);
            }
        });
        findViewById(R.id.method3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launcher(Method3Activity.class);
            }
        });
        findViewById(R.id.method4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launcher(Method4Activity.class);
            }
        });
        findViewById(R.id.method5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launcher(Method5Activity.class);
            }
        });
        findViewById(R.id.method6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launcher(Method6Activity.class);
            }
        });
    }

    private void launcher(Class  clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }


}
