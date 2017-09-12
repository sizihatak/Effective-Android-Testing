package com.anahoret.effectiveandroidtesting.ui.recipe

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.anahoret.effectiveandroidtesting.R
import com.anahoret.effectiveandroidtesting.test.RecipeRobot
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RecipeActivityTest {
    private val CARROTS_ID: String = "chocolate_pudding"

    @Rule
    @JvmField
    val activityRule: ActivityTestRule<RecipeActivity>
            = ActivityTestRule(RecipeActivity::class.java, true, false)

    @Test
    fun recipeNotFound() {
        RecipeRobot()
                .launch(activityRule)
                .noTitle()
                .description(R.string.recipe_not_found)
    }

    @Test
    fun clickOnFavorite() {
        RecipeRobot().
                launch(activityRule, CARROTS_ID)
                .title("Chocolate Pudding")
                .isNotFavorite()
                .clickOnFavorite()
                .isFavorite()
    }

    @Test
    fun alreadyFavorite() {
        RecipeRobot()
                .setFavorite(CARROTS_ID)
                .launch(activityRule, CARROTS_ID)
                .isFavorite()
    }
}