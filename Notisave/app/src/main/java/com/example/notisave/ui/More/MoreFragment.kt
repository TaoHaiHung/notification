package com.example.notisave.ui.More

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notisave.R
import com.example.notisave.databinding.FragmentMoreBinding
import com.example.notisave.ui.More.apdater.MoreAdapter
import com.example.notisave.ui.More.model.MoreModel

class MoreFragment :Fragment() {
    lateinit var binding : FragmentMoreBinding
    private var listMore :List<MoreModel>?=null
    private var moreAdapter :MoreAdapter?=null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding= FragmentMoreBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleDataFilm()

    }

    private fun handleDataFilm() {
        listMore = listOf(
            MoreModel(R.drawable.block_notifications,"Block Notifications") ,
            MoreModel(R.drawable.edit_group,"Edit Group") ,
            MoreModel(R.drawable.settings,"Settings")
        )
        binding.rvMore.apply {
            var layoutParams =
                LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false)
            layoutManager = layoutParams
            moreAdapter = MoreAdapter(listMore)

            adapter = moreAdapter
        }
//        moreAdapter?.onClickItem={
//            var intent = Intent(requireActivity(), PlayVideoActivity::class.java)
//            intent.putExtra("key", it)
//            startActivity(intent)

    }
}
