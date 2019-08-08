package com.pavesid.devintensive.utils

import android.app.Application
import android.content.SharedPreferences
import androidx.preference.PreferenceManager

class Devintensive2016Application: Application() {

    companion object {
        lateinit var sharedPreferences: SharedPreferences
    }
    override fun onCreate() {
        super.onCreate()

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
    }

    fun getSharedPreferences(){

    }
}