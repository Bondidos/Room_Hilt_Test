package com.bondidos.roomhilttest

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface RoomDao {

    @Insert
    fun insert(user:User)
}
