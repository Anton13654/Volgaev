package com.example.volgaev.data.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Favourites")
class Film(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val picture: Int,
    val description: String
)