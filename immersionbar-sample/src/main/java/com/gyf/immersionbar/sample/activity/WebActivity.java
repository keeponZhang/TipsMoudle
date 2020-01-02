package com.gyf.immersionbar.sample.activity;

import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.LinearLayout;

import com.gyf.immersionbar.ImmersionBar;
import com.gyf.immersionbar.sample.R;
import com.gyf.immersionbar.sample.utils.AndroidBug5497Workaround;

import butterknife.BindView;

/**
 * @author geyifeng
 * @date 2017/6/19
 */
public class WebActivity extends BaseActivity {
    @BindView(R.id.web)
    WebView mWebView;
    @BindView(R.id.line)
    LinearLayout layout;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_web;
    }

    // 这时候，情况就会变得复杂了:
    //
    // 首先，页面是非全屏模式的情况下，给activity设置adjustPan会失效。(不设置反而没事)
    // 其次，页面是全屏模式的情况，adjustPan跟adjustResize都会失效。
    @Override
    protected void initImmersionBar() {
        // super.initImmersionBar();
        boolean isFix = getIntent().getBooleanExtra(KeyBoardActivity.INTENT_FIX_KEY_BOARD, false);
        //
        if(isFix){
            ImmersionBar.with(this).titleBar(R.id.toolbar)
                    //解决软键盘与底部输入框冲突问题
                    .keyboardEnable(true)
                    .init();
        }else{
            ImmersionBar.with(this).titleBar(R.id.toolbar)
                    .init();
            AndroidBug5497Workaround.assistActivity(this);
        }
    }

    @Override
    protected void initView() {
        mWebView.loadUrl("file:///android_asset/input_webview.html");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            if (mWebView != null) {
                ViewParent parent = mWebView.getParent();
                if (parent != null) {
                    ((ViewGroup) parent).removeView(mWebView);
                }
                mWebView.stopLoading();
                // 退出时调用此方法，移除绑定的服务，否则某些特定系统会报错
                mWebView.getSettings().setJavaScriptEnabled(false);
                mWebView.clearHistory();
                mWebView.clearView();
                mWebView.removeAllViews();
                mWebView.destroy();
                mWebView = null;
            }
        } catch (Exception ignored) {
        }
    }
}
