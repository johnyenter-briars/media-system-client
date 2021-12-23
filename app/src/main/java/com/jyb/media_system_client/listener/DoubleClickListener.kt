package com.jyb.media_system_client.listener

import android.view.View
import com.jyb.media_system_client.osmc.PlaybackSpeedState
import com.jyb.media_system_client.osmc.setPlayerSpeed

class DoubleClickListener(private val ps: PlaybackSpeedState) : View.OnLongClickListener {

    override fun onLongClick(v: View?): Boolean {
        ps.setSpeed(1)
        setPlayerSpeed(ps.getSpeed())
        return true
    }
}
