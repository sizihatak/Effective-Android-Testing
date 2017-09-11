package com.anahoret.effectiveandroidtesting.injection

import android.app.Application
import com.anahoret.effectiveandroidtesting.data.local.Favorites
import com.anahoret.effectiveandroidtesting.data.local.SharedPreferencesFavorites

open class RecipeApplication : Application() {
    open val favorites: Favorites by lazy {
        SharedPreferencesFavorites(this)
    }
}