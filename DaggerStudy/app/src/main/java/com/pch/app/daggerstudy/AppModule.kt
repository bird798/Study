package com.pch.app.daggerstudy

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(app : App) : SharedPreferences {
        return app.getSharedPreferences("default", Context.MODE_PRIVATE)
    }
}