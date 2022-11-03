package com.barak.twitterappv3beta.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.barak.twitterappv3beta.R
import com.barak.twitterappv3beta.fragments.HomeFragment
import com.barak.twitterappv3beta.fragments.MyActivityFragment
import com.barak.twitterappv3beta.fragments.SearchFragment
import com.google.android.material.tabs.TabLayout
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    private var sectionsPagerAdapter : SectionPageAdapter? = null
    private val firebaseAuth = FirebaseAuth.getInstance()
    private val homeFragment = HomeFragment()
    private val searchFragment = SearchFragment()
    private val myActivityFragment = MyActivityFragment()
    private val userID = FirebaseAuth.getInstance().currentUser?.uid
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        sectionsPagerAdapter = SectionPageAdapter(supportFragmentManager)
        container.adapter = sectionsPagerAdapter
        container.addOnPageChangeListener(  TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(container))
        tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })
    }


        fun onLogout(v: View) {
        firebaseAuth.signOut()
            startActivity(LoginActivity.newIntent(this))
            finish()

}

    override fun onResume() {
        super.onResume()
        if (userID == null) {
            startActivity(LoginActivity.newIntent(this))
            finish()
        }
    }

    inner class SectionPageAdapter(fa: FragmentManager) : FragmentPagerAdapter(fa) {
        override fun getCount() = 3



        override fun getItem(position: Int): Fragment {
      return when(position) {

          0 -> homeFragment
          1 -> searchFragment
          else -> myActivityFragment
      }
        }

    }


    companion object {
        fun newIntent(context: Context) = Intent(context, HomeActivity::class.java)
    }

}