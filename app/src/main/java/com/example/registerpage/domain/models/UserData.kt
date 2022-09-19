package com.example.registerpage.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "user"
)
data class UserData(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val firstName: String,
    val secondName: String
)