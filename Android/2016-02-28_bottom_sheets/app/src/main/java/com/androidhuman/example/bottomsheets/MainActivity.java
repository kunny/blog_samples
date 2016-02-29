package com.androidhuman.example.bottomsheets;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout llBottomSheet;

    FloatingActionButton fabButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llBottomSheet = (LinearLayout) findViewById(R.id.bottom_sheet);
        fabButton = (FloatingActionButton) findViewById(R.id.fab);

        // You can also set the peekHeight or hideable from the code
        /*BottomSheetBehavior behavior = BottomSheetBehavior.from(llBottomSheet);
        behavior.setPeekHeight((int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 72.f, getResources().getDisplayMetrics()));
        behavior.setHideable(false);*/


        fabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "FAB clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
