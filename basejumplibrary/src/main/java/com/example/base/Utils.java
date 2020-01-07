package com.example.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.example.library.R;

public class Utils {

    private static Context sAppContext;

    public static void startActivity(Activity activity, Class targetName) {
        Intent intent = new Intent(activity, targetName);
        activity.startActivity(intent);
    }

    public static Context getAppContext() {
        return sAppContext;
    }

    public static void setAppContext(Context appContext) {
        sAppContext = appContext;
    }
}
