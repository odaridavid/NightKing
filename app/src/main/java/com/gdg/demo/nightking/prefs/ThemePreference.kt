package com.gdg.demo.nightking.prefs

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ThemePreference(private val sharedPreferences: SharedPreferences) {

    private val _appTheme: String?
        get() = sharedPreferences.getString(PREFERENCE_THEME_KEY, PREFERENCE_THEME_DEF_VAL)


    var isDarkTheme: Boolean = false
        get() = _appTheme == "Dark"
        set(value) {
            sharedPreferences
                .edit()
                .putString(
                    PREFERENCE_THEME_KEY,
                    if (value) {
                        "Dark"
                    } else {
                        "Light"
                    }
                ).apply()
            field = value
        }

    private val _isDarkThemeLive: MutableLiveData<Boolean> = MutableLiveData()
    val isDarkThemeLive: LiveData<Boolean>
        get() = _isDarkThemeLive

    private val _nightModeLive: MutableLiveData<String> = MutableLiveData()
    val nightModeLive: LiveData<String>
        get() = _nightModeLive

    private val preferenceChangedListener =
        SharedPreferences.OnSharedPreferenceChangeListener { _, key ->
            when (key) {
                PREFERENCE_THEME_KEY -> {
                    _nightModeLive.value = _appTheme
                    _isDarkThemeLive.value = isDarkTheme
                }
            }
        }

    init {
        _nightModeLive.value = _appTheme
        _isDarkThemeLive.value = isDarkTheme

        sharedPreferences.registerOnSharedPreferenceChangeListener(preferenceChangedListener)
    }

    companion object {
        private const val PREFERENCE_THEME_KEY = "theme"
        private const val PREFERENCE_THEME_DEF_VAL = "System"
    }
}