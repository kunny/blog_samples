package com.androidhuman.ads.appopenads;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.appopen.AppOpenAd;

import android.app.Application;

public class MyApplication extends Application {

    private AppOpenAdManager appOpenAdManager;

    @Override
    public void onCreate() {
        super.onCreate();

        MobileAds.initialize(this);

        appOpenAdManager = new AppOpenAdManager
                .Builder(this, AppOpenAdManager.TEST_AD_UNIT_ID)
                .build();
    }

    public AppOpenAdManager getAppOpenAdManager() {
        return this.appOpenAdManager;
    }
}
