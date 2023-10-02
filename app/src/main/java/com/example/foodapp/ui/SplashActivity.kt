package com.example.foodapp.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.foodapp.R
import com.example.foodapp.database.RecipeDatabase
import com.example.foodapp.databinding.ActivitySplashBinding
import com.example.foodapp.model.Category
import com.example.foodapp.util.READ_STORAGE_PERM
import kotlinx.coroutines.launch
import pub.devrel.easypermissions.AppSettingsDialog
import pub.devrel.easypermissions.EasyPermissions

class SplashActivity : BaseActivity(),EasyPermissions.RationaleCallbacks,EasyPermissions.PermissionCallbacks {
    private lateinit var binding: ActivitySplashBinding
    private val viewModel: SplashViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)

        binding.getStarted.setOnClickListener {
            getCategories()
        }

        viewModel.categories.observe(this) { response ->
            Log.d("TAG", "categories.observe called")
            if (response.isSuccessful) {
                val data = response.body()
                Log.d("TAG", "All Categories: $data")
                // Process the data here
            } else {
                Toast.makeText(this@SplashActivity, "Error", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun getCategories() {
        viewModel.getCategories()
    }


    fun insertDataIntoRoomDb(category: Category?) {
        launch {
            this.let {
                RecipeDatabase.getDatabase(this@SplashActivity).recipeDao().clearedDB()
                RecipeDatabase.getDatabase(this@SplashActivity).recipeDao()
                    .insertCategory(category!!)
                binding.getStarted.visibility = View.VISIBLE
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

