package com.bondidos.roomhilttest

import javax.inject.Inject

class Repository @Inject constructor(private val room: RoomDao){

    fun insert(user: User){
        room.insert(user)
    }
}
