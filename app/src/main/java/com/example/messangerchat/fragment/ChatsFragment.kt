package com.example.messangerchat.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.messangerchat.R
import com.example.messangerchat.adapter.ChatAdapter
import com.example.messangerchat.model.Chat
import com.example.messangerchat.model.Messager
import com.example.messangerchat.model.Room

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ChatsFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    lateinit var root: View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        root = inflater.inflate(R.layout.fragment_chats, container, false)

        initViews()
        return root
    }

    private fun initViews() {
        var chats = prepareChatList()

        refreshAdapter(chats)
    }

    private fun refreshAdapter(chats: ArrayList<Chat>) {
        var adapter = ChatAdapter(requireActivity(), chats)
        var recyclerView = root.findViewById<RecyclerView>(R.id.recyclerView_main)

        recyclerView.adapter = adapter
    }

    private fun prepareChatList(): ArrayList<Chat> {
        var stories = ArrayList<Room>()

        stories.add(Room(R.drawable.user_img, "Rustamov Odilbek"))
        stories.add(Room(R.drawable.user_img, "Rustamov Odilbek"))
        stories.add(Room(R.drawable.user_img, "Rustamov Odilbek"))
        stories.add(Room(R.drawable.user_img, "Rustamov Odilbek"))
        stories.add(Room(R.drawable.user_img, "Rustamov Odilbek"))
        stories.add(Room(R.drawable.user_img, "Rustamov Odilbek"))
        stories.add(Room(R.drawable.user_img, "Rustamov Odilbek"))
        stories.add(Room(R.drawable.user_img, "Rustamov Odilbek"))
        stories.add(Room(R.drawable.user_img, "Rustamov Odilbek"))
        stories.add(Room(R.drawable.user_img, "Rustamov Odilbek"))

        val chats = ArrayList<Chat>()
        chats.add(Chat(stories))
        chats.add(Chat(Messager(R.drawable.user_img, true, "Rustamov Odilbek")))
        chats.add(Chat(Messager(R.drawable.user_img, false, "Rustamov Odilbek")))
        chats.add(Chat(Messager(R.drawable.user_img, true, "Rustamov Odilbek")))
        chats.add(Chat(Messager(R.drawable.user_img, false, "Rustamov Odilbek")))
        chats.add(Chat(Messager(R.drawable.user_img, true, "Rustamov Odilbek")))
        chats.add(Chat(Messager(R.drawable.user_img, false, "Rustamov Odilbek")))
        chats.add(Chat(Messager(R.drawable.user_img, false, "Rustamov Odilbek")))
        chats.add(Chat(Messager(R.drawable.user_img, false, "Rustamov Odilbek")))
        chats.add(Chat(Messager(R.drawable.user_img, false, "Rustamov Odilbek")))
        chats.add(Chat(Messager(R.drawable.user_img, true, "Rustamov Odilbek")))
        chats.add(Chat(Messager(R.drawable.user_img, false, "Rustamov Odilbek")))
        chats.add(Chat(Messager(R.drawable.user_img, true, "Rustamov Odilbek")))
        chats.add(Chat(Messager(R.drawable.user_img, true, "Rustamov Odilbek")))

        return chats
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ChatsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}