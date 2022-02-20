package com.example.messangerchat.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.messangerchat.R
import com.example.messangerchat.model.Story

class CustomViewAdapter(var stories: ArrayList<Story>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_people_stories_view, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return stories.size
    }

    class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var iv_profile_img = view.findViewById<ImageView>(R.id.iv_profile_img)
        var tv_people_text = view.findViewById<ImageView>(R.id.tv_people_text)
        var tv_people_count = view.findViewById<ImageView>(R.id.tv_people_count)
    }

}
