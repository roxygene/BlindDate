package com.roksanagulewska.blinddate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val profileFragment = ProfileFragment()
        val exploreFragment = ExploreFragment()
        val messagesFragment = MessagesFragment()

        supportFragmentManager.beginTransaction().apply() {
            replace(R.id.main_fragment, exploreFragment)
            commit()
        }

        val bottomNavigation = findViewById<NavigationBarView>(R.id.main_bottom_nav)
        bottomNavigation.menu.findItem(R.id.nav_explore).setChecked(true)

        bottomNavigation.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.nav_profile -> setFragment(profileFragment, profileFragment.name)
                R.id.nav_explore -> setFragment(exploreFragment, exploreFragment.name)
                R.id.nav_messages -> setFragment(messagesFragment, messagesFragment.name)
            }
            true
        }
    }

    fun setFragment(fragment: Fragment, nameOfFragment: String) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.main_fragment, fragment)
            addToBackStack(nameOfFragment)
            commit()
        }
    }

}