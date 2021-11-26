package com.pch.app.daggerstudy.singleton

import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class SingletonModule {

    @Provides
    fun provideAnyObject() : Any {
        return Any()
    }

    @Provides
    @Singleton
    @Named("Singleton")
    fun provideSingletonObject() : Any {
        return Any()
    }
}