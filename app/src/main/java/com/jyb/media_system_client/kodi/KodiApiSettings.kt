package com.jyb.media_system_client.kodi

import java.io.Serializable

class KodiApiSettings : Serializable{
    var IpAddress: String = ""
    var Port: String = ""
    var Username: String = ""
    var Password: String = ""
}