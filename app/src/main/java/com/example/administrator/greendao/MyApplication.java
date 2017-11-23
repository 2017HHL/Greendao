package com.example.administrator.greendao;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2017/11/23.
 */

public class MyApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getContext(){
        return mContext;
    }
}
