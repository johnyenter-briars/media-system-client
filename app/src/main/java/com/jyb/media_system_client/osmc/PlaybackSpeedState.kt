package com.jyb.media_system_client.osmc

class PlaybackSpeedState {
    private val MAX_FF_SPEED = 8
    private val MAX_RR_SPEED = -8
    private var currSpeed = 0

    fun setSpeed(s: Int){
        currSpeed = s
    }

    fun incSpeed(): Int{
        if (currSpeed != MAX_FF_SPEED) {
            currSpeed += 2
        }
        return currSpeed
    }

    fun decSpeed(): Int{
        if (currSpeed != MAX_RR_SPEED) {
            currSpeed -= 2
        }
        return currSpeed
    }

    fun getSpeed(): Int {
        return currSpeed
    }
}