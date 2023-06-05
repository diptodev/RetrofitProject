package com.excitedbroltd.retrofitproject.di

import android.app.Application

class MyApplication : Application() {
      lateinit var myViewModelComponent: MyViewModelComponent
    override fun onCreate() {
        super.onCreate()
        myViewModelComponent = DaggerMyViewModelComponent.builder().build()
    }
}