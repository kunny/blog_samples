package com.androidhuman.ads.appopenads;

import com.google.android.gms.ads.FullScreenContentCallback;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class SplashActivity extends AppCompatActivity {

    private static final String TAG = "SplashActivity";

    AppOpenAdManager appOpenAdManager;

    private boolean isAdShown = false;

    private boolean isAdDismissed = false;

    private boolean isLoadCompleted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        appOpenAdManager = ((MyApplication) getApplication()).getAppOpenAdManager();

        loadResources();
        appOpenAdManager.showAdIfAvailable(new FullScreenContentCallback() {

            @Override
            public void onAdShowedFullScreenContent() {
                isAdShown = true;
            }

            @Override
            public void onAdDismissedFullScreenContent() {
                isAdDismissed = true;

                if (isLoadCompleted) {
                    launchMainScreen();
                } else {
                    Log.d(TAG, "Waiting resources to be loaded...");
                }
            }
        });
    }

    private void loadResources() {
        // Wait for 5 seconds
        CountDownTimer timer = new CountDownTimer(5000L, 1000L) {
            @Override
            public void onTick(long millisUntilFinished) {
                // Do nothing
            }

            @Override
            public void onFinish() {
                isLoadCompleted = true;

                // Check whether App Open ad was shown or not.
                if (isAdShown) {
                    // Check App Open ad was dismissed or not.
                    if (isAdDismissed) {
                        launchMainScreen();
                    } else {
                        Log.d(TAG, "Waiting for ad to be dismissed...");
                    }
                } else {
                    launchMainScreen();
                }
            }
        };
        timer.start();
    }

    private void launchMainScreen() {
        ActivityCompat.finishAffinity(SplashActivity.this);
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
    }
}
