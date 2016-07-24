package com.androidhuman.example.kotlinandroidextensions

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_extension.*

class ExtensionFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_extension, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        btn_fragment_submit.setOnClickListener {
            tv_fragment_hello.text = "Hello, ${et_fragment_extension.text.toString()}"
        }
    }
}