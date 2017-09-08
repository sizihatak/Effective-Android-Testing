package com.anahoret.effectiveandroidtesting.ui.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.anahoret.effectiveandroidtesting.R
import com.anahoret.effectiveandroidtesting.data.model.RecipeStore

class RecipeAdapter(private val recipeStore: RecipeStore, private val listener: OnRecipeClickListener) : RecyclerView.Adapter<RecipeViewHolder>() {

    interface OnRecipeClickListener {
        fun onClick(position: Int)
    }

    override fun getItemCount(): Int = recipeStore.recipies.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecipeViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        return RecipeViewHolder(layoutInflater.inflate(R.layout.list_item, parent, false), listener)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder?, position: Int) {
        holder?.title?.text = recipeStore.recipies[position].title
    }
}

class RecipeViewHolder(itemView: View, listener: RecipeAdapter.OnRecipeClickListener) : RecyclerView.ViewHolder(itemView) {
    var title: TextView = itemView.findViewById(R.id.name)

    init {
        title.setOnClickListener { listener.onClick(layoutPosition) }
    }
}
