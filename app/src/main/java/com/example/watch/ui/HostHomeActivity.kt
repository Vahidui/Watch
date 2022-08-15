package com.example.watch.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.watch.R
import kotlinx.android.synthetic.main.activity_host_home.*

class HostHomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_host_home)
        val navController =
            supportFragmentManager.findFragmentById(R.id.navigation_fragment) as NavHostFragment
        button_navigation.setupWithNavController(navController.navController)
    }
}