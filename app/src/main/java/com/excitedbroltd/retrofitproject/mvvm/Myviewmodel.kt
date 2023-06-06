package com.excitedbroltd.retrofitproject.mvvm

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.excitedbroltd.retrofitproject.modelclass.Posts
import kotlinx.coroutines.launch
import javax.inject.Inject

class Myviewmodel @Inject constructor(val repository: Repository) : ViewModel() {

    var _allPost: MutableState<List<Posts>> = mutableStateOf(listOf())
//    var allPost = MutableLiveData<Response<List<Persons>>>()
//        get() = _allPost

    fun allPost() {
        viewModelScope.launch {
            _allPost.value = repository.getAllPost().body()!!
        }
    }

    fun getAllPost() = _allPost
}