package com.jyb.media_system_client

import okhttp3.OkHttpClient
import okhttp3.*
import okhttp3.Callback
import okhttp3.Response
import java.io.IOException
import okhttp3.FormBody

import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody


private val client = OkHttpClient()

//interface NetworkService {
//    @GET("/api/list/%2Fhome%2Fpi%2Fvids/")
//    fun doTheNetworkThing(): Call<String>
//}

data class Country(val name: String, val capital: String, val languages: List<Language>)

data class Language(val name: String)

const val BaseUrl = "http://192.168.0.8"

//fun makeFileListRequest() {
////    var path = "api/list/%2Fhome%2Fjohn%2Fvids/"
//    var path = "api/list/%2Fmnt%2Fmedia%2Fvids"
//
//    val request = Request.Builder()
//        .url("$BaseUrl/$path")
//        .build()
//
//    client.newCall(request).enqueue(object : Callback {
//        override fun onFailure(call: Call, e: IOException) {
//            e.printStackTrace()
//        }
//
//        override fun onResponse(call: Call, response: Response) {
//            response.use {
//                if (!response.isSuccessful) throw IOException("Unexpected code $response")
//
//                var jsonBody = response.body!!.string()
//
//                updateAdapter(jsonBody)
//            }
//        }
//    })
//}

fun testPlayFile() {
    val baseUrl = "http://192.168.0.10/jsonrpc"
    val requestObject = """{
    "jsonrpc": "2.0",
    "id": 1,
    "method": "Player.Open",
    "params": {
        "item": {
            "file": "/media/John_Stuff/vids/Benedetta 2021 French 1080p BluRay HEVC x265 5.1 BONE.mkv"
        }
    }
}"""

    val requestBody = requestObject.toRequestBody("application/json".toMediaTypeOrNull())

    val request = Request.Builder()
        .url(baseUrl)
        .post(requestBody)
        .build()

    client.newCall(request).enqueue(object : Callback {
        override fun onFailure(call: Call, e: IOException) {
            e.printStackTrace()
        }

        override fun onResponse(call: Call, response: Response) {
            response.use {
                if (!response.isSuccessful) {
                    var idk = "test"

                }

                var jsonBody = response.body!!.string()
            }
        }
    })

}

//fun playFile(fileName: String){
//    val path = "api/play/"
//
////    var encodedFileName = fileName.replace(":", "%3A").replace("/", "%2F")
//    var encodedFileName = fileName.replace("file://", "").replace("/", "%2F")
//
//    val formBody: RequestBody = FormBody.Builder()
//        .build()
//
//    var idk = "$BaseUrl/$path$encodedFileName"
//
//    val request = Request.Builder()
//        .url("$BaseUrl/$path$encodedFileName")
//        .post(formBody)
//        .build()
//
//    client.newCall(request).enqueue(object : Callback {
//        override fun onFailure(call: Call, e: IOException) {
//            e.printStackTrace()
//        }
//
//        override fun onResponse(call: Call, response: Response) {
//            response.use {
//                if (!response.isSuccessful) throw IOException("Unexpected code $response")
//
//                var jsonBody = response.body!!.string()
//            }
//        }
//    })
//}