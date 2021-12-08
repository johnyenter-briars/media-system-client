package com.jyb.media_system_client

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class ListFilesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_files_activity)

        val listView = findViewById<ListView>(R.id.FilesListView)

        var arrayAdapter = ArrayAdapter(this, R.layout.file_text_view, getFileList())
        listView.adapter = arrayAdapter
    }
}
