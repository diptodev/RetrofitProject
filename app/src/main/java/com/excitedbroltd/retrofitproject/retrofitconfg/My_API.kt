package com.excitedbroltd.retrofitproject.retrofitconfg

import com.excitedbroltd.retrofitproject.modelclass.Posts
import retrofit2.Response
import retrofit2.http.GET

interface My_API {
    @GET("posts")
   suspend fun getAllPost(): Response<List<Posts>>
}