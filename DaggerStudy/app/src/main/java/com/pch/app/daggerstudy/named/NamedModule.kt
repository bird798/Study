package com.pch.app.daggerstudy.named

import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class NamedModule {

    @Provides
    @Named("Hello")
    fun provideHello() : String {
        return "Hello"
    }

    @Provides
    @Named("World")
    fun provideWorld() : String {
        return "World"
    }
}