package com.androidhuman.example.kotlinandroidextensions

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_extension.*

class ExtensionActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extension)

        btn_activity_extension.setOnClickListener {
            tv_activity_extension_hello.text =
                    "Hello, ${et_activity_extension_name.text.toString()}"
        }

    }
}