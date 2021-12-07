package com.jyb.media_system_client

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView
import com.example.media_system_client.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    public fun moveToFilesList(view: View): Unit {
        var foo = Intent(this, ListFilesActivity::class.java)

        startActivity(foo)
    }
}