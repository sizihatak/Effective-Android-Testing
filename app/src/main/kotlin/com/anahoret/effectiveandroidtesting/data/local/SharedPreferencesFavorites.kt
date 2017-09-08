package com.anahoret.effectiveandroidtesting.data.local

import android.content.Context

class SharedPreferencesFavorites(context: Context) {

    private val pref = context.getSharedPreferences("favorites.xml", Context.MODE_PRIVATE)

    fun get(id: String) = pref.getBoolean(id, false)

    private fun put(id: String, favorite: Boolean) {
        val edit = pref.edit()
        if (favorite) {
            edit.putBoolean(id, true)
        } else {
            edit.remove(id)
        }
        edit.apply()
    }

    fun toogle(id: String):Boolean {
        val favorite = get(id)
        put(id, !favorite)
        return !favorite
    }
}