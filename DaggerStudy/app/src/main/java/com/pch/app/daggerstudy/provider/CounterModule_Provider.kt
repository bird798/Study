package com.pch.app.daggerstudy.provider

import dagger.Module
import dagger.Provides

@Module
class CounterModule_Provider {

    var next : Int = 100

    @Provides
    fun providerInterger(): Int? {
        println("Computing....")
        return next++
    }
}