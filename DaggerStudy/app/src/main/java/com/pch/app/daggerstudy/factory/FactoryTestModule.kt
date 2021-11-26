package com.pch.app.daggerstudy.factory

import dagger.Module
import dagger.Provides
import javax.inject.Inject

@Module
class FactoryTestModule {

    val str  = "Test String"
    val number = 20140316

    @Provides
    fun getString(): String {
        return str
    }

//    @Provides
    fun getInt() : Int {
        return number
    }
}