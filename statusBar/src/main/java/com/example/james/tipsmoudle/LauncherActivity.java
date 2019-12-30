package com.example.james.tipsmoudle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.james.tipsmoudle.immersionbar.SixMethodFixActivity;
import com.example.james.tipsmoudle.other.OtherLauncherActivity;

public class LauncherActivity extends AppCompatActivity {
	public static final String INTENT_FLAG_CHANGE = "INTENT_FLAG_CHANGE";
	public static final String INTENT_FLAG_SET_Light_Mode = "INTENT_FLAG_SET_Light_Mode";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_launcher);
//		int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//				| View.SYSTEM_UI_FLAG_FULLSCREEN;
//		getWindow().getDecorView().setSystemUiVisibility(uiOptions);
	}
	public void sixMethod(View view) {
		launcher(SixMethodFixActivity.class);
	}
	public void otherLauncherFixWindow(View view) {
		launcher(OtherLauncherActivity.class);
	}
	public void otherLauncher(View view) {
		Intent intent = new Intent(this, OtherLauncherActivity.class);
		intent.putExtra(OtherLauncherActivity.IS_FIX_SYSTEM_WINDOW, false);
		startActivity(intent);
	}
	public void StatusBarDrawsBarBackgroud(View view) {
		launcher(StatusBarDrawsBarBackgroudActivity.class);
	}
	public void statusBarTheme(View view) {
		launcher(StatusBarThemeActivity.class);
	}
	public void statusBarcomplete(View view) {
		launcher(StatusBarCompleteActivity.class);
	}

	private void launcher(Class  clazz,boolean isChange) {
		Intent intent = new Intent(this, clazz);
		intent.putExtra(INTENT_FLAG_CHANGE, isChange);
		startActivity(intent);
	}
	private void launcher(Class  clazz) {
		launcher(clazz, false);
	}

	public void statusBarElMa(View view) {
		launcher(StatusBarELMaTransparentActivity.class,false);
	}
	public void statusBarElMaFixWindow(View view) {
		launcher(StatusBarELMaTransparentActivity.class,true);
	}






	public void statusBarWhiteElMa(View view) {
		launcher(StatusBarELMaWhiteActivity.class,false);
	}

	public void statusBarElMaWhiteFixWindow(View view) {
		launcher(StatusBarELMaWhiteActivity.class,true);
	}
	public void statusBarElMaLightMode(View view) {
		Intent intent = new Intent(this, StatusBarELMaWhiteActivity.class);
		intent.putExtra(INTENT_FLAG_SET_Light_Mode, true);
		startActivity(intent);
	}



	public void statusBarNavBarcomplete(View view) {
		launcher(StatusBarAndNavBarCompleteActivity.class);
	}
	public void statusBarNavBarElMa(View view) {
		launcher(StatusBarAndNavELMaActivity.class);
	}
	public void after19statusBarNavBarComplete(View view) {
		launcher(After19StatusBarAndNavCompleteActivity.class);
	}
	public void flag(View view) {
		launcher(FlagActivity.class);
	}

	public void beforedanhuanSystemBar(View view) {
		launcher(淡化SystemBarActivity.class,false);
	}

	public void afterdanhuanSystemBar(View view) {
		launcher(淡化SystemBarActivity.class,true);
	}

	public void beforeyingcangStatusBarlow4(View view) {
		Intent intent = new Intent(this, 隐藏StatusBarBelowFourActivity.class);
		intent.putExtra(INTENT_FLAG_CHANGE, false);
		startActivity(intent);
	}
	public void afteryingcangStatusBarlow4(View view) {
		Intent intent = new Intent(this, 隐藏StatusBarBelowFourActivity.class);
		intent.putExtra(INTENT_FLAG_CHANGE, true);
		startActivity(intent);
	}

	public void beforeyingcangStatusBarafter4(View view) {
		Intent intent = new Intent(this, 隐藏StatusBarAfterFourActivity.class);
		intent.putExtra(INTENT_FLAG_CHANGE, false);
		startActivity(intent);
	}
	public void afteryingcangStatusBarafter4(View view) {
		Intent intent = new Intent(this, 隐藏StatusBarAfterFourActivity.class);
		intent.putExtra(INTENT_FLAG_CHANGE, true);
		startActivity(intent);
	}


//	WindowManager.LayoutParams.FLAG_FULLSCREEN
//	隐藏状态栏
//	View.SYSTEM_UI_FLAG_VISIBLE                   API 14
//	默认标记
//	View.SYSTEM_UI_FLAG_LOW_PROFILE                  API 14
//	低调模式, 会隐藏不重要的状态栏图标
//	View.SYSTEM_UI_FLAG_LAYOUT_STABLE                  API 16
//	保持整个View稳定, 常和控制System UI悬浮, 隐藏的Flags共用, 使View不会因为System UI的变化而重新layout
//	View.SYSTEM_UI_FLAG_FULLSCREEN                     API 16
//	状态栏隐藏，效果同设置WindowManager.LayoutParams.FLAG_FULLSCREEN
//	View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN             API 16
//	视图延伸至状态栏区域，状态栏上浮于视图之上
//	View.SYSTEM_UI_FLAG_HIDE_NAVIGATION                  API 14
//	隐藏导航栏
//	View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION            API 16
//	视图延伸至导航栏区域，导航栏上浮于视图之上
//	View.SYSTEM_UI_FLAG_IMMERSIVE                                 API 19
//	沉浸模式, 隐藏状态栏和导航栏, 并且在第一次会弹泡提醒, 并且在状态栏区域滑动可以呼出状态栏
//（这样会系统会清除之前设置的View.SYSTEM_UI_FLAG_FULLSCREEN或View.SYSTEM_UI_FLAG_HIDE_NAVIGATION标志）。
//	使之生效，需要和View.SYSTEM_UI_FLAG_FULLSCREEN，View.SYSTEM_UI_FLAG_HIDE_NAVIGATION中的一个或两个同时设置。
//	View.SYSTEM_UI_FLAG_IMMERSIVE_STIKY                      API 19
//	与上面唯一的区别是, 呼出隐藏的状态栏后不会清除之前设置的View.SYSTEM_UI_FLAG_FULLSCREEN
	//	或View.SYSTEM_UI_FLAG_HIDE_NAVIGATION标志，在一段时间后将再次隐藏系统栏）

}
