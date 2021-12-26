package com.jyb.media_system_client.listener

import android.view.View
import com.jyb.media_system_client.kodi.KodiApiSettings
import com.jyb.media_system_client.kodi.PlaybackSpeedState
import com.jyb.media_system_client.kodi.setPlayerSpeed

class DoubleClickListener(private val ps: PlaybackSpeedState, private val ApiSettings: KodiApiSettings) : View.OnLongClickListener {

    override fun onLongClick(v: View?): Boolean {
        ps.setSpeed(1)
        setPlayerSpeed(ps.getSpeed(), ApiSettings)
        return true
    }
}
