package com.example.messangerchat.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.messangerchat.R
import com.example.messangerchat.model.Chat
import com.example.messangerchat.model.Room
import com.google.android.material.imageview.ShapeableImageView

class ChatAdapter(var context: FragmentActivity, var items: ArrayList<Chat>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val TYPE_ITEM_ROOM = 0
    private val TYPE_ITEM_MESSAGE = 1

    override fun getItemViewType(position: Int): Int {
        var feed = items[position]
        if (feed.rooms.size > 0){
            return TYPE_ITEM_ROOM
        }
        return TYPE_ITEM_MESSAGE
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_ITEM_ROOM){
            var view = LayoutInflater.from(parent.context).inflate(R.layout.item_chat_room, parent, false)
            return RoomViewHolder(view, context)
        }
        return MessageViewHolder(context, LayoutInflater.from(parent.context).inflate(R.layout.item_chat_view, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var message = items[position]

        if (holder is RoomViewHolder){
            var recyclerView = holder.recyclerView

            refreshAdapter(message.rooms, recyclerView)
        }
        if (holder is MessageViewHolder){
            holder.iv_profile_chat.setImageResource(message.messager!!.iv_profile_chat)
            holder.tv_chat_name.text = message.messager!!.tv_chat_name
            if (message.messager!!.profile_online){
                holder.profile_online.visibility = View.VISIBLE
            }else {
                holder.profile_online.visibility = View.GONE
            }
        }
    }

    private fun refreshAdapter(rooms: ArrayList<Room>, recyclerView: RecyclerView) {
        var  adapter = RoomAdapter(context, rooms)

        recyclerView.adapter = adapter
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class RoomViewHolder(view: View, context: FragmentActivity) : RecyclerView.ViewHolder(view) {
        var recyclerView: RecyclerView
        init {
            recyclerView = view.findViewById(R.id.recyclerView)
            val message = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            recyclerView.setLayoutManager(message)
        }
    }

    class MessageViewHolder(context: FragmentActivity, view: View) : RecyclerView.ViewHolder(view) {
        var iv_profile_chat = view.findViewById<ShapeableImageView>(R.id.iv_profile_chat)
        var profile_online = view.findViewById<LinearLayout>(R.id.profile_online)
        var tv_chat_name = view.findViewById<TextView>(R.id.tv_chat_name)
    }
}
