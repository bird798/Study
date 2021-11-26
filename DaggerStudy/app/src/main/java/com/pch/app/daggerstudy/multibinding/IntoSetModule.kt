package com.pch.app.daggerstudy.multibinding

import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet

@Module
class IntoSetModule {

    @Provides
    @IntoSet
    fun provideHello() = "Hello"

    @Provides
    @IntoSet
    fun provideWorld() = "World"
}
