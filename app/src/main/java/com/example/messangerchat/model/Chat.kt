package com.example.messangerchat.model

class Chat{
    var messager:Messager? = null
    var rooms: ArrayList<Room> = ArrayList()

    constructor(messager: Messager){
        this.messager = messager
    }
    constructor(rooms:ArrayList<Room>){
        this.rooms = rooms
    }
}
