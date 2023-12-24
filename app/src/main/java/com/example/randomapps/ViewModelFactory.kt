package com.example.randomapps

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.randomapps.ui.insert.NoteAddUpdateViewModel
import com.example.randomapps.ui.bookmark.BookmarkViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory private constructor(private val mApplication:Application):ViewModelProvider.NewInstanceFactory(){
    companion object{
        @Volatile
        private var INSTANCE:ViewModelFactory? = null

        @JvmStatic
        fun getInstance(application: Application):ViewModelFactory{
            if (INSTANCE == null) {
                synchronized(ViewModelFactory::class.java) {
                    INSTANCE = ViewModelFactory(application)
                }
            }

            return INSTANCE as ViewModelFactory
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BookmarkViewModel::class.java)){
            return BookmarkViewModel(application = mApplication) as T
        }
        else if (modelClass.isAssignableFrom(NoteAddUpdateViewModel::class.java)) {
            return NoteAddUpdateViewModel(mApplication) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
}