package com.anahoret.effectiveandroidtesting.test

import android.content.Intent
import android.support.annotation.StringRes
import android.support.test.InstrumentationRegistry
import android.support.test.rule.ActivityTestRule
import com.anahoret.effectiveandroidtesting.R
import com.anahoret.effectiveandroidtesting.data.local.Favorites
import com.anahoret.effectiveandroidtesting.injection.RecipeApplication
import com.anahoret.effectiveandroidtesting.ui.recipe.RecipeActivity

class RecipeRobot : ScreenRobot() {
    private val favorites: Favorites

    init {
        val app = InstrumentationRegistry.getTargetContext().applicationContext as RecipeApplication
        favorites = app.favorites
        favorites.clearAll()
    }

    fun launch(rule: ActivityTestRule<RecipeActivity>, id: String = ""): RecipeRobot {
        if (id.isEmpty()) {
            rule.launchActivity(null)
        } else {
            val intent = Intent()
            intent.putExtra(RecipeActivity.KEY_ID, id)
            rule.launchActivity(intent)
        }
        return this
    }

    fun noTitle(): RecipeRobot = checkIsHiddend(R.id.title)

    fun description(@StringRes stringId: Int): RecipeRobot =
            checkViewHasText(R.id.description, stringId)

    fun title(string: String): RecipeRobot =
            checkViewHasText(R.id.title, string)

    fun setFavorite(id: String): RecipeRobot {
        favorites.put(id, true)
        return this
    }

    fun clickOnFavorite(): RecipeRobot = clickOn(R.id.title)

    fun isFavorite(): RecipeRobot = checkIsSelected(R.id.title)

    fun isNotFavorite(): RecipeRobot = checkIsNotSelected(R.id.title)
}