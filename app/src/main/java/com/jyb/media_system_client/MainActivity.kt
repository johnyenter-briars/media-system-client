package com.jyb.media_system_client

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun moveToMediaActivity(view: View) {
        startActivity(Intent(this, MediaControlActivity::class.java))
    }

    fun moveToSettingsActivity(view: View) {
        startActivity(Intent(this, SettingsActivity::class.java))
    }
}