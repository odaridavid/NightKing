package com.gdg.demo.nightking

import android.app.Application
import timber.log.Timber

class NightKingApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}