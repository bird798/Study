package com.pch.app.daggerstudy.lazy_kot

import dagger.Module
import dagger.Provides

@Module
class CounterModule_Kot {

    var next : Int = 100

    @Provides
    fun providerInterger(): Int? {
        println("Computing....")
        return next++
    }
}