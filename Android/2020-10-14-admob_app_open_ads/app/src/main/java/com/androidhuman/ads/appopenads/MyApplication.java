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

        appOpenAdManager = new AppOpenAdManager(this,
                AppOpenAdManager.TEST_AD_UNIT_ID,
                AppOpenAd.APP_OPEN_AD_ORIENTATION_PORTRAIT);
    }

    public AppOpenAdManager getAppOpenAdManager() {
        return this.appOpenAdManager;
    }
}
