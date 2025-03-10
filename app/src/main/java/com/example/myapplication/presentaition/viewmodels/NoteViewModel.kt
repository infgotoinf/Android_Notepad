package com.example.myapplication.presentaition.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.myapplication.domain.models.Note
import com.example.myapplication.domain.usecases.GetNotesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class NoteViewModel(private val getNotesUseCase: GetNotesUseCase) : ViewModel() {
    private val _users = MutableStateFlow<List<Note>>(emptyList())
    val users: StateFlow<List<Note>> = _users

    init {
        fetchUsers()
    }

    private fun fetchUsers() = viewModelScope.launch {

        val result = getNotesUseCase()
        _users.value= result
    }

}