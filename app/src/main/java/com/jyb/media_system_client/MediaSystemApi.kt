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

//    val URL_COUNTRY_API = "https://google.com"


//    val retro = Retrofit.Builder()
//        .baseUrl(url)
//        .addConverterFactory(MoshiConverterFactory.create())
//        .build()
//
//    val service = retro.create(NetworkService::class.java)
//
//    val countryRequest = service.doTheNetworkThing()
//
//    countryRequest.enqueue(object : Callback<String> {
//        override fun onResponse(call: Call<String>, response: Response<>) {
//            val text = response.body()
//
////            for (c in allCountry!!)
////                Log.v(
////                    MainActivity::class.simpleName,
////                    "NAME: ${c.name} \n CAPITAL: ${c.capital} \n Language: ${c.languages} "
////                )
//            var idk = text
//        }
//
//
//        override fun onFailure(call: Call<String>, t: Throwable) {
//            Log.i(MainActivity::class.simpleName, "on FAILURE!!!!")
//        }
//
//    })
}