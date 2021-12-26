package com.jyb.media_system_client

import android.content.SharedPreferences
import android.content.SharedPreferences.OnSharedPreferenceChangeListener
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import androidx.core.widget.doOnTextChanged
import androidx.preference.PreferenceManager
import com.jyb.media_system_client.listener.*
import com.jyb.media_system_client.kodi.*


class MediaControlActivity : AppCompatActivity() {
    private val playbackSpeedState = PlaybackSpeedState()
    private val ApiSettings: KodiApiSettings = KodiApiSettings()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_media_control)

        findViewById<Button>(R.id.ButtonPlay)
            .setOnLongClickListener(DoubleClickListener(playbackSpeedState, updatedApiSettings()))

        findViewById<SeekBar>(R.id.VolumeBar).setOnSeekBarChangeListener(VolumeListener(updatedApiSettings()))

        findViewById<SeekBar>(R.id.PlaybackBar).setOnSeekBarChangeListener(PlaybackListener(updatedApiSettings()))

        findViewById<EditText>(R.id.EditTextInput)
            .doOnTextChanged { text, start, before, count -> inputText(text.toString(), updatedApiSettings()) }
    }

    // Should use settings listener - but I couldn't get that to work: https://developer.android.com/guide/topics/ui/settings/use-saved-values
    private fun updatedApiSettings(): KodiApiSettings {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this /* Activity context */)

        ApiSettings.IpAddress = sharedPreferences.getString("media-system-ip", "")!!
        ApiSettings.Port = sharedPreferences.getString("media-system-port", "")!!
        ApiSettings.Username = sharedPreferences.getString("media-system-username", "")!!
        ApiSettings.Password = sharedPreferences.getString("media-system-password", "")!!

        return ApiSettings
    }


    fun rewind(view: View) {
        setPlayerSpeed(playbackSpeedState.decSpeed(), updatedApiSettings())
    }

    fun fastForward(view: View) {
        setPlayerSpeed(playbackSpeedState.incSpeed(), updatedApiSettings())
    }

    fun sendText(view: View) {
        var textBox = findViewById<EditText>(R.id.EditTextInput)
        inputSendText(textBox.text.toString(), updatedApiSettings())
    }

    fun up(view: View) {
        inputUp(updatedApiSettings())
    }

    fun down(view: View) {
        inputDown(updatedApiSettings())
    }

    fun left(view: View) {
        inputLeft(updatedApiSettings())
    }

    fun right(view: View) {
        inputRight(updatedApiSettings())
    }

    fun executeAction(view: View) {
        inputExecuteAction(updatedApiSettings())
    }

    fun select(view: View) {
        inputSelect(updatedApiSettings())
    }

    fun back(view: View) {
        inputBack(updatedApiSettings())
    }

    fun togglePlayPause(view: View) {
        togglePlayPausePlayer(updatedApiSettings())
    }
}