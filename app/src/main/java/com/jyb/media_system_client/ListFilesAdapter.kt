package com.jyb.media_system_client
import android.widget.ArrayAdapter
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

data class Root(val element: List<Element>)
data class BigRoot(val root: Root)
data class Element(val type: String,
                   val uid: Long,
                   val access_time: String,
                   val gid: Long,
                   val modification_time: String,
                   val name: String,
                   val path: String,
                   val mode: Long,
                   val uri: String,
                   val size: Long,
                   )

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

    var r = mapper.readValue<BigRoot>(jsonString)

    for(element in r.root.element) {
        FilesList.add(element.uri)
    }
}

public class ListFilesAdapter {

}