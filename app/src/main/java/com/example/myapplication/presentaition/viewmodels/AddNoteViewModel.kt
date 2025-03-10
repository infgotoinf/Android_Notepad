package com.example.myapplication.presentaition.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.models.Note
import com.example.myapplication.domain.usecases.AddNoteUseCase
import kotlinx.coroutines.launch

class AddNoteViewModel(private val addNoteUseCase: AddNoteUseCase) : ViewModel() {

    fun addUser(note: Note) = viewModelScope.launch {
        addNoteUseCase(note = note)

    }
}