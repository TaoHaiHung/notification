package com.example.notisave.ui.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.notisave.MainActivity
import com.example.notisave.R
import com.example.notisave.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {
    private lateinit var binding: FragmentSplashBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        (activity as MainActivity).handleShowBottomNavigation(false)
        setUpListener()
        return binding.root
    }

    private fun setUpListener() {
        // Sử dụng handler của Fragment thay vì tạo một handler mới
        Handler(Looper.getMainLooper()).postDelayed({
            navigateToOnboardingFragment()
        }, 3000)
    }

    private fun navigateToOnboardingFragment() {
        val onboardingFragment = OnboardingFragment()
        val transaction = requireFragmentManager().beginTransaction()
        // Không cần addToBackStack nếu không muốn thêm transaction vào ngăn xếp
        transaction.replace(R.id.frameLayout, onboardingFragment)
        transaction.commit()
    }
}
