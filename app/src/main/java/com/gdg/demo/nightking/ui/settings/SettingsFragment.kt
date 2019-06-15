package com.gdg.demo.nightking.ui.settings


import android.os.Bundle
import androidx.preference.ListPreference
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.gdg.demo.nightking.R


class SettingsFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences, rootKey)
        val themePreference: ListPreference? = findPreference(THEME_KEY)
        val themeArrayOptions = resources.getStringArray(R.array.theme_options)
        val themeArrayValues = resources.getStringArray(R.array.theme_values)
        themePreference?.summaryProvider = Preference.SummaryProvider<ListPreference> { preference ->
            when (preference.value) {
                themeArrayValues[0] -> themeArrayOptions[0]
                themeArrayValues[1] -> themeArrayOptions[1]
                themeArrayValues[2] -> themeArrayOptions[2]
                else -> getString(R.string.def)
            }
        }
    }

    companion object {
        const val THEME_KEY = "theme"
    }

}
