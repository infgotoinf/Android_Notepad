package com.example.myapplication.data.databases.roomdatabase.repositories.userrepository

import com.example.myapplication.data.databases.roomdatabase.database.AppRoomDatabase

import com.example.myapplication.domain.models.Note
import com.example.myapplication.domain.repositories.GetNotesRepository

class GetNoteRepositoryImpl(private val database: AppRoomDatabase): GetNotesRepository {

    private  val noteDao = database.noteDao()


    override suspend fun getNotes(): List<Note> {
        val listNotes = noteDao.getAllNotes()

        return listNotes.map{ dto ->
            Note(title = dto.title,
                dateCreated =  dto.dateCreated,
                dateLastEdited = dto.dateLastEdited,
                data = dto.data,
            )
        }
    }



}