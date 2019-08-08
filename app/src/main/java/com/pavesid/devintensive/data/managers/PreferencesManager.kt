package com.pavesid.devintensive.data.managers

import android.content.SharedPreferences
import com.pavesid.devintensive.utils.Devintensive2016Application

class PreferencesManager {

    companion object {
        private const val USER_PHONE_KEY = "USER_PHONE_KEY"
        private const val USER_MAIL_KEY = "USER_MAIL_KEY"
        private const val USER_VK_KEY = "USER_VK_KEY"
        private const val USER_GIT_KEY = "USER_GIT_KEY"
        private const val USER_BIO_KEY = "USER_BIO_KEY"

        var USER_FIELDS: Array<String> = arrayOf(
                USER_PHONE_KEY,
                USER_MAIL_KEY,
                USER_VK_KEY,
                USER_GIT_KEY,
                USER_BIO_KEY)
    }


    lateinit var sharedPreferences: SharedPreferences

    fun PreferencesManager() {
        sharedPreferences = Devintensive2016Application.sharedPreferences
    }

    fun saveUserProfileData(userFields: ArrayList<String?>){
        val editor = sharedPreferences.edit()

        for(i in 0 until USER_FIELDS.size){
            editor.putString(USER_FIELDS[i], userFields[i])
        }

        editor.apply()
    }

    fun loadUserProfileData(): ArrayList<String?>{
        var userFields: ArrayList<String?> = ArrayList()
        for(i in 0 until USER_FIELDS.size) {
            userFields.add(sharedPreferences.getString(USER_FIELDS[i], null))
        }
return  userFields
    }
}