package com.excitedbroltd.retrofitproject.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.excitedbroltd.retrofitproject.modelclass.Posts
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

class Myviewmodel @Inject constructor(val repository: Repository) : ViewModel() {

    private var _allPost = MutableLiveData<Response<List<Posts>>>()
//    var allPost = MutableLiveData<Response<List<Persons>>>()
//        get() = _allPost

    fun allPost() {
        viewModelScope.launch {
            _allPost.value = repository.getAllPost()
        }
    }

    fun getAllPost() = _allPost
}