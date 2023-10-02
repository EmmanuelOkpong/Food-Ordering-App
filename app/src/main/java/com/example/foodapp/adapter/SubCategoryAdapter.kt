package com.example.foodapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.R
import com.example.foodapp.model.Recipes

class SubCategoryAdapter: RecyclerView.Adapter<SubCategoryAdapter.RecipeViewHolder>() {
        

    //for the purpose of learning, note that 'Recipe' was the initial type before it is change to 'categoryItems' type
    var arrSubCateogry = ArrayList<Recipes>()

    class RecipeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    fun setData(arrData: ArrayList<Recipes>) {
        arrSubCateogry = arrData as ArrayList<Recipes>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {

        return RecipeViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.sub_rv_categories, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return arrSubCateogry.size
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.dishNamesub).text =
            arrSubCateogry[position].dishName
    }
}