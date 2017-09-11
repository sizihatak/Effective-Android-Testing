package com.anahoret.effectiveandroidtesting.data.local

interface Favorites {
    fun get(id: String): Boolean
    fun toogle(id: String): Boolean
}