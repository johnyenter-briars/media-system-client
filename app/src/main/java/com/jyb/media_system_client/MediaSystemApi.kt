package com.jyb.media_system_client

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import okhttp3.OkHttpClient
import okhttp3.Request
import java.lang.Exception
import retrofit2.Call
import retrofit2.*
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface NetworkService {
    @GET("/rest/v2/all")
    fun doTheNetworkThing(): Call<String>
}

data class Country(val name: String, val capital: String, val languages: List<Language>)

data class Language(val name: String)

fun getFileList(): ArrayList<String> {
    val listOfFiles = ArrayList<String>()
    listOfFiles.add("test")
    listOfFiles.add("test")
    var url = "http://192.168.0.8/api/list/%2Fhome%2Fpi%2Fvids/"

//    val URL_COUNTRY_API = "https://google.com"

    val retro = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val service = retro.create(NetworkService::class.java)

    val countryRequest = service.doTheNetworkThing()

    countryRequest.enqueue(object : Callback<String> {
        override fun onResponse(call: Call<String>, response: Response<String>) {
            val text = response.body()

//            for (c in allCountry!!)
//                Log.v(
//                    MainActivity::class.simpleName,
//                    "NAME: ${c.name} \n CAPITAL: ${c.capital} \n Language: ${c.languages} "
//                )
            var idk = text
        }


        override fun onFailure(call: Call<String>, t: Throwable) {
            Log.i(MainActivity::class.simpleName, "on FAILURE!!!!")
        }

    })

    return listOfFiles
}