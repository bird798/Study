package com.pch.app.daggerstudy.multibinding

import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet

@Module
class ChildModule {

    @Provides
    @IntoSet
    fun string3() = "Child string 1"


    @Provides
    @IntoSet
    fun string4() = "Child string 2"
}