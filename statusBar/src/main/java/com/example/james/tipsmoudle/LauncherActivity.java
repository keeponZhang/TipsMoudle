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

	public void complete(View view) {
		launcher(ImmersiveCompleteActivity.class);
	}

	private void launcher(Class  clazz) {
		Intent intent = new Intent(this, clazz);
		startActivity(intent);
	}

	public void noComplete(View view) {
		launcher(ImmersiveELMaActivity.class);
	}
}
