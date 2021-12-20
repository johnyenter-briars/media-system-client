package com.jyb.media_system_client

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar

public class VolumeListener : SeekBar.OnSeekBarChangeListener {
    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        setVolume(progress)
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {
    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {
    }

}

public class PlaybackListener : SeekBar.OnSeekBarChangeListener {
    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        seekPlayer(progress)
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {
    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {
    }

}

class MediaControlActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media_control)

        var volumeSlider: SeekBar = findViewById(R.id.VolumeBar)
        var vListener = VolumeListener()
        volumeSlider.setOnSeekBarChangeListener(vListener)

        var playbackSlider: SeekBar = findViewById(R.id.PlaybackBar)
        var pListener = PlaybackListener()
        playbackSlider.setOnSeekBarChangeListener(pListener)
    }


    public fun up(view: View): Unit {
        inputUp()
    }

    public fun down(view: View): Unit {
        inputDown()
    }

    public fun left(view: View): Unit {
        inputLeft()
    }

    public fun right(view: View): Unit {
        inputRight()
    }

    public fun executeAction(view: View): Unit {
        inputExecuteAction()
    }

    public fun select(view: View): Unit {
        inputSelect()
    }

    public fun back(view: View): Unit {
        inputBack()
    }

    public fun togglePlayPause(view: View): Unit {
        togglePlayPausePlayer()
    }
}