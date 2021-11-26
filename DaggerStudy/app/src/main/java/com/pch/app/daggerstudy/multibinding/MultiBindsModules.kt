package com.pch.app.daggerstudy.multibinding

import dagger.Module
import dagger.Provides
import dagger.multibindings.ElementsIntoSet
import dagger.multibindings.IntoMap
import dagger.multibindings.IntoSet
import dagger.multibindings.Multibinds

@Module
abstract class MultiBindsModules {

    @Multibinds
    abstract fun strings() : Set<String>

    companion object {

        @Provides
        @IntoSet
        fun getString() = "Ninano"

        @Provides
        @IntoSet
        fun getString1() = "Ninano2"

        @Provides
        @IntoSet
        fun getString2() = "Ninano3"

        @Provides
        @ElementsIntoSet
        fun getStrings() = setOf("123", "456", "789")

    }
}