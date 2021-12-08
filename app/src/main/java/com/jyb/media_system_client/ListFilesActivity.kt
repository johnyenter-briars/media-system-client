package com.jyb.media_system_client

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView

class ListFilesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_files_activity)

        val listView = findViewById<ListView>(R.id.FilesListView)

        makeFileListRequest()

        initAdapter(FilesList, this)

        listView.adapter = FilesArrayAdapter
    }


    public fun updateList(view: View): Unit {
        FilesArrayAdapter?.addAll(FilesList)
    }
}
