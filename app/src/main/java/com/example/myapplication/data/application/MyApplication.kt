package com.example.myapplication.data.application

import android.app.Application
import com.example.myapplication.data.databases.roomdatabase.database.AppRoomDatabase
import com.example.myapplication.data.databases.roomdatabase.repositories.userrepository.AddNoteRepositoryImpl
import com.example.myapplication.data.databases.roomdatabase.repositories.userrepository.GetNoteRepositoryImpl
import com.example.myapplication.domain.repositories.AddNoteRepository
import com.example.myapplication.domain.repositories.GetNotesRepository

class MyApplication: Application() {

   private val database: AppRoomDatabase by lazy { AppRoomDatabase.getInstance(this) }
   val getNoteRepositoryImpl: GetNotesRepository by lazy { GetNoteRepositoryImpl(database) }
   val addNoteRepositoryImpl: AddNoteRepository by lazy { AddNoteRepositoryImpl(database) }
}