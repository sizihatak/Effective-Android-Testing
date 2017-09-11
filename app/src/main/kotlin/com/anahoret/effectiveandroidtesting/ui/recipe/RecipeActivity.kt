package com.anahoret.effectiveandroidtesting.ui.recipe

import android.os.Bundle

import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.anahoret.effectiveandroidtesting.R
import com.anahoret.effectiveandroidtesting.data.model.RecipeStore
import com.anahoret.effectiveandroidtesting.injection.RecipeApplication

class RecipeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)
        val titleView = findViewById(R.id.title) as TextView
        val descriptionView = findViewById(R.id.description) as TextView

        val id = intent.getStringExtra(KEY_ID)

        val recipe = RecipeStore(this, "recipes").getRecipe(id)
        if (recipe == null) {
            titleView.visibility = View.GONE
            descriptionView.text = getString(R.string.recipe_not_found)
            return
        }

        val app = application as RecipeApplication
        val pref = app.favorites
        val favorite = pref.get(id)

        val (_, title, description) = recipe
        titleView.text = title
        titleView.isSelected = favorite
        titleView.setOnClickListener({
            titleView.isSelected = pref.toogle(id)
        })
        descriptionView.text = description
    }

    companion object {
        const val KEY_ID = "id"
    }
}