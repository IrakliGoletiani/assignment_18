package com.example.mainproject.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey (autoGenerate = true)val id: Int,
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String
){
    constructor(
        firstName: String,
        lastName: String,
        email: String,
        password: String) : this(0,firstName,lastName,email,password)
}

