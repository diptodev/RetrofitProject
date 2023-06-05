package com.excitedbroltd.retrofitproject.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class MyViewModelFactory @Inject constructor() : ViewModelProvider.Factory {
    @Inject
    lateinit var myviewmodel: Myviewmodel
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(myviewmodel::class.java))
            return myviewmodel as T
        throw IllegalArgumentException("Something is going wrong")
    }
}