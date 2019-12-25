package com.example.james.tipsmoudle;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

public class FlagActivity extends AppCompatActivity {
    //	http://www.jcodecraeer.com/a/anzhuokaifa/developer/2014/1117/1997.html
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//		setTheme(R.style.windowActionBarOverlayThreme);
//		setContentView(R.layout.activity_flag2);
//		windowActionBarOverlayThreme();


//	hidestatusBarElma();
//	hide_navigation();
//		hide_navigationELma();


        //fitsSystemWindows设置
        //只有将statusbar设为透明，或者界面设为全屏显示（设置View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN flag)时，fitsSystemWindows才会起作用。不然statusbar的空间轮不到用户处理，这时会由ContentView的父控件处理，如果用HierarchyView 工具查看，将会看到，ContentView的父控件的paddingTop将会被设置。
        //如果多个view同时设置了fitsSystemWindows，只有第一个会起作用。这是一般情况，后面会介绍特殊情况。
        //		设置paddingTop只是fitsSystemWindows属性的默认行为
        setContentView(R.layout.activity_flag);
        translucent();
    }

    private void windowActionBarOverlayThreme() {
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
        decorView.setSystemUiVisibility(uiOptions);
        if (Build.VERSION.SDK_INT >= 21) {
            //下面这两个缺一不可
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        } else {
            //21以下，内容虽然可以再statusBar后面，但是被挡住了
        }
    }

    //	在 android4.1以及之后的版本
    private void hidestatusBarElma() {
        View decorView = getWindow().getDecorView();
//		SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN标志,让activity的内容部分显示在status bar的背后
        int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//		同时，你也有可能需要SYSTEM_UI_FLAG_LAYOUT_STABLE这个标志来帮助你的应用维持一个稳定的布局（这句话真他妈理解不能）。
                //不加好像也行
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;

        decorView.setSystemUiVisibility(uiOptions);

        //需隐藏acitonBar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        if (Build.VERSION.SDK_INT >= 21) {
            //下面这两个缺一不可
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        } else {
            //21以下，内容虽然可以再statusBar后面，但是被挡住了
        }
    }

    public void translucent() {
        //		饿了么这样的效果是只有5.0及以上系统才支持
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            //			注意两个Flag必须要结合在一起使用，表示会让应用的主体内容占用系统状态栏的空间，最后再调用Window的setStatusBarColor()方法将状态栏设置成透明色就可以了。
            //SYSTEM_UI_FLAG_FULLSCREEN表示全屏的意思,不同SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
//					|View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
//			fitsSystemWindows不能和SYSTEM_UI_FLAG_LAYOUT_STABLE一起用
            decorView.setSystemUiVisibility(option);
            //大于21才能调用
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }

    }

    //	在4.0及以上版本中隐藏导航栏
    public void hide_navigation() {
        View decorView = getWindow().getDecorView();
        // Hide both the navigation bar and the status bar.
        // SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
        // a general rule, you should design your app to hide the status bar whenever you
        // hide the navigation bar.
        //仅仅SYSTEM_UI_FLAG_FULLSCREEN，导航栏还是可见的
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
//		使用这个方法时，触摸屏幕的任何一个区域都是使导航栏（与状态栏）重新显示。用户的交互使这个标志SYSTEM_UI_FLAG_HIDE_NAVIGATION被清除。
//		一旦这个标志被清除了，如果你想再次隐藏导航栏，你就需要重新对这个标志进行设定。
        decorView.setSystemUiVisibility(uiOptions);
    }

    public void hide_navigationELma() {
        View decorView = getWindow().getDecorView();
        // Hide both the navigation bar and the status bar.
        // SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
        // a general rule, you should design your app to hide the status bar whenever you
        // hide the navigation bar.
        //仅仅SYSTEM_UI_FLAG_FULLSCREEN，导航栏还是可见的
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
//		SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION可以让应用的内容显示在导航栏的后面
        decorView.setSystemUiVisibility(uiOptions);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setNavigationBarColor(Color.TRANSPARENT);
        }

    }
}
