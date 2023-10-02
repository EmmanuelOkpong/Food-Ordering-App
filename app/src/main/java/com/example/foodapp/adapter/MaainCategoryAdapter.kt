package com.example.foodapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodapp.R
import com.example.foodapp.model.Category

class MainCategoryAdapter: RecyclerView.Adapter<MainCategoryAdapter.RecipeViewHolder>() {


    var cxt: Context?=null
    //for the purpose of learning, note that 'Recipe' was the initial type before it is change to 'categoryItems' type
    var arrMainCateogry = ArrayList<Category>()

    class RecipeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    fun setData(arrData: ArrayList<Category>) {
        arrMainCateogry = arrData as ArrayList<Category>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        cxt=parent.context
        return RecipeViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_main_rv_category, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return arrMainCateogry.size
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.dishNameBTN).text =
            arrMainCateogry[position].categoryName

        Glide.with(cxt!!).load(arrMainCateogry[position]).into(holder.itemView.findViewById(R.id.mainImage))


    }
}