package com.example.myapplication.data.databases.roomdatabase.repositories.userrepository

import android.util.Log
import com.example.myapplication.data.databases.roomdatabase.database.AppRoomDatabase
import com.example.myapplication.data.databases.roomdatabase.models.NoteDto
import com.example.myapplication.domain.models.Note
import com.example.myapplication.domain.repositories.AddNoteRepository

class AddNoteRepositoryImpl(private val database: AppRoomDatabase): AddNoteRepository {

    private  val noteDao = database.noteDao()

    override suspend fun addNote(note: Note) {
        noteDao.insertNote(NoteDto(
            title = note.title,
            dateCreated =  note.dateCreated,
            dateLastEdited = note.dateLastEdited,
            data = note.data,
        ))
        Log.d("add","added successful")
    }

}