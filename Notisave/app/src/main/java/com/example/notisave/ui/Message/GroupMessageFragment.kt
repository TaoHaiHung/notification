package com.example.notisave.ui.Message


import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.notisave.databinding.FragmentGroupMessageBinding


class GroupMessageFragment :Fragment() {
    lateinit var binding :FragmentGroupMessageBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding= FragmentGroupMessageBinding.inflate(inflater,container,false)
        return binding.root

        handleButtonAddGroup()
    }

    private fun handleButtonAddGroup() {
        binding.btnAddGroup.setOnClickListener{


        }
    }
}