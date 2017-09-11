package com.anahoret.effectiveandroidtesting.ui.recipe

import android.content.Intent
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import com.anahoret.effectiveandroidtesting.R
import org.hamcrest.CoreMatchers.not
import org.junit.Rule
import org.junit.Test


class RecipeActivityTest {
    @get:Rule
    val activityRule: ActivityTestRule<RecipeActivity>
            = ActivityTestRule(RecipeActivity::class.java, true, false)

    @Test
    fun recipeNotFound(){
        activityRule.launchActivity(null)
        onView(withId(R.id.description))
                .check(matches(withText(R.string.recipe_not_found)))
        onView(withId(R.id.title))
                .check(matches(not(isDisplayed())))
    }

    @Test
    fun clickOnFavorite(){
        val intent = Intent()
        intent.putExtra(RecipeActivity.KEY_ID, "chocolate_pudding")
        activityRule.launchActivity(intent)
        onView(withId(R.id.title))
                .check(matches(isDisplayed()))
                .check(matches(withText("Chocolate Pudding")))
                .check(matches(not(isSelected())))
                .perform(ViewActions.click())
                .check(matches(isSelected()))
    }
}