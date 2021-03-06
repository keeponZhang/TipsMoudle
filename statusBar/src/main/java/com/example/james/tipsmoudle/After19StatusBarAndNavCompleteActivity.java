package com.example.james.tipsmoudle;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class After19StatusBarAndNavCompleteActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		if (hasFocus && Build.VERSION.SDK_INT >= 19) {
			View decorView = getWindow().getDecorView();
			decorView.setSystemUiVisibility(
					View.SYSTEM_UI_FLAG_LAYOUT_STABLE
							| View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
							//		SYSTEM_UI_FLAG_FULLSCREEN表示全屏的意思，也就是会将状态栏隐藏
							| View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
							//SYSTEM_UI_FLAG_HIDE_NAVIGATION将状态栏异常
							| View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
							| View.SYSTEM_UI_FLAG_FULLSCREEN
//							| View.SYSTEM_UI_FLAG_IMMERSIVE
//SYSTEM_UI_FLAG_IMMERSIVE_STICKY如果用户没有进行操作，系统栏会在一段时间内自动隐藏。
							| View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
		}
	}

}
