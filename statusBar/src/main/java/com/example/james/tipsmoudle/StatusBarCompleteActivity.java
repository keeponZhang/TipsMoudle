package com.example.james.tipsmoudle;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class StatusBarCompleteActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}

	private void hide() {
		View decorView = getWindow().getDecorView();
		//		SYSTEM_UI_FLAG_FULLSCREEN表示全屏的意思，也就是会将状态栏隐藏
		int option = View.SYSTEM_UI_FLAG_FULLSCREEN;
		decorView.setSystemUiVisibility(option);
		ActionBar actionBar = getSupportActionBar();
		actionBar.hide();
	}

	@Override
	protected void onResume() {
		super.onResume();
		hide();
	}
}
