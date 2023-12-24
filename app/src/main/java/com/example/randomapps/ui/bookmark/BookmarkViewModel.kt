package com.example.randomapps.ui.bookmark

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.randomapps.database.Note
import com.example.randomapps.repository.NoteRepository

class BookmarkViewModel(application: Application):ViewModel() {

    private val mNoteRepository:NoteRepository = NoteRepository(application)

    fun getAllNotes():LiveData<List<Note>> = mNoteRepository.getAllNotes()
}