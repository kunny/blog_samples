package com.androidhuman.example.toolbarsample;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    private void hideInputMethod(Activity activity) {
        final InputMethodManager mng = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        final View focusedView = activity.getCurrentFocus();

        if (focusedView != null) {
            mng.hideSoftInputFromWindow(focusedView.getWindowToken(), 0);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

            final InputMethodManager mng = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            final View focusedView = getCurrentFocus();
            if (focusedView != null) {
                mng.hideSoftInputFromWindow(focusedView.getWindowToken(), 0, new ResultReceiver(new Handler()) {
                    @Override
                    protected void onReceiveResult(int resultCode, Bundle resultData) {
                        super.onReceiveResult(resultCode, resultData);
                        if (resultCode == InputMethodManager.RESULT_UNCHANGED_SHOWN) {
                            Log.d("IME", "IME did not hidden. Trying to hide with application token..");
                            mng.hideSoftInputFromInputMethod(focusedView.getApplicationWindowToken(), 0);
                        } else {
                            Log.d("IME", "IME was hidden.");
                        }

                    }
                });
            }

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
