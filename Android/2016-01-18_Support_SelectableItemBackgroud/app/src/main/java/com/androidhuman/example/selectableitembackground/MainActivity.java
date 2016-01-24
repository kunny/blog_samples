package com.androidhuman.example.selectableitembackground;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    FrameLayout flButtonBackground;

    FrameLayout flButtonForeground;

    CardView cvButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flButtonBackground = (FrameLayout) findViewById(R.id.fl_activity_main_background);
        flButtonForeground = (FrameLayout) findViewById(R.id.fl_activity_main_foreground);
        cvButton = (CardView) findViewById(R.id.cv_activity_main);

        flButtonBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "Clicked FrameLayout (Background)", Toast.LENGTH_SHORT)
                        .show();
            }
        });

        flButtonForeground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "Clicked FrameLayout (Foreground)", Toast.LENGTH_SHORT)
                        .show();
            }
        });

        cvButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "Clicked CardView", Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }
}
