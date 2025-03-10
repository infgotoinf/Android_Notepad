package com.example.myapplication.data.databases.roomdatabase.roomdao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.data.databases.roomdatabase.models.NoteDto


@Dao
interface NoteDao {

    @Query("SELECT * FROM notes")
    suspend fun getAllNotes(): List<NoteDto>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(userDto: NoteDto)


}