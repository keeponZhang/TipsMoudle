package com.example.james.tipsmoudle.other;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.james.tipsmoudle.R;
import com.example.james.tipsmoudle.other.util.StatusBarUtil;

/**
 * Created by Jaeger on 16/2/14.
 *
 * Email: chjie.jaeger@gmail.com
 * GitHub: https://github.com/laobie
 */
public class ImageStatusBarActivity extends BaseActivity {
    public static final String EXTRA_IS_TRANSPARENT = "is_transparent";
    public static final String EXTRA_IS_USE_UI_FLAG = "extra_is_use_ui_flag";
    private TextView mTvStatusAlpha;
    private RelativeLayout mRootLayout;
    private Button mBtnChangeBackground;
    private boolean isBgChanged;
    private SeekBar mSbChangeAlpha;

    private boolean isTransparent;
    private boolean isUseFlag;
    private int mAlpha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        isTransparent = getIntent().getBooleanExtra(EXTRA_IS_TRANSPARENT, false);
        isUseFlag = getIntent().getBooleanExtra(EXTRA_IS_USE_UI_FLAG, false);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_status_bar);

        mRootLayout = (RelativeLayout) findViewById(R.id.root_layout);
        mBtnChangeBackground = (Button) findViewById(R.id.btn_change_background);
        mTvStatusAlpha = (TextView) findViewById(R.id.tv_status_alpha);
        mSbChangeAlpha = (SeekBar) findViewById(R.id.sb_change_alpha);

        mBtnChangeBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isBgChanged = !isBgChanged;
                if (isBgChanged) {
                    mRootLayout.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_girl));
                } else {
                    mRootLayout.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_monkey));
                }
            }
        });

        if (!isTransparent) {
            mSbChangeAlpha.setVisibility(View.VISIBLE);
            setSeekBar();
        } else {
            mSbChangeAlpha.setVisibility(View.GONE);
        }
    }

    @Override
    protected void setStatusBar() {
        if (isTransparent) {
            if(isUseFlag){
                StatusBarUtil.setTransParentWithUIFlag(this);
            }else{
                // StatusBarUtil.setTransparent(this);
                StatusBarUtil.setTransparentNoFixSystemWindow(this);
            }

        } else {
            StatusBarUtil.setTranslucent(this, StatusBarUtil.DEFAULT_STATUS_BAR_ALPHA);
        }
    }

    private void setSeekBar() {
        mSbChangeAlpha.setMax(255);
        mSbChangeAlpha.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mAlpha = progress;
                StatusBarUtil.setTranslucent(ImageStatusBarActivity.this, mAlpha);
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
}
