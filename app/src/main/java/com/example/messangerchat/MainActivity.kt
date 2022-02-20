package com.example.messangerchat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.messangerchat.fragment.ChatsFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       initViews()
    }

    private fun initViews() {
        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.frameLayout, PeopleFragment(), "chatsFragment").commit()
    }
}