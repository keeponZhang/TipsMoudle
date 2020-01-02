package com.example.james.tipsmoudle.other;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.james.tipsmoudle.LauncherActivity;
import com.example.james.tipsmoudle.R;
import com.example.james.tipsmoudle.other.util.StatusBarUtil;

/**
 * Created by Jaeger on 16/2/14.
 * <p>
 * Email: chjie.jaeger@gmail.com
 * GitHub: https://github.com/laobie
 */
public class OtherLauncherActivity extends BaseActivity {
    private DrawerLayout mDrawerLayout;
    private Toolbar mToolbar;
    private CheckBox mChbTranslucent;
    private Button mBtnSetColor;
    private Button mBtnSetTransparent;
    private Button mBtnSetTranslucent;
    private Button mBtnSetForImageView;
    private Button mBtnUseInFragment;
    private Button mBtnSetColorForSwipeBack;
    private Button mBtnSwitchMode;

    private ViewGroup contentLayout;
    private SeekBar mSbChangeAlpha;
    private TextView mTvStatusAlpha;

    private int mStatusBarColor;
    private int mAlpha = StatusBarUtil.DEFAULT_STATUS_BAR_ALPHA;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean booleanExtra = getIntent().getBooleanExtra(LauncherActivity.IS_FIX_SYSTEM_WINDOW,
                true);
        if(booleanExtra){
            setContentView(R.layout.activity_other_launcher);
            Log.e("TAG", "OtherLauncherActivity onCreate fitsSystemWindows:");
        }else{
            setContentView(R.layout.activity_other_launcher2);
            Log.e("TAG", "OtherLauncherActivity onCreate NO fitsSystemWindows:");
        }
        mDrawerLayout = findViewById(R.id.drawer_layout);
        contentLayout = findViewById(R.id.main);
        mToolbar = findViewById(R.id.toolbar);
        mChbTranslucent = findViewById(R.id.chb_translucent);
        mBtnSetColor = findViewById(R.id.btn_set_color);
        mBtnSetTransparent = findViewById(R.id.btn_set_transparent);
        mBtnSetTranslucent = findViewById(R.id.btn_set_translucent);
        mBtnSetForImageView = findViewById(R.id.btn_set_for_image_view);
        mBtnUseInFragment = findViewById(R.id.btn_use_in_fragment);
        mBtnSetColorForSwipeBack = findViewById(R.id.btn_set_color_for_swipe_back);
        mBtnSwitchMode = findViewById(R.id.btn_switch_mode);
        mSbChangeAlpha = findViewById(R.id.sb_change_alpha);
        mTvStatusAlpha = findViewById(R.id.tv_status_alpha);
        setSupportActionBar(mToolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        mDrawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        mBtnSetColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mBtnSetTransparent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =
                        new Intent(OtherLauncherActivity.this, ImageStatusBarActivity.class);
                intent.putExtra(ImageStatusBarActivity.EXTRA_IS_TRANSPARENT, true);
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_set_transparent_ui_flag)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(OtherLauncherActivity.this,
                                ImageStatusBarActivity.class);
                        intent.putExtra(ImageStatusBarActivity.EXTRA_IS_TRANSPARENT, true);
                        intent.putExtra(ImageStatusBarActivity.EXTRA_IS_USE_UI_FLAG, true);
                        startActivity(intent);
                    }
                });

        mBtnSetTranslucent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =
                        new Intent(OtherLauncherActivity.this, ImageStatusBarActivity.class);
                intent.putExtra(ImageStatusBarActivity.EXTRA_IS_TRANSPARENT, false);
                startActivity(intent);
            }
        });

        mBtnSetForImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OtherLauncherActivity.this, ImageViewActivity.class);
                startActivity(intent);
            }
        });

        mBtnUseInFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OtherLauncherActivity.this, UseInFragmentActivity.class);
                startActivity(intent);
            }
        });

        mBtnSetColorForSwipeBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OtherLauncherActivity.this, SwipeBackActivity.class);
                startActivity(intent);
            }
        });

        mBtnSwitchMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OtherLauncherActivity.this, SwitchModeActivity.class);
                startActivity(intent);
            }
        });

        mChbTranslucent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mChbTranslucent.isChecked()) {
                    contentLayout.setBackgroundDrawable(
                            getResources().getDrawable(R.drawable.bg_monkey));
                    StatusBarUtil.setTranslucentForDrawerLayout(OtherLauncherActivity.this,
                            mDrawerLayout, mAlpha);
                    mToolbar.setBackgroundColor(
                            getResources().getColor(android.R.color.transparent));
                } else {
                    contentLayout.setBackgroundDrawable(null);
                    mToolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    StatusBarUtil.setColorForDrawerLayout(OtherLauncherActivity.this, mDrawerLayout,
                            getResources().getColor(R.color.colorPrimary), mAlpha);
                }
            }
        });

        mSbChangeAlpha.setMax(255);
        mSbChangeAlpha.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mAlpha = progress;
                if (mChbTranslucent.isChecked()) {
                    StatusBarUtil.setTranslucentForDrawerLayout(OtherLauncherActivity.this,
                            mDrawerLayout, mAlpha);
                } else {
                    StatusBarUtil.setColorForDrawerLayout(OtherLauncherActivity.this, mDrawerLayout,
                            mStatusBarColor, mAlpha);
                }
                mTvStatusAlpha.setText(String.valueOf(mAlpha));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        mSbChangeAlpha.setProgress(StatusBarUtil.DEFAULT_STATUS_BAR_ALPHA);
    }

    @Override
    protected void setStatusBar() {
        mStatusBarColor = getResources().getColor(R.color.colorPrimary);
        StatusBarUtil.setColorForDrawerLayout(this, (DrawerLayout) findViewById(R.id.drawer_layout),
                mStatusBarColor, mAlpha);
    }
}
