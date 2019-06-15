package com.gdg.demo.nightking

import android.app.Application
import androidx.preference.PreferenceManager
import com.gdg.demo.nightking.prefs.ThemePreference
import timber.log.Timber

class NightKingApplication : Application() {
    lateinit var themePreferenceRepo: ThemePreference
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        themePreferenceRepo = ThemePreference(pref)
    }
}