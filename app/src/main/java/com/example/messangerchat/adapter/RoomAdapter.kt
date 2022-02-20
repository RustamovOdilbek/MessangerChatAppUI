package com.example.messangerchat.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.messangerchat.R
import com.example.messangerchat.model.Room

class RoomAdapter(var context: FragmentActivity, var rooms: ArrayList<Room>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object{
        private val TYPE_ITEM_EMPTY = 0
        private val TYPE_ITEM_VIEW = 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) TYPE_ITEM_EMPTY else TYPE_ITEM_VIEW
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_ITEM_EMPTY){
            var view = LayoutInflater.from(parent.context).inflate(R.layout.item_room_view_empty, parent, false)
            return RoomEmptyViewHolder(view)
        }
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_room_view, parent, false)
        return RoomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var room = rooms[position]
        if (holder is RoomViewHolder){
            holder.iv_profile_room.setImageResource(room.iv_profile_room)
            holder.tv_room_name.text = room.tv_room_name
        }
    }

    override fun getItemCount(): Int {
        return rooms.size
    }
    class RoomViewHolder(view: View): RecyclerView.ViewHolder(view){
        var iv_profile_room = view.findViewById<ImageView>(R.id.iv_profile_room)
        var tv_room_name = view.findViewById<TextView>(R.id.tv_room_name)
    }


    class RoomEmptyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

}
