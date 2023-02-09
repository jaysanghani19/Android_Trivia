package com.example.androidtrivia

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.androidtrivia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        Binding the layout
        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        drawerLayout = binding.drawer


        val navController = this.findNavController(R.id.myNavigation)


        // Configure drawer layout with app bar

        appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)

        // set up Navcontroller and drawerlayout with Navigation controller. so it can navigate both

        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)

        // setting up that if it's titleFragment than open drawerLayout
        // else do not open
        navController.addOnDestinationChangedListener { nc: NavController, nd: NavDestination, bundle: Bundle? ->

            if (nd.id == nc.graph.startDestinationId) {
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
            } else
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        }
        NavigationUI.setupWithNavController(binding.navView, navController)
    }

    // to get back from drawermenu or from other menu
    // setting up for both navcontroller and appbarconfiguration
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavigation)

        return NavigationUI.navigateUp(navController, appBarConfiguration)
    }
}
