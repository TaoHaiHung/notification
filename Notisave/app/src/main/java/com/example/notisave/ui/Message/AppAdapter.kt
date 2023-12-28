package com.example.coroutine

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.notisave.R

class AppAdapter(private val appList: List<AppInfo>) :
    RecyclerView.Adapter<AppAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val appNameTextView: TextView = itemView.findViewById(R.id.appNameTextView)
        val appIconImageView: ImageView = itemView.findViewById(R.id.appIconImageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_app, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val appInfo = appList[position]
        holder.appNameTextView.text = appInfo.appName
        holder.appIconImageView.setImageDrawable(appInfo.appIcon)
    }

    override fun getItemCount(): Int {
        return appList.size
    }
}
