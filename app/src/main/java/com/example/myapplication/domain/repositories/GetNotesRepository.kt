package com.example.myapplication.domain.repositories

import com.example.myapplication.domain.models.Note


interface GetNotesRepository {

    suspend fun getNotes(): List<Note>

}