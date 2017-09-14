package com.anahoret.effectiveandroidtesting.ui.recipe

import com.anahoret.effectiveandroidtesting.data.local.Favorites
import com.anahoret.effectiveandroidtesting.data.local.RecipeFactory
import com.anahoret.effectiveandroidtesting.data.model.RecipeStore
import com.nhaarman.mockito_kotlin.*
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentCaptor
import org.mockito.Mockito


class RecipePresenterTest {
    private val recipeStore: RecipeStore = mock()
    private val favorites: Favorites = mock()
    private val view: RecipeContract.View = mock()
    private lateinit var presenter: RecipeContract.Presenter

    @Before
    fun setup() {
        presenter = RecipePresenter(recipeStore, view, favorites)
    }

    @Test
    fun recipeNotFound() {
        val presenter = RecipePresenter(recipeStore, view, favorites)
        whenever(recipeStore.getRecipe(anyOrNull())).thenReturn(null)
        presenter.loadRecipe("no_such_recipe")
        verify(view, times(1)).showRecipeNotFound()
    }

    @Test
    fun loadWaterAndFavorite(){
        val stream = RecipePresenterTest::class.java.getResourceAsStream("/recipes/water.txt")
        val recipe = RecipeFactory.getRecipeFromAsset(stream)

        whenever(recipeStore.getRecipe(Mockito.anyString())).thenReturn(recipe)
        whenever(favorites.toogle(Mockito.anyString())).thenReturn(true)

        presenter.loadRecipe("water")
        presenter.toggleFavorite()

        val argumentCaptor = ArgumentCaptor.forClass(Boolean::class.java)

        verify(view, times(2)).setFavorites(argumentCaptor.capture())
        Assert.assertFalse(argumentCaptor.allValues[0])
        Assert.assertTrue(argumentCaptor.allValues[1])
    }
}