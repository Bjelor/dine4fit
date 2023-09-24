package com.bjelor.dine4fit.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bjelor.dine4fit.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
    }
}
