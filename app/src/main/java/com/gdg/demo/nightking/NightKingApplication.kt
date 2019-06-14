package com.gdg.demo.nightking

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate

class NightKingApplication : Application() {
    override fun onCreate() {
        super.onCreate()
//        TODO 1. Tell AppCompat What Mode To Use from available modes
//        MODE_NIGHT_YES
//        MODE_NIGHT_NO
//        MODE_NIGHT_AUTO_BATTERY
//        MODE_NIGHT_FOLLOW_SYSTEM
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY)
    }
}