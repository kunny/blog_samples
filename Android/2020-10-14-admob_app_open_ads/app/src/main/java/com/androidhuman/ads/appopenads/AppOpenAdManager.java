package com.androidhuman.ads.appopenads;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.appopen.AppOpenAd;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import androidx.annotation.IntDef;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AppOpenAdManager extends AppOpenAd.AppOpenAdLoadCallback
        implements Application.ActivityLifecycleCallbacks {

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({AppOpenAd.APP_OPEN_AD_ORIENTATION_PORTRAIT,
            AppOpenAd.APP_OPEN_AD_ORIENTATION_LANDSCAPE})
    public @interface AdOrientation {

    }

    @Retention(RetentionPolicy.SOURCE)
    @IntRange(from = 0L, to = MAX_AD_EXPIRY_DURATION)
    public @interface AdExpiryDuration {

    }

    public static class Builder {

        private final Application application;

        private final String adUnitId;

        @AdOrientation
        private int orientation = AppOpenAd.APP_OPEN_AD_ORIENTATION_PORTRAIT;

        @AdExpiryDuration
        private long adExpiryDuration = MAX_AD_EXPIRY_DURATION;

        private AdRequest adRequest = new AdRequest.Builder().build();

        public Builder(@NonNull Application application, @NonNull String adUnitId) {
            this.application = application;
            this.adUnitId = adUnitId;
        }

        public Builder setOrientation(@AdOrientation int orientation) {
            this.orientation = orientation;
            return this;
        }

        public Builder setAdExpiryDuration(@AdExpiryDuration long duration) {
            this.adExpiryDuration = duration;
            return this;
        }

        public Builder setAdRequest(@NonNull AdRequest request) {
            this.adRequest = request;
            return this;
        }

        public AppOpenAdManager build() {
            return new AppOpenAdManager(this);
        }
    }

    public static final String TEST_AD_UNIT_ID = "ca-app-pub-3940256099942544/1033173712";

    public static final long MAX_AD_EXPIRY_DURATION = 3600000 * 4;

    private static final String TAG = "AppOpenManager";

    private final Application application;

    private final String adUnitId;

    private final int orientation;

    private final long adExpiryDuration;

    private final AdRequest adRequest;

    private Activity mostCurrentActivity;

    private AppOpenAd ad;

    private boolean isShowingAd = false;

    private long lastAdFetchTime = 0L;

    private AppOpenAdManager(Builder builder) {
        this.application = builder.application;
        this.adUnitId = builder.adUnitId;
        this.orientation = builder.orientation;
        this.adExpiryDuration = builder.adExpiryDuration;
        this.adRequest = builder.adRequest;

        // Used to keep track of most recent activity.
        this.application.registerActivityLifecycleCallbacks(this);
    }

    public void showAdIfAvailable() {
        showAdIfAvailable(null);
    }

    public void showAdIfAvailable(@Nullable final FullScreenContentCallback listener) {
        if (this.isShowingAd) {
            Log.e(TAG, "Can't show the ad: Already showing the ad");
            return;
        }

        if (!isAdAvailable()) {
            Log.d(TAG, "Can't show the ad: Ad not available");
            fetchAd();
            return;
        }

        FullScreenContentCallback callback = new FullScreenContentCallback() {
            @Override
            public void onAdFailedToShowFullScreenContent(AdError error) {
                if (listener != null) {
                    listener.onAdFailedToShowFullScreenContent(error);
                }
            }

            @Override
            public void onAdShowedFullScreenContent() {
                if (listener != null) {
                    listener.onAdShowedFullScreenContent();
                }
                AppOpenAdManager.this.isShowingAd = true;
            }

            @Override
            public void onAdDismissedFullScreenContent() {
                if (listener != null) {
                    listener.onAdDismissedFullScreenContent();
                }
                isShowingAd = false;
                AppOpenAdManager.this.ad = null;
                fetchAd();
            }
        };

        ad.show(mostCurrentActivity, callback);
    }

    private void fetchAd() {
        if (isAdAvailable()) {
            return;
        }

        AppOpenAd.load(application, adUnitId, adRequest, orientation, this);
    }

    private boolean isAdAvailable() {
        return this.ad != null && !isAdExpired();
    }

    private boolean isAdExpired() {
        return System.currentTimeMillis() - lastAdFetchTime > adExpiryDuration;
    }

    // AppOpenAd.AppOpenAdLoadCallback implementations

    @Override
    public void onAppOpenAdLoaded(AppOpenAd ad) {
        Log.d(TAG, "Ad loaded");
        this.lastAdFetchTime = System.currentTimeMillis();
        this.ad = ad;
    }

    @Override
    public void onAppOpenAdFailedToLoad(LoadAdError error) {
        Log.d(TAG, "Failed to load an ad: " + error.getMessage());
    }

    // Application.ActivityLifecycleCallbacks implementations

    @Override
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {
        // Do nothing
    }

    @Override
    public void onActivityStarted(@NonNull Activity activity) {
        // Do nothing
    }

    @Override
    public void onActivityResumed(@NonNull Activity activity) {
        this.mostCurrentActivity = activity;
    }

    @Override
    public void onActivityPaused(@NonNull Activity activity) {
        // Do nothing
    }

    @Override
    public void onActivityStopped(@NonNull Activity activity) {
        // Do nothing
    }

    @Override
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {
        // Do nothing
    }

    @Override
    public void onActivityDestroyed(@NonNull Activity activity) {
        // Do nothing
    }
}
