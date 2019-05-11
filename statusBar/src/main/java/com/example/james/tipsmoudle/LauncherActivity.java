package com.example.james.tipsmoudle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LauncherActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_launcher);
	}

	public void statusBarcomplete(View view) {
		launcher(StatusBarCompleteActivity.class);
	}

	private void launcher(Class  clazz) {
		Intent intent = new Intent(this, clazz);
		startActivity(intent);
	}

	public void statusBarElMa(View view) {
		launcher(StatusBarELMaActivity.class);
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
}
