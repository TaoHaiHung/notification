package com.example.notisave.ui.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.notisave.MainActivity
import com.example.notisave.databinding.FragmentHomeBinding

class HomeFragment :Fragment() {
    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding= FragmentHomeBinding.inflate(inflater,container,false)
        (activity as MainActivity).handleShowBottomNavigation(false)
        return binding.root


    }
}