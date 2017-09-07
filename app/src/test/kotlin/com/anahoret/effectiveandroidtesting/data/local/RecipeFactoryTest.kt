package com.anahoret.effectiveandroidtesting.data.local

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class RecipeFactoryTest {
    @Test
    fun water() {
        val stream = RecipeFactoryTest::class.java.getResourceAsStream("/recipes/water.txt")
        val recipe = RecipeFactory.getRecipeFromAsset(stream)
        assertNotNull(recipe)
        assertEquals("water", recipe?.id)
        assertEquals("Water", recipe?.title)
        assertEquals("Put glass under tap. Open tap. Close tap. Drink.", recipe?.description)
    }
}