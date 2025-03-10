package com.example.myapplication.domain.models

import android.icu.text.DateFormat

data class Note(val title: String,
                val dateCreated: DateFormat,
                val dateLastEdited: DateFormat,
                val data: String,)