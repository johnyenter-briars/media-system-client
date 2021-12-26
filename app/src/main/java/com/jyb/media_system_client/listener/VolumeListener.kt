package com.jyb.media_system_client.listener

import android.widget.SeekBar
import com.jyb.media_system_client.kodi.KodiApiSettings
import com.jyb.media_system_client.kodi.setVolume

class VolumeListener(private val ApiSettings: KodiApiSettings) : SeekBar.OnSeekBarChangeListener {
    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        setVolume(progress, ApiSettings)
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {
    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {
    }

}
