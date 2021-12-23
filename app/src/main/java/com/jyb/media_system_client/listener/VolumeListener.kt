package com.jyb.media_system_client.listener

import android.widget.SeekBar
import com.jyb.media_system_client.osmc.setVolume

class VolumeListener : SeekBar.OnSeekBarChangeListener {
    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        setVolume(progress)
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {
    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {
    }

}
