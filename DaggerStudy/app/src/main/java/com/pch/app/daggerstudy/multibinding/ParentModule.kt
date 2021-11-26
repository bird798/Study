package com.pch.app.daggerstudy.multibinding

import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet

@Module(subcomponents = [ChildComponent::class])
class ParentModule {

    @Provides
    @IntoSet
    fun string1() = "Parent string 1"

    @Provides
    @IntoSet
    fun string2() = "Parent string 2"

}