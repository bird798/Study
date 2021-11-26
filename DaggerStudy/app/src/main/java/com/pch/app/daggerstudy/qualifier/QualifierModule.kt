package com.pch.app.daggerstudy.qualifier

import dagger.Module
import dagger.Provides

@Module
class QualifierModule {

    @Provides
    @Hello_Kot
    fun provideHello() : String {
        return "Hello"
    }

    @Provides
    fun provideWorld() : String  {
        return "World"
    }
}