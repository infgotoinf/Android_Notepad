package com.example.myapplication.domain.usecases

import com.example.myapplication.domain.models.Note
import com.example.myapplication.domain.repositories.AddNoteRepository

class AddNoteUseCase(private val addNoteRepository: AddNoteRepository) {

    suspend operator fun invoke(note: Note){
        addNoteRepository.addNote(note)
    }
}