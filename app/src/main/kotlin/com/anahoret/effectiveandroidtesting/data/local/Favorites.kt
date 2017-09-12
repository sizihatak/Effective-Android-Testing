package com.anahoret.effectiveandroidtesting.data.local

interface Favorites {
    fun get(id: String): Boolean
    fun toogle(id: String): Boolean
    fun clearAll()
    fun put(id: String, favorite: Boolean)
}