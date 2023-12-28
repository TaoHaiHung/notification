package com.example.notisave.ui.Notification

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notisave.R
import com.example.notisave.adapter.NotificationAdapter
import com.example.notisave.databinding.FragmentNotificationBinding
import com.example.notisave.viewmodel.NotificationViewModel

// NotificationFragment.kt
class NotificationFragment : Fragment() {
    private lateinit var viewModel: NotificationViewModel
    private lateinit var recyclerView: RecyclerView

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_notification, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val adapter = NotificationAdapter(emptyList())
        recyclerView.adapter = adapter

        viewModel = ViewModelProvider(this).get(NotificationViewModel::class.java)
        viewModel.allNotifications.observe(viewLifecycleOwner) { notifications ->
            adapter.notifications = notifications
            adapter.notifyDataSetChanged()
        }

        return view
    }
}
