package com.anahoret.effectiveandroidtesting.data.local


class InMemoryFavorites : Favorites {
    override fun clearAll() {
        map.clear()
    }

    private val map = mutableMapOf<String, Boolean>()

    override fun get(id: String): Boolean = map[id] ?: false

    override fun toogle(id: String): Boolean {
        map[id] = !get(id)
        return !get(id)
    }

    override fun put(id: String, favorite: Boolean) {
        map[id] = favorite
    }
}
