package com.gdg.demo.nightking.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.gdg.demo.nightking.NightKingApplication
import com.gdg.demo.nightking.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navController = findNavController(R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController)
//        val isNight =
//            resources.configuration.uiMode.and(Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES
//        Timber.d("is Night Theme = $isNight")
        (application as NightKingApplication).repo
            .nightModeLive.observe(this, Observer { nightMode ->
            nightMode?.let { theme ->
                when (theme) {
                    "Light" -> {
                        delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_NO
                    }
                    "System" -> {
                        delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
                    }
                    "Dark" -> {
                        delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_YES
                    }
                }

            }
        }
        )
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp()
    }
}
