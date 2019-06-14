package com.gdg.demo.nightking.ui.settings


import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.gdg.demo.nightking.R


class SettingsFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences, rootKey)
    }


}
