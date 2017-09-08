package com.anahoret.effectiveandroidtesting.data.local

import android.content.Context
import android.content.res.AssetManager
import java.io.File
import java.io.IOException
import java.io.InputStream

class RecipeStore(context: Context?, directory: String?) {

    var recipies: List<Recipe> = listOf()
    private var mapRecipes: Map<String, Recipe> = emptyMap()

    init {
        if (context != null && directory != null) {
            recipies = getAssetStreams(context.assets, directory)
                    .mapNotNull { RecipeFactory.getRecipeFromAsset(it) }
            mapRecipes = recipies.associateBy({ it.id }, { it })
        }
    }

    private fun getAssetStreams(manager: AssetManager, directory: String): List<InputStream> {
        return getFilesNames(manager, directory)
                .map { File(directory, it) }
                .mapNotNull { manager.open(it.path) }
    }

    private fun getFilesNames(manager: AssetManager, directory: String): Array<String> {
        return try {
            manager.list(directory) ?: emptyArray()
        } catch (e: IOException) {
            emptyArray()
        }
    }

    fun getRecipe(id: String): Recipe? = mapRecipes[id]
}