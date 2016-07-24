package com.androidhuman.example.kotlinandroidextensions;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnExtensionActivity;

    private Button btnExtensionFragment;

    private Button btnExtensionRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnExtensionActivity = (Button) findViewById(R.id.btn_activity_main_activity);
        btnExtensionFragment = (Button) findViewById(R.id.btn_activity_main_fragment);
        btnExtensionRecyclerView = (Button) findViewById(R.id.btn_activity_main_recyclerview);

        btnExtensionActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ExtensionActivity.class));
            }
        });

        btnExtensionFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ExtensionFragmentActivity.class));
            }
        });

        btnExtensionRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ExtensionRecyclerViewActivity.class));
            }
        });

    }
}
