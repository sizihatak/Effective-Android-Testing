package com.anahoret.effectiveandroidtesting.ui.main

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.anahoret.effectiveandroidtesting.R
import com.anahoret.effectiveandroidtesting.data.model.RecipeStore
import com.anahoret.effectiveandroidtesting.ui.recipe.RecipeActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById(R.id.recipes) as RecyclerView
        val recipeStore = RecipeStore(this, "recipes")
        val adapter = RecipeAdapter(recipeStore, object : RecipeAdapter.OnRecipeClickListener {
            override fun onClick(position: Int) {
                val intent = Intent(this@MainActivity, RecipeActivity::class.java)
                intent.putExtra(RecipeActivity.KEY_ID, recipeStore.recipies[position].id)
                startActivity(intent)
            }
        })
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}