package com.example.myapplication.domain.usecases

import com.example.myapplication.domain.models.Note
import com.example.myapplication.domain.repositories.GetNotesRepository

class GetNotesUseCase(private val getNotesRepository: GetNotesRepository){

       suspend operator fun invoke(): List<Note>{
        return  getNotesRepository.getNotes()
    }

}