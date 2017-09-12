package com.anahoret.effectiveandroidtesting.data.local

import android.content.Context

class SharedPreferencesFavorites(context: Context) : Favorites {
    override fun clearAll() {
        pref.edit().clear().apply()
    }

    private val pref = context.getSharedPreferences("favorites.xml", Context.MODE_PRIVATE)

    override fun get(id: String): Boolean = pref.getBoolean(id, false)

    override fun put(id: String, favorite: Boolean) {
        val edit = pref.edit()
        if (favorite) {
            edit.putBoolean(id, true)
        } else {
            edit.remove(id)
        }
        edit.apply()
    }

    override fun toogle(id: String): Boolean {
        val favorite = get(id)
        put(id, !favorite)
        return !favorite
    }
}