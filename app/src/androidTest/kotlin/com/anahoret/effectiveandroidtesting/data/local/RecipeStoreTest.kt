package com.anahoret.effectiveandroidtesting.data.local

import android.content.Context
import android.support.test.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class RecipeStoreTest{
    @Test
    fun nullDirectory(){
        val context: Context? = InstrumentationRegistry.getTargetContext()
        val recipeStore = RecipeStore(context, null)
        assertNotNull(recipeStore)
        assertNotNull(recipeStore.recipies)
        assertEquals(0, recipeStore.recipies.size)
    }

    @Test
    fun count(){
        val context: Context? = InstrumentationRegistry.getTargetContext()
        val recipeStore = RecipeStore(context, "recipes")
        assertNotNull(recipeStore)
        assertNotNull(recipeStore.recipies)
        assertEquals(4, recipeStore.recipies.size)
    }

    @Test
    fun getChocolatePudding(){
        val context: Context? = InstrumentationRegistry.getTargetContext()
        val recipeStore = RecipeStore(context, "recipes")
        val recipe = recipeStore.getRecipe("chocolate_pudding")
        assertNotNull(recipe)
        assertEquals("Chocolate Pudding", recipe!!.title)
    }
}