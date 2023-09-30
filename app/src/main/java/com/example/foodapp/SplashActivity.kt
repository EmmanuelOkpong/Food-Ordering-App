package com.example.foodapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import com.example.foodapp.database.RecipeDatabase
import com.example.foodapp.entities.Category
import com.example.foodapp.interfaces.GetDataServices
import com.example.foodapp.retrofitclient.RetrofitClientInstant
import kotlinx.coroutines.launch
import pub.devrel.easypermissions.AppSettingsDialog
import pub.devrel.easypermissions.EasyPermissions
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SplashActivity : BaseActivity(),EasyPermissions.RationaleCallbacks,EasyPermissions.PermissionCallbacks {
    private var READ_STORAGE_PERM=123
   // lateinit var buttonSplash:Button
 //   EasyPermissions.RationaleCallbacks,EasyPermissions.PermissionCallbacks
    lateinit var buttonSplash:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        buttonSplash = findViewById(R.id.btn_bg)



        buttonSplash.setOnClickListener {
            val intent = Intent(this@SplashActivity, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun getCategories(){

        val service=RetrofitClientInstant.retrofitInstance!!.create(GetDataServices::class.java)
        val call=service.getCategoryList()
        call.enqueue(object: Callback<Category>{
            override fun onFailure(call: Call<Category>, t: Throwable) {
                val loader: ProgressBar = findViewById(R.id.lodder)

                loader.visibility = View.INVISIBLE
                Toast.makeText(this@SplashActivity,"Something Went Wrong", Toast.LENGTH_SHORT)
                    .show()
            }
            override fun onResponse(
                call: Call<Category>,
                 response: Response<Category>
            ) {
                insertDataIntoRoomDb(response.body())
            }
        })
    }

//            }
//
//            )
//        }
//    }



    fun insertDataIntoRoomDb(category:Category?){
        launch {
            this.let {
                RecipeDatabase.getDatabase(this@SplashActivity).recipeDao().clearedDB()
                RecipeDatabase.getDatabase(this@SplashActivity).recipeDao()
                    .insertCategory(category!!)
                buttonSplash.visibility=View.VISIBLE
            }
        }

    }

    private fun hasReadStoragePermission():Boolean{
        return EasyPermissions.hasPermissions(this,android.Manifest.permission.READ_EXTERNAL_STORAGE)
    }
    private fun readStorageTask(){
        if (!hasReadStoragePermission()){
            getCategories()

        }else{
            EasyPermissions.requestPermissions(
                this,
                "THis App needs access tp your storage",
                READ_STORAGE_PERM,
                android.Manifest.permission.READ_EXTERNAL_STORAGE
            )

        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode,permissions,grantResults,this)
    }
    override fun onRationaleAccepted(requestCode: Int) {
        TODO("Not yet implemented")
    }

    override fun onRationaleDenied(requestCode: Int) {
        TODO("Not yet implemented")
    }



    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
        if (EasyPermissions.somePermissionPermanentlyDenied(  this,perms)){
            AppSettingsDialog.Builder(this).build().show()
        }
    }
    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {
        TODO("Not yet implemented")
    }

}

