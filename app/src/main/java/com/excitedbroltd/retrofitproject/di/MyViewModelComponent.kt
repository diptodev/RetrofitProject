package com.excitedbroltd.retrofitproject.di

import com.excitedbroltd.retrofitproject.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MyViewModelModule::class])
interface MyViewModelComponent {
    fun inject(mainActivity: MainActivity)
}