package com.excitedbroltd.retrofitproject.di

import com.excitedbroltd.retrofitproject.retrofitconfg.My_API
import com.excitedbroltd.retrofitproject.retrofitconfg.Retrofit_cnfg
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MyViewModelModule {
    @Provides
    @Singleton
    fun getRetorfitInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(Retrofit_cnfg.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Provides
    fun getApi(retrofit: Retrofit): My_API {
        return retrofit.create(My_API::class.java)
    }
}