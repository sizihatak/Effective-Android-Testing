package com.anahoret.effectiveandroidtesting.ui.recipe

import android.os.Bundle

import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.anahoret.effectiveandroidtesting.R
import com.anahoret.effectiveandroidtesting.data.model.RecipeStore
import com.anahoret.effectiveandroidtesting.injection.RecipeApplication

class RecipeActivity : AppCompatActivity(), RecipeContract.View {
    private lateinit var titleView: TextView
    private lateinit var descriptionView: TextView

    companion object {
        const val KEY_ID = "id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)
        titleView = findViewById(R.id.title) as TextView
        descriptionView = findViewById(R.id.description) as TextView

        val id = intent.getStringExtra(KEY_ID)
        val store = RecipeStore(this, "recipes")

        val app = application as RecipeApplication
        val favorites = app.favorites
        val presenter: RecipeContract.Presenter = RecipePresenter(store, this, favorites)
        presenter.loadRecipe(id)

        titleView.setOnClickListener({ presenter.toggleFavorite() })
    }

    override fun setTitle(title: String) {
        titleView.text = title
    }

    override fun setDescription(description: String) {
        descriptionView.text = description
    }

    override fun setFavorites(favorite: Boolean) {
        titleView.isSelected = favorite
    }

    override fun showRecipeNotFound() {
        titleView.visibility = View.GONE
        descriptionView.text = getString(R.string.recipe_not_found)
    }
}