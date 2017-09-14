package com.anahoret.effectiveandroidtesting.ui.recipe

import com.anahoret.effectiveandroidtesting.data.local.Favorites
import com.anahoret.effectiveandroidtesting.data.local.Recipe
import com.anahoret.effectiveandroidtesting.data.model.RecipeStore

class RecipePresenter(private val store: RecipeStore, private val view: RecipeContract.View, private val favorites: Favorites) : RecipeContract.Presenter {
    lateinit var recipe: Recipe
    override fun loadRecipe(id: String) {
        val storeResult = store.getRecipe(id)
        if (storeResult == null) {
            view.showRecipeNotFound()
        } else {
            recipe = storeResult
            with(view) {
                setTitle(recipe.title)
                setDescription(recipe.description)
                setFavorites(favorites.get(recipe.id))
            }
        }
    }

    override fun toggleFavorite() {
        view.setFavorites(favorites.toogle(recipe.id))
    }
}