package com.example.notisave

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.fragment.app.FragmentTransaction
import com.example.notisave.databinding.ActivityMainBinding
import com.example.notisave.ui.Message.GroupMessageFragment
import com.example.notisave.ui.More.MoreFragment
import com.example.notisave.ui.home.HomeFragment
import com.example.notisave.ui.splash.OnboardingFragment
import com.example.notisave.ui.splash.SplashFragment


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val M_RequestCode: Int = 1803
    private lateinit var homeFragment: HomeFragment
    private lateinit var messageFragment: GroupMessageFragment
    private lateinit var moreFragment: MoreFragment
    private lateinit var onboardingFragment: OnboardingFragment
    private lateinit var splashFragment: SplashFragment
    private var currentItem: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

//        if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.frameLayout, NotificationFragment())
//                .commit()
//        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        checkPermission()


//        splashFragment =SplashFragment()
//        supportFragmentManager
//            .beginTransaction()
//            .replace(R.id.frameLayout, splashFragment)
//            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
//            .commit()
//
//
//        handlButtonNavigation()


    }

    fun handleShowBottomNavigation(isShow: Boolean) {
        binding.bottomNavigationView.visibility =
            if (isShow)
                View.VISIBLE
            else View.GONE
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    private fun checkPermission() {
        var listPermission: ArrayList<String> = ArrayList()
        if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.BIND_NOTIFICATION_LISTENER_SERVICE
            )
            == PackageManager.PERMISSION_DENIED
        ) {
            listPermission.add(android.Manifest.permission.BIND_NOTIFICATION_LISTENER_SERVICE)
        }

        if (listPermission.isNotEmpty()) {
            val intent = Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS)
            startActivity(intent)
        } else
            Toast.makeText(this, "dsdsd", Toast.LENGTH_SHORT).show()
    }

    private fun handlButtonNavigation() {
        binding.bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            if (item.itemId != currentItem) {
                when (item.itemId) {
                    R.id.home -> {
                        homeFragment = HomeFragment()
                        supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.frameLayout, homeFragment)
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                            .commit()
                    }

                    R.id.message -> {
                        messageFragment = GroupMessageFragment()
                        supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.frameLayout, messageFragment)
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                            .commit()
                    }

                    R.id.more -> {
                        moreFragment = MoreFragment()
                        supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.frameLayout, moreFragment)
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                            .commit()
                    }

                }
                currentItem = item.itemId
            }
            true
        }

    }


}
