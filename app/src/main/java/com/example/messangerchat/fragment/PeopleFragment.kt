package com.example.messangerchat.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.messangerchat.adapter.CustomViewAdapter
import com.example.messangerchat.model.Story
import android.util.DisplayMetrics
import com.example.messangerchat.R


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class PeopleFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    lateinit var root:View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        root = inflater.inflate(R.layout.fragment_people, container, false)

        initViews()

        return root
    }
    fun initViews(){
        refreshAdapter(prepareStoryList())
    }

    private fun refreshAdapter(stories: ArrayList<Story>) {
        var adapter = CustomViewAdapter(stories)

        var recyclerView = root.findViewById<RecyclerView>(R.id.recyclerView_people)

        recyclerView.adapter = adapter
    }

    private fun prepareStoryList(): ArrayList<Story> {
        var stories = ArrayList<Story>()

            stories.add(Story(R.drawable.user_img, "", ""))
            stories.add(Story(R.drawable.user_img_1, "Kucharov Alijon", "1"))
            stories.add(Story(R.drawable.user_img, "Shukurov Sirojiddin", "1"))
            stories.add(Story(R.drawable.user_img, "Murodaliyev Davron", "1"))
            stories.add(Story(R.drawable.user_img, "Pardayev Ma'ruf", "1"))
            stories.add(Story(R.drawable.user_img, "Xolmonov Jonibek", "1"))
            stories.add(Story(R.drawable.user_img, "Saidaxmad", "1"))
            stories.add(Story(R.drawable.user_img, "Asliddin", "1"))
            stories.add(Story(R.drawable.user_img, "Shahriyor", "1"))
            stories.add(Story(R.drawable.user_img, "Quvonch", "1"))
            stories.add(Story(R.drawable.user_img, "Fazliddin", "1"))
            stories.add(Story(R.drawable.user_img, "Sadriddin", "1"))
            stories.add(Story(R.drawable.user_img, "Mehroj", "1"))
            stories.add(Story(R.drawable.user_img, "Jasur", "1"))
            stories.add(Story(R.drawable.user_img, "Yusuf", "1"))


        return stories
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PeopleFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}