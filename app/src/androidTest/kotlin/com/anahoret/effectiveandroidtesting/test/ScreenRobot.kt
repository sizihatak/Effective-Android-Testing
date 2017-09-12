package com.anahoret.effectiveandroidtesting.test

import android.support.annotation.IdRes
import android.support.annotation.StringRes
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.CoreMatchers.not


abstract class ScreenRobot {
    fun <T : ScreenRobot> checkIsHiddend(@IdRes vararg viewIds: Int): T {
        for (viewId in viewIds) {
            onView(withId(viewId))
                    .check(matches(not(isDisplayed())))
        }
        return this as T
    }

    fun <T : ScreenRobot> checkViewHasText(@IdRes viewId: Int, @StringRes stringId: Int): T {
        onView(withId(viewId)).check(matches(withText(stringId)))
        return this as T
    }

    fun <T : ScreenRobot> checkViewHasText(@IdRes viewId: Int, string: String): T {
        onView(withId(viewId)).check(matches(withText(string)))
        return this as T
    }

    fun <T : ScreenRobot> checkIsSelected(@IdRes vararg viewIds: Int): T {
        for (viewId in viewIds) {
            onView(withId(viewId))
                    .check(matches(isSelected()))
        }
        return this as T
    }

    fun <T : ScreenRobot> checkIsNotSelected(@IdRes vararg viewIds: Int): T {
        for (viewId in viewIds) {
            onView(withId(viewId))
                    .check(matches(not(isSelected())))
        }
        return this as T
    }

    fun <T : ScreenRobot> clickOn(@IdRes viewId: Int): T {
        onView(withId(viewId)).perform(ViewActions.click())
        return this as T
    }
}