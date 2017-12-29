package com.ianleshan.serialpast

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v7.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), DateFragment.OnFragmentInteractionListener{

    override fun onFragmentInteraction(uri: Uri) {
        print("Hello");
    }

    lateinit var pagerAdapter :ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        pagerAdapter = ViewPagerAdapter(supportFragmentManager)
        viewPager.adapter = pagerAdapter

        fab.setOnClickListener { view ->
            val intent = Intent(this, AddEntry::class.java)
            startActivity(intent)
        }
    }

}

class ViewPagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment {
        return DateFragment()
    }

    override fun getCount(): Int {
        return 4
    }

}
