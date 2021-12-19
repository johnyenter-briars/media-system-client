package com.jyb.media_system_client
import android.widget.ArrayAdapter
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

public var FilesArrayAdapter: ArrayAdapter<String>? = null
public var FilesList: ArrayList<String> = ArrayList()
public var rawString: String = ""

public fun initAdapter(col: ArrayList<String>, context: android.content.Context) {
    FilesArrayAdapter = ArrayAdapter(context, R.layout.file_text_view, col)
}

public fun updateAdapter(jsonString: String) {
    FilesList.clear()
    if (FilesArrayAdapter == null) {
        println("um... idk what to do")
    }

    val mapper = jacksonObjectMapper()
    // TODO - get the files list, then call FilesList.add(name) for each file
}

public class ListFilesAdapter {

}