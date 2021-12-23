package com.jyb.media_system_client

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import androidx.core.widget.doOnTextChanged
import com.jyb.media_system_client.listener.*
import com.jyb.media_system_client.osmc.*


class MediaControlActivity : AppCompatActivity() {
    private val playbackSpeedState = PlaybackSpeedState()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_media_control)

        findViewById<Button>(R.id.ButtonPlay)
            .setOnLongClickListener(DoubleClickListener(playbackSpeedState))

        findViewById<SeekBar>(R.id.VolumeBar).setOnSeekBarChangeListener(VolumeListener())

        findViewById<SeekBar>(R.id.PlaybackBar).setOnSeekBarChangeListener(PlaybackListener())

        findViewById<EditText>(R.id.EditTextInput)
            .doOnTextChanged { text, start, before, count -> inputText(text.toString()) }
    }

    fun rewind(view: View) {
        setPlayerSpeed(playbackSpeedState.decSpeed())
    }

    fun fastForward(view: View) {
        setPlayerSpeed(playbackSpeedState.incSpeed())
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