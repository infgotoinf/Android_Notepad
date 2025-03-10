package com.example.myapplication.presentaition.viewmodelfactories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.domain.usecases.AddNoteUseCase
import com.example.myapplication.presentaition.viewmodels.AddNoteViewModel

@Suppress("UNCHECKED_CAST")
class AddNoteViewModelFactory(private val addNoteUseCase: AddNoteUseCase): ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AddNoteViewModel(addNoteUseCase) as T
    }
}