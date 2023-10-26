package com.example.prog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainPage : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)

        drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.title = ""
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()



        if(savedInstanceState == null){
            toolbar.title = "about"
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_countainer, AboutFragment()).commit()
            navigationView.setCheckedItem(R.id.about)

        }


    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                val intent = Intent(this, Authorisation::class.java)
                startActivity(intent)
            }

            R.id.about -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_countainer, AboutFragment()).commit()
            }

            R.id.Search -> {
                Toast.makeText(this, "Это поле ещё в разработке", Toast.LENGTH_SHORT).show()
            }

            R.id.Save -> {
                Toast.makeText(this, "Это поле ещё в разработке", Toast.LENGTH_SHORT).show()
            }

            R.id.See -> {
                Toast.makeText(this, "Это поле ещё в разработке", Toast.LENGTH_SHORT).show()
            }

            R.id.Sync -> {
                Toast.makeText(this, "Это поле ещё в разработке", Toast.LENGTH_SHORT).show()
            }
        }

        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (drawerLayout.isDrawerOpen((GravityCompat.START))){
            drawerLayout.closeDrawer(GravityCompat.START)
        }else{
            onBackPressedDispatcher.onBackPressed()
        }
    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.main_menu, menu)
//        return true
//    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when (item.itemId) {
//            android.R.id.home -> {
//                val intent = Intent(this, Authorisation::class.java)
//                startActivity(intent)
//            }
//
//            R.id.Search -> {
//                Toast.makeText(this, "Это поле ещё в разработке", Toast.LENGTH_SHORT).show()
//            }
//
//            R.id.Save -> {
//                Toast.makeText(this, "Это поле ещё в разработке", Toast.LENGTH_SHORT).show()
//            }
//
//            R.id.See -> {
//                Toast.makeText(this, "Это поле ещё в разработке", Toast.LENGTH_SHORT).show()
//            }
//
//            R.id.Sync -> {
//                Toast.makeText(this, "Это поле ещё в разработке", Toast.LENGTH_SHORT).show()
//            }
//        }
//
//        return true
//    }


}