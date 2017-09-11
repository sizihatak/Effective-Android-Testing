package com.anahoret.effectiveandroidtesting.data.local


class InMemoryFavorites : Favorites {

    private val map = mutableMapOf<String, Boolean>()

    override fun get(id: String): Boolean = map[id] ?: false

    override fun toogle(id: String): Boolean {
        map[id] = !get(id)
        return !get(id)
    }

    fun put(id: String, value: Boolean) = { map[id] = value }

}
