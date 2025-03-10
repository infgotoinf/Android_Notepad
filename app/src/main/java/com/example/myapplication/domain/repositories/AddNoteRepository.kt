package com.example.myapplication.domain.repositories

import com.example.myapplication.domain.models.Note

interface AddNoteRepository {
    suspend fun addNote(note: Note)
}