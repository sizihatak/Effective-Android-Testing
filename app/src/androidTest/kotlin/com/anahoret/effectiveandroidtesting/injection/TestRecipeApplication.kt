package com.anahoret.effectiveandroidtesting.injection

import com.anahoret.effectiveandroidtesting.data.local.Favorites
import com.anahoret.effectiveandroidtesting.data.local.InMemoryFavorites

class TestRecipeApplication : RecipeApplication() {
    override val favorites: Favorites by lazy {
        InMemoryFavorites()
    }
}