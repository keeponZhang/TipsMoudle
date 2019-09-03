package com.example.mvmm.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.mvmm.R;
import com.example.mvmm.databinding.ActivityMvvmBinding;

public class MvvmActivity extends AppCompatActivity {
    private ActivityMvvmBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm);
        mBinding.setPresenter(new Presenter());
    }
    public class Presenter {
        public void onClickSimpleDemo(View view) {
            startActivity(new Intent(MvvmActivity.this, SimpleActivity.class));
        }
        public void onClickListDemo(View view) {
            startActivity(new Intent(MvvmActivity.this, ListActivity.class));
        }
        public void onClickTwoWayDemo(View view) {
            startActivity(new Intent(MvvmActivity.this, TwoWayActivity.class));
        }
        public void onClickExpressionDemo(View view) {
            startActivity(new Intent(MvvmActivity.this, ExpressionActivity.class));
        }
        public void onClickAnimationDemo(View view) {
            startActivity(new Intent(MvvmActivity.this, AnimationActivity.class));
        }
        public void onClickLambdaDemo(View view) {
            startActivity(new Intent(MvvmActivity.this, LambdaActivity.class));
        }
        public void onClickInjectDemo(View view) {
            startActivity(new Intent(MvvmActivity.this, LambdaActivity.class));
        }

    }
}
