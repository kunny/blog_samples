package com.androidhuman.example.studiotesting.test;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import com.androidhuman.example.studiotesting.MainActivity;
import com.androidhuman.example.studiotesting.R;

/**
 * Created by kunny on 4/7/14.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public MainActivityTest(){
        super(MainActivity.class);
    }

    public void testHelloString(){
        Activity activity = getActivity();
        TextView tvHello = (TextView)activity.findViewById(android.R.id.text1);
        assertEquals(activity.getText(R.string.hello_world), tvHello.getText().toString());
    }

}
