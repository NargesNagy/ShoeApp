package com.example.shoeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.shoeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val navController = this.findNavController(R.id.fragmentContainerView)

        val appBarConfiguration = getAppBarConfiguration()
        binding.toolbar.setupWithNavController(navController, getAppBarConfiguration())
        setSupportActionBar(binding.toolbar)

        binding.toolbar.setNavigationOnClickListener { _ ->
            NavigationUI.navigateUp(navController, appBarConfiguration) }


    }
    private fun getAppBarConfiguration(): AppBarConfiguration{
        return AppBarConfiguration(
            setOf(
                R.id.welcomeFragment,
                R.id.shoeListFragment,
                R.id.loginFragment
            )
        )
    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.fragmentContainerView)
        return navController.navigateUp()
    }

}