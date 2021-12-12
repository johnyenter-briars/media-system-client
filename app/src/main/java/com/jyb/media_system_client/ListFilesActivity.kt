package com.jyb.media_system_client

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView

import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import androidx.fragment.app.FragmentActivity


class ListFilesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_files_activity)

        val listView = findViewById<ListView>(R.id.FilesListView)

        initAdapter(FilesList, this)

        listView.adapter = FilesArrayAdapter

//        listView.setOnItemClickListener { parent, view, position, id ->
//            val item = (view as TextView).text.toString()
//            playFile(item)
//        }
    }


    fun updateList(view: View) {
//        makeFileListRequest()
//
//        Handler(Looper.getMainLooper()).postDelayed(
//            {
//                var foo: ArrayList<String> = FilesList.clone() as ArrayList<String>
//                FilesArrayAdapter?.clear()
//                FilesArrayAdapter?.addAll(foo)
//            },
//            2000
//        )
    }

    fun playFile(view: View) {
        testPlayFile()
    }
}
