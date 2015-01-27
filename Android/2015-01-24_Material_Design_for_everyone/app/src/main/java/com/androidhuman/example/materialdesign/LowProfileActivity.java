package com.androidhuman.example.materialdesign;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;


public class LowProfileActivity extends ActionBarActivity {

    Toolbar toolbar;
    Animation animShow;
    Animation animHide;
    ObjectAnimator statusBarAnimator;
    ArgbEvaluator argbEvaluator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_low_profile);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            argbEvaluator = new ArgbEvaluator();
        }

        animShow = AnimationUtils.loadAnimation(this, R.anim.abc_slide_in_top);
        animHide = AnimationUtils.loadAnimation(this, R.anim.abc_slide_out_top);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        findViewById(R.id.toggle).setOnClickListener(new View.OnClickListener() {
            @Override
            @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
            public void onClick(View v) {
                View decorView = getWindow().getDecorView();

                if (toolbar.getVisibility() == View.VISIBLE) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        changeStatusBarBackground(false);
                    } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
                        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE);
                    }
                    toolbar.startAnimation(animHide);
                    toolbar.setVisibility(View.GONE);
                } else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        changeStatusBarBackground(true);
                    } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
                        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
                    }
                    toolbar.setVisibility(View.VISIBLE);
                    toolbar.startAnimation(animShow);
                }
            }
        });
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void changeStatusBarBackground(boolean isToolbarShown) {
        if (statusBarAnimator != null) {
            statusBarAnimator.cancel();
        }

        TypedValue resValue = new TypedValue();
        getTheme().resolveAttribute(R.attr.colorPrimaryDark, resValue, true);

        if (isToolbarShown) {
            statusBarAnimator =
                    ObjectAnimator.ofInt(getWindow(), "statusBarColor", Color.BLACK, resValue.data);
        } else {
            statusBarAnimator =
                    ObjectAnimator.ofInt(getWindow(), "statusBarColor", resValue.data, Color.BLACK);
        }
        statusBarAnimator.setDuration(250);
        statusBarAnimator.setEvaluator(argbEvaluator);
        statusBarAnimator.start();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_low_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
