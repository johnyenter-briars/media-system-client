package com.jyb.media_system_client.osmc

import okhttp3.OkHttpClient
import okhttp3.*
import okhttp3.Callback
import okhttp3.Response
import java.io.IOException

import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody

private val client = OkHttpClient()

const val BaseUrl = "http://192.168.0.6"

val a = { i: Int -> println(i) }

fun postRequest(requestObject: String, callback: (Int) -> Unit) {
    val requestBody = requestObject.toRequestBody("application/json".toMediaTypeOrNull())

    val request = Request.Builder()
        .url("$BaseUrl/jsonrpc")
        .post(requestBody)
        .build()

    client.newCall(request).enqueue(object : Callback {
        override fun onFailure(call: Call, e: IOException) {
            e.printStackTrace()
        }

        override fun onResponse(call: Call, response: Response) {
            response.use {
                if (!response.isSuccessful) throw IOException("Unexpected code $response")

                var jsonBody = response.body!!.string()

                if (callback != null) {
                    callback(5)
                }
            }
        }
    })
}

fun setPlayerSpeed(speed: Int) {
    val requestObject = """
        {
            "jsonrpc": "2.0",
            "id": 1,
            "method": "Player.SetSpeed",
            "params": {
                "playerid": 1,
                "speed": $speed
            }
        }
    """

    postRequest(requestObject, a)
}

fun inputSendText(text: String) {
    val requestObject = """
        {
            "jsonrpc": "2.0",
            "id": 1,
            "method": "Input.SendText",
            "params": {
                "text": "$text",
                "done": true
            }
        }"""

    postRequest(requestObject, a)
}

fun inputText(text: String) {
    val requestObject = """
        {
            "jsonrpc": "2.0",
            "id": 1,
            "method": "Input.SendText",
            "params": {
                "text": "$text",
                "done": false
            }
        }"""

    postRequest(requestObject, a)
}

fun seekPlayer(percentage: Int) {
    val requestObject = """
        {
            "jsonrpc": "2.0",
            "id": 1,
            "method": "Player.Seek",
            "params": {
                "playerid": 1,
                "value": {
                    "percentage": $percentage
                }
            }
        }"""

    postRequest(requestObject, a)
}

fun setVolume(level: Int) {
    val requestObject = """{
        "jsonrpc": "2.0",
        "id": 1,
        "method": "Application.SetVolume",
        "params": {
            "volume": $level
        }
    }"""

    postRequest(requestObject, a)
}


fun inputSelect() {
    val requestObject = """{
        "jsonrpc": "2.0",
        "id": 1,
        "method": "Input.Select"
    }"""

    postRequest(requestObject, a)
}

fun inputBack() {
    val requestObject = """{
        "jsonrpc": "2.0",
        "id": 1,
        "method": "Input.Back"
    }"""

    postRequest(requestObject, a)
}

fun inputExecuteAction() {
    val requestObject = """{
        "jsonrpc": "2.0",
        "id": 1,
        "method": "Input.ExecuteAction"
    }"""

    postRequest(requestObject, a)
}

fun inputLeft() {
    val requestObject = """{
        "jsonrpc": "2.0",
        "id": 1,
        "method": "Input.Left"
    }"""

    postRequest(requestObject, a)
}

fun inputRight() {
    val requestObject = """{
        "jsonrpc": "2.0",
        "id": 1,
        "method": "Input.Right"
    }"""

    postRequest(requestObject, a)
}

fun inputDown() {
    val requestObject = """{
        "jsonrpc": "2.0",
        "id": 1,
        "method": "Input.Down"
    }"""

    postRequest(requestObject, a)
}

fun inputUp() {
    val requestObject = """{
        "jsonrpc": "2.0",
        "id": 1,
        "method": "Input.Up"
    }"""

    postRequest(requestObject, a)
}

fun stopPlayer() {
    val requestObject = """{
        "jsonrpc": "2.0",
        "id": 1,
        "method": "Player.Stop",
        "params": {
            "playerid": 1
        }
    }"""

    postRequest(requestObject, a)
}

fun togglePlayPausePlayer() {
    val requestObject = """{
        "jsonrpc": "2.0",
        "id": 1,
        "method": "Player.PlayPause",
        "params": {
            "playerid": 1
        }
    }"""

    postRequest(requestObject, a)
}

fun testPlayFile() {
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

    postRequest(requestObject, a)
}
