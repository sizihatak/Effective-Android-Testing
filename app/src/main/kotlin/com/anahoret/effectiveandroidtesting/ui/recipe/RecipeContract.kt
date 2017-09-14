package com.anahoret.effectiveandroidtesting.ui.recipe

interface RecipeContract {

    interface View {
        fun showRecipeNotFound()
        fun setTitle(title: String)
        fun setDescription(description: String)
        fun setFavorites(favorite: Boolean)
    }

    interface Presenter {
        fun toggleFavorite()
        fun loadRecipe(id: String)
    }
}