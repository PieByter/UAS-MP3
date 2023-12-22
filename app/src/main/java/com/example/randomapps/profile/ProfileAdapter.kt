package com.example.randomapps.profile

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.randomapps.R

class ProfileDataAdapter(private val context: Context, private val dataList: List<ProfileData>) :
    RecyclerView.Adapter<ProfileDataAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profileImage: ImageView = itemView.findViewById(R.id.item_profile_image)
        val usernameTextView: TextView = itemView.findViewById(R.id.item_name)
        val nimTextView: TextView = itemView.findViewById(R.id.item_nim)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.profile_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataList[position]

        // Mengisi data ke tampilan ViewHolder
        holder.profileImage.setImageResource(data.photoResId)
        holder.usernameTextView.text = data.name
        holder.nimTextView.text = data.nim
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}
