package com.example.mvmm.activity;

import android.databinding.DataBindingUtil;
import android.databinding.OnRebindCallback;
import android.databinding.ViewDataBinding;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvmm.R;
import com.example.mvmm.databinding.ActivityAnimationBinding;

public class AnimationActivity extends AppCompatActivity {

    ActivityAnimationBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_animation);
        mBinding.addOnRebindCallback(new OnRebindCallback() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public boolean onPreBind(ViewDataBinding binding) {
                ViewGroup view = (ViewGroup) binding.getRoot();
                TransitionManager.beginDelayedTransition(view);
                return true;
            }
        });
        mBinding.setPresenter(new Presenter());
    }

    public class Presenter {
        public void onCheckedChanged(View buttonView, boolean isChecked) {
            mBinding.setShowImage(isChecked);
        }
    }
}
