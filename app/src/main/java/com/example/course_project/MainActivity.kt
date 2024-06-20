package com.example.course_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var controller: NavController
    private lateinit var bottomNav: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        controller = findNavController(R.id.navHost)

        bottomNav = findViewById(R.id.bottom_nav)

        val toolBar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolBar)

        controller.addOnDestinationChangedListener{_, destination, _ ->
            if (destination.id != R.id.profileFragment
                && destination.id != R.id.contactsFragment
                && destination.id != R.id.servicesFragment) {
                bottomNav.visibility = View.GONE

            }
            else {
                bottomNav.visibility = View.VISIBLE
            }
        }
        bottomNav.setupWithNavController(controller)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.overflow_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        item.onNavDestinationSelected(controller)

        return super.onOptionsItemSelected(item)
    }

}