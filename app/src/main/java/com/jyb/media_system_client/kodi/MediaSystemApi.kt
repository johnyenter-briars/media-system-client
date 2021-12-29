package com.jyb.media_system_client.kodi

import okhttp3.OkHttpClient
import okhttp3.*
import okhttp3.Callback
import okhttp3.Response
import java.io.IOException

import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody

private val client = OkHttpClient()

val a = { i: Int -> println(i) }

fun postRequest(requestObject: String, apiSettings: KodiApiSettings, callback: (Int) -> Unit) {
    val requestBody = requestObject.toRequestBody("application/json".toMediaTypeOrNull())

    var credential = Credentials.basic(apiSettings.Username, apiSettings.Password);

    val request = Request.Builder()
        .url("http://${apiSettings.IpAddress}:${apiSettings.Port}/jsonrpc")
        .header("Authorization", credential)
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

fun powerSuspend(apiSettings: KodiApiSettings) {
    val requestObject = """
        {
            "jsonrpc": "2.0",
            "method": "System.Suspend",
            "id": 1
        }
    """

    postRequest(requestObject, apiSettings, a)
}

fun powerReboot(apiSettings: KodiApiSettings) {
    val requestObject = """
        {
            "jsonrpc": "2.0",
            "method": "System.Reboot",
            "id": 1
        }
    """

    postRequest(requestObject, apiSettings, a)
}

fun setPlayerSpeed(speed: Int, apiSettings: KodiApiSettings) {
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

    postRequest(requestObject, apiSettings, a)
}

fun inputSendText(text: String, apiSettings: KodiApiSettings) {
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

    postRequest(requestObject, apiSettings, a)
}

fun inputText(text: String, apiSettings: KodiApiSettings) {
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

    postRequest(requestObject, apiSettings, a)
}

fun seekPlayer(percentage: Int, apiSettings: KodiApiSettings) {
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

    postRequest(requestObject, apiSettings, a)
}

fun setVolume(level: Int, apiSettings: KodiApiSettings) {
    val requestObject = """{
        "jsonrpc": "2.0",
        "id": 1,
        "method": "Application.SetVolume",
        "params": {
            "volume": $level
        }
    }"""

    postRequest(requestObject, apiSettings, a)
}


fun inputSelect(apiSettings: KodiApiSettings) {
    val requestObject = """{
        "jsonrpc": "2.0",
        "id": 1,
        "method": "Input.Select"
    }"""

    postRequest(requestObject, apiSettings, a)
}

fun inputBack(apiSettings: KodiApiSettings) {
    val requestObject = """{
        "jsonrpc": "2.0",
        "id": 1,
        "method": "Input.Back"
    }"""

    postRequest(requestObject, apiSettings, a)
}

fun inputExecuteAction(apiSettings: KodiApiSettings) {
    val requestObject = """{
        "jsonrpc": "2.0",
        "id": 1,
        "method": "Input.ExecuteAction"
    }"""

    postRequest(requestObject, apiSettings, a)
}

fun inputLeft(apiSettings: KodiApiSettings) {
    val requestObject = """{
        "jsonrpc": "2.0",
        "id": 1,
        "method": "Input.Left"
    }"""

    postRequest(requestObject, apiSettings, a)
}

fun inputRight(apiSettings: KodiApiSettings) {
    val requestObject = """{
        "jsonrpc": "2.0",
        "id": 1,
        "method": "Input.Right"
    }"""

    postRequest(requestObject, apiSettings, a)
}

fun inputDown(apiSettings: KodiApiSettings) {
    val requestObject = """{
        "jsonrpc": "2.0",
        "id": 1,
        "method": "Input.Down"
    }"""

    postRequest(requestObject, apiSettings, a)
}

fun inputUp(apiSettings: KodiApiSettings) {
    val requestObject = """{
        "jsonrpc": "2.0",
        "id": 1,
        "method": "Input.Up"
    }"""

    postRequest(requestObject, apiSettings, a)
}

fun stopPlayer(apiSettings: KodiApiSettings) {
    val requestObject = """{
        "jsonrpc": "2.0",
        "id": 1,
        "method": "Player.Stop",
        "params": {
            "playerid": 1
        }
    }"""

    postRequest(requestObject, apiSettings, a)
}

fun togglePlayPausePlayer(apiSettings: KodiApiSettings) {
    val requestObject = """{
        "jsonrpc": "2.0",
        "id": 1,
        "method": "Player.PlayPause",
        "params": {
            "playerid": 1
        }
    }"""

    postRequest(requestObject, apiSettings, a)
}

fun testPlayFile(apiSettings: KodiApiSettings) {
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

    postRequest(requestObject, apiSettings, a)
}
