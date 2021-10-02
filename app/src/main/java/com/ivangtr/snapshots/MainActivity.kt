package com.ivangtr.snapshots

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.ivangtr.snapshots.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding : ActivityMainBinding
    private lateinit var mActivityFragment: Fragment
    private lateinit var mFragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        setUpBottomNav()

    }

    private fun setUpBottomNav(){
        mFragmentManager = supportFragmentManager

        val homeFragment = HomeFragment()
        val addFragment = AddFragment()
        val profileFragment = ProfileFragment()

        mActivityFragment = homeFragment

        mFragmentManager
            .beginTransaction()
            .add(R.id.hostFragment, profileFragment, profileFragment::class.java.name)
            .hide(profileFragment)
            .commit()
        mFragmentManager
            .beginTransaction()
            .add(R.id.hostFragment, addFragment, addFragment::class.java.name)
            .hide(addFragment)
            .commit()
        mFragmentManager
            .beginTransaction()
            .add(R.id.hostFragment, homeFragment, homeFragment::class.java.name)
            .commit()
    }
}


