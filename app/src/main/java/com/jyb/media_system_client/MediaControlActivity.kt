package com.jyb.media_system_client

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.SeekBar
import androidx.core.widget.doOnTextChanged

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

        var textBox = findViewById<EditText>(R.id.EditTextInput)
        textBox.doOnTextChanged { text, start, before, count -> inputText(text.toString()) }
    }

    fun sendText(view: View) {
        var textBox = findViewById<EditText>(R.id.EditTextInput)
        inputSendText(textBox.text.toString())
    }


    fun up(view: View) {
        inputUp()
    }

    fun down(view: View) {
        inputDown()
    }

    fun left(view: View) {
        inputLeft()
    }

    fun right(view: View) {
        inputRight()
    }

    fun executeAction(view: View) {
        inputExecuteAction()
    }

    fun select(view: View) {
        inputSelect()
    }

    fun back(view: View) {
        inputBack()
    }

    fun togglePlayPause(view: View) {
        togglePlayPausePlayer()
    }
}