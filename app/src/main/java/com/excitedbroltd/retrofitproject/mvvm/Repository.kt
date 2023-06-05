package com.excitedbroltd.retrofitproject.mvvm

import com.excitedbroltd.retrofitproject.modelclass.Posts
import com.excitedbroltd.retrofitproject.retrofitconfg.My_API
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(val myApi: My_API) {
    suspend fun getAllPost(): Response< List<Posts>>  {
        return myApi.getAllPost()
    }
}