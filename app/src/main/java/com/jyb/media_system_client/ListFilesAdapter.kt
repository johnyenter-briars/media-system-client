package com.jyb.media_system_client

import android.database.DataSetObserver
import org.json.JSONException
import org.json.JSONObject
import android.widget.ArrayAdapter
//import kotlinx.serialization.*
//import kotlinx.serialization.json.JSON
//
//@Serializable
//data class MyModel(val a: Int, @Optional val b: String = "42")
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

data class Root(val element: List<Element>)
data class BigRoot(val root: Root)
data class Element(val type: String,
                   val uid: Int,
                   val access_time: String,
                   val gid: Int,
                   val modification_time: String,
                   val name: String,
                   val path: String,
                   val mode: Int,
                   val uri: String,
                   val size: Int,
                   )


//class Response(json: String) : JSONObject(json) {
//    val type: String? = this.optString("type")
//    val data = this.optJSONArray("data")
//        ?.let { 0.until(it.length()).map { i -> it.optJSONObject(i) } } // returns an array of JSONObject
//        ?.map { Root(it.toString()) } // transforms each JSONObject of the array into Foo
//}

class Foo(json: String) : JSONObject(json) {
    val id = this.optInt("id")
    val title: String? = this.optString("title")
}
//class Root(json: String) : JSONObject(json) {
//    val elements: List<Element>  = this.opt("element") as List<Element>
//}
//class Element(json: String) : JSONObject(json) {
//    val type = this.optString("title")
//    val uid = this.optInt("title")
//}

public var FilesArrayAdapter: ArrayAdapter<String>? = null
public var rawString: String = ""

public fun initAdapter(col: ArrayList<String>, context: android.content.Context) {
    FilesArrayAdapter = ArrayAdapter(context, R.layout.file_text_view, col)
}

public fun updateAdapter(jsonString: String) {
    if (FilesArrayAdapter == null) {
        println("um... idk what to do")
    }
    val json = """{"name": "bezkoder", "age": "26", "messages" : ["hello","becoming zKoder"]}"""
    val mapper = jacksonObjectMapper()

    println("=== JSON to Kotlin Object ===")
    println("1- read String")
    var r = mapper.readValue<BigRoot>(jsonString)

    var idk = r.root.element[0].uid


}

public class ListFilesAdapter {

}