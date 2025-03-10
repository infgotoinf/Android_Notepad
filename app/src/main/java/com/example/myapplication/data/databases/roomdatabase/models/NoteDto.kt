package com.example.myapplication.data.databases.roomdatabase.models

import android.icu.text.DateFormat
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class NoteDto(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val dateCreated: DateFormat,
    val dateLastEdited: DateFormat,
    val data: String,
)