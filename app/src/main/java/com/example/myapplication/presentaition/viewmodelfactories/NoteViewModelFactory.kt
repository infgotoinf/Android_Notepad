package com.example.myapplication.presentaition.viewmodelfactories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.domain.usecases.GetNotesUseCase
import com.example.myapplication.presentaition.viewmodels.NoteViewModel

@Suppress("UNCHECKED_CAST")
class NoteViewModelFactory(private val getNotesUseCase: GetNotesUseCase): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NoteViewModel(getNotesUseCase) as T
    }

}