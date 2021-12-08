package com.jyb.media_system_client

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import okhttp3.OkHttpClient
import okhttp3.*
import okhttp3.Callback
import okhttp3.Response
import java.lang.Exception
import java.io.IOException

private val client = OkHttpClient()

//interface NetworkService {
//    @GET("/api/list/%2Fhome%2Fpi%2Fvids/")
//    fun doTheNetworkThing(): Call<String>
//}

data class Country(val name: String, val capital: String, val languages: List<Language>)

data class Language(val name: String)

fun makeFileListRequest() {
    var url = "http://192.168.0.8"

    val request = Request.Builder()
        .url("$url/api/list/%2Fhome%2Fpi%2Fvids/")
        .build()

    client.newCall(request).enqueue(object : Callback {
        override fun onFailure(call: Call, e: IOException) {
            e.printStackTrace()
        }

        override fun onResponse(call: Call, response: Response) {
            response.use {
                if (!response.isSuccessful) throw IOException("Unexpected code $response")

                var jsonBody = response.body!!.string()

                updateAdapter(jsonBody)
            }
        }
    })
}