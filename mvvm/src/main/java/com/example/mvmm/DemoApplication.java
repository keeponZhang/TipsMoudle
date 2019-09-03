package com.example.mvmm;

import android.app.Application;
import android.databinding.DataBindingUtil;

import com.example.mvmm.component.ProductionComponent;


/**
 * @author markzhai on 16/7/22
 * @version 1.3.0
 */
public class DemoApplication extends Application {

    public static boolean isTest = true;

    @Override
    public void onCreate() {
        super.onCreate();
        DataBindingUtil.setDefaultComponent(new ProductionComponent());
    }
}
