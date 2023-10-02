package com.example.foodapp

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.adapter.MainCategoryAdapter
import com.example.foodapp.adapter.SubCategoryAdapter
import com.example.foodapp.database.RecipeDatabase
import com.example.foodapp.entities.CategoryItem
import com.example.foodapp.entities.Recipes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeActivity : BaseActivity() {

    lateinit var arrMainCategory:ArrayList<CategoryItem>
    lateinit   var arrSubCategory:ArrayList<Recipes>
    lateinit var mainCategoryAdapter: MainCategoryAdapter
    lateinit var subCategoryAdapter: SubCategoryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)



        arrMainCategory=ArrayList<CategoryItem>()
        arrSubCategory=ArrayList<Recipes>()
        val mainCategoryAdapter=MainCategoryAdapter()
        subCategoryAdapter=SubCategoryAdapter()

            getDataFromDb()
        val mainRecyclearAdapter=findViewById<RecyclerView>(R.id.mainCategoriesRecyclear)


//Tempoerary Data

//        arrMainCategory.add(Recipes(1,"Afang"))
//        arrMainCategory.add(Recipes(2,"Editan"))
//        arrMainCategory.add(Recipes(3,"Afere"))
//        arrMainCategory.add(Recipes(4,"White Soup"))
//        arrMainCategory.add(Recipes(5,"Okro"))
//        mainCategoryAdapter.setData(arrMainCategory)
//


        arrSubCategory.add(Recipes(1,"Rice"))
        arrSubCategory.add(Recipes(2,"Beans"))
        arrSubCategory.add(Recipes(3,"Oil"))
        arrSubCategory.add(Recipes(4,"White Soup4"))
        arrSubCategory.add(Recipes(5,"Eqwusi5"))
        subCategoryAdapter.setData(arrSubCategory)


        var subRecyclearAdapter=findViewById<RecyclerView>(R.id.sub_categories_Recyclear)



        subRecyclearAdapter.layoutManager=
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        subRecyclearAdapter.adapter=subCategoryAdapter


        mainRecyclearAdapter.layoutManager=LinearLayoutManager(this@HomeActivity,LinearLayoutManager.HORIZONTAL,false)
        mainRecyclearAdapter.adapter= mainCategoryAdapter





    }
    private fun getDataFromDb(){
        var  mainCategoryAdapter=MainCategoryAdapter()
        lifecycleScope.launch(Dispatchers.IO) {
            this.let {
                var cat= RecipeDatabase.getDatabase(this@HomeActivity).recipeDao().getAllCategory
                arrMainCategory    = cat as ArrayList<CategoryItem>
                mainCategoryAdapter.setData(arrMainCategory)
                arrMainCategory.reverse()
                var mainRecyclearAdapter=findViewById<RecyclerView>(R.id.mainCategoriesRecyclear)
                mainRecyclearAdapter.layoutManager=LinearLayoutManager(this@HomeActivity,LinearLayoutManager.HORIZONTAL,false)
                mainRecyclearAdapter.adapter= mainCategoryAdapter

            }
        }
    }
}