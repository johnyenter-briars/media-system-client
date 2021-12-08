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

interface CountriesService {
    @GET("/rest/v2/all")
    fun listCountries(): Call<List<Country>>
}

data class Country(val name: String, val capital: String, val languages: List<Language>)

data class Language(val name: String)

fun getFileList(): ArrayList<String> {
    val listOfFiles = ArrayList<String>()
    listOfFiles.add("test")
    listOfFiles.add("test")
    var url = "http://localhost:8000/api/list/%2Fhome%2Fjohn%2Fvids"

    val URL_COUNTRY_API = "https://google.com"

    val retro = Retrofit.Builder()
        .baseUrl(URL_COUNTRY_API)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val service = retro.create(CountriesService::class.java)

    val countryRequest = service.listCountries()

    countryRequest.enqueue(object : Callback<List<Country>> {
        override fun onResponse(call: Call<List<Country>>, response: Response<List<Country>>) {
            val allCountry = response.body()
            for (c in allCountry!!)
                Log.v(
                    MainActivity::class.simpleName,
                    "NAME: ${c.name} \n CAPITAL: ${c.capital} \n Language: ${c.languages} "
                )
        }


        override fun onFailure(call: Call<List<Country>>, t: Throwable) {
            Log.i(MainActivity::class.simpleName, "on FAILURE!!!!")
        }

    })

    return listOfFiles
}