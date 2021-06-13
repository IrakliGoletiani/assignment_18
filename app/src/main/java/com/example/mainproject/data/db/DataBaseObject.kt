package com.example.mainproject.data.db

import androidx.room.Room
import com.example.mainproject.App

object DataBaseObject {

    val db by lazy {
        Room.databaseBuilder(
            App.context!!,
            UserDatabase::class.java, "database-users"
        ).build()
    }

}