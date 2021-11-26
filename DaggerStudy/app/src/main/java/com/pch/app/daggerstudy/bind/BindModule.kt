package com.pch.app.daggerstudy.bind

import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class BindModule {

    @Binds
    abstract fun bindBindclass(value : BindClass) : IBind

    @Binds
    abstract fun bindBindclass2(value : BindClass2) : IBind

    companion object {
        @Provides
        fun providesString() = "Ninano"

        @Provides
        fun providesInt() : Number = 22
    }
}