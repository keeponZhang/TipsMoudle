package com.example.james.tipsmoudle;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class StatusBarELMaActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
//		饿了么这样的效果是只有5.0及以上系统才支持
	if (Build.VERSION.SDK_INT >= 21) {
			View decorView = getWindow().getDecorView();
//			注意两个Flag必须要结合在一起使用，表示会让应用的主体内容占用系统状态栏的空间，最后再调用Window的setStatusBarColor()方法将状态栏设置成透明色就可以了。
		//SYSTEM_UI_FLAG_FULLSCREEN表示全屏的意思,不同SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
			int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
					| View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
			decorView.setSystemUiVisibility(option);
			//大于21才能调用
		getWindow().setStatusBarColor(Color.TRANSPARENT);
		}
		ActionBar actionBar = getSupportActionBar();
		actionBar.hide();
	}
}
