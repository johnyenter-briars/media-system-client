package com.jyb.media_system_client

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.preference.PreferenceManager
import com.jyb.media_system_client.kodi.KodiApiSettings
import com.jyb.media_system_client.kodi.powerReboot
import com.jyb.media_system_client.kodi.powerSuspend


class MainActivity : AppCompatActivity() {
    private val ApiSettings: KodiApiSettings = KodiApiSettings()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun moveToMediaActivity(view: View) {
        startActivity(Intent(this, MediaControlActivity::class.java))
    }

    fun moveToSettingsActivity(view: View) {
        startActivity(Intent(this, SettingsActivity::class.java))
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

    fun sleep(view: View) {
        powerSuspend(updatedApiSettings())
    }

    fun reboot(view: View) {
        powerReboot(updatedApiSettings())
    }
}